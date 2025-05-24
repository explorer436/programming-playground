use std::path::{Path, PathBuf};
use std::env;
use std::io;
use std::collections::HashSet;
use walkdir::WalkDir; // Import WalkDir

fn find_folders_with_extension_walkdir(
    start_dir: &Path,
    target_extension: &str,
) -> io::Result<HashSet<PathBuf>> {
    let mut found_folders = HashSet::new();

    for entry_result in WalkDir::new(start_dir) {
        let entry = match entry_result {
            Ok(e) => e,
            Err(err) => {
                // Optionally print error for inaccessible paths, or just skip
                eprintln!("Warning: Could not access {:?}: {}", err.path().unwrap_or_else(|| Path::new("?")), err);
                continue;
            }
        };
        let path = entry.path();

        if path.is_file() {
            if let Some(ext) = path.extension() {
                if let Some(ext_str) = ext.to_str() {
                    if ext_str.eq_ignore_ascii_case(target_extension) {
                        // Get the parent directory of this file
                        if let Some(parent_dir) = path.parent() {
                            // Ensure parent_dir is an actual directory and not, e.g. root if path is "/file.txt"
                            if parent_dir.is_dir() {
                                found_folders.insert(parent_dir.to_path_buf());
                            }
                        }
                    }
                }
            }
        }
    }
    Ok(found_folders)
}

fn main() -> io::Result<()> {
    let args: Vec<String> = env::args().collect();

    if args.len() < 3 {
        eprintln!("Usage: {} <directory> <extension_without_dot>", args[0]);
        std::process::exit(1);
    }

    let start_dir_str = &args[1];
    let mut target_extension = args[2].clone();

    if target_extension.starts_with('.') {
        target_extension.remove(0);
    }

    let start_dir = PathBuf::from(start_dir_str);

    if !start_dir.is_dir() {
        eprintln!("Error: '{}' is not a valid directory.", start_dir_str);
        std::process::exit(1);
    }

    println!(
        "Searching for folders in '{}' containing '.{}' files (using walkdir)...\n",
        start_dir.display(),
        target_extension
    );

    match find_folders_with_extension_walkdir(&start_dir, &target_extension) {
        Ok(folders_set) => {
            if folders_set.is_empty() {
                println!("No folders found containing '.{}' files.", target_extension);
            } else {
                println!("Folders containing '.{}' files:", target_extension);
                let mut sorted_folders: Vec<PathBuf> = folders_set.into_iter().collect();
                sorted_folders.sort();
                for folder in sorted_folders {
                    println!("{}", folder.display());
                }
            }
        }
        Err(e) => {
            eprintln!("Error during directory traversal: {}", e);
            std::process::exit(1);
        }
    }
    Ok(())
}