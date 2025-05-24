use std::fs;
use std::path::{Path, PathBuf};
use std::env;
use std::io;
use std::collections::HashSet; // To avoid printing the same directory multiple times if walkdir is used

// --- Option 1: Using custom recursive function (more direct for this specific problem) ---
fn find_folders_with_extension_recursive(
    dir_path: &Path,
    target_extension: &str,
    found_folders: &mut HashSet<PathBuf> // Use HashSet to avoid duplicate prints
) -> io::Result<()> {
    let mut has_matching_file_in_current_dir = false;
    let mut subdirs_to_visit = Vec::new();

    if !dir_path.is_dir() {
        return Ok(()); // Not a directory, nothing to do
    }

    // First pass: check files in the current directory and collect subdirectories
    for entry_result in fs::read_dir(dir_path)? {
        let entry = entry_result?;
        let path = entry.path();

        if path.is_file() {
            if let Some(ext) = path.extension() {
                // Convert OsStr to &str for comparison
                if let Some(ext_str) = ext.to_str() {
                    if ext_str.eq_ignore_ascii_case(target_extension) {
                        has_matching_file_in_current_dir = true;
                        // We can't break here yet, need to collect all subdirs
                    }
                }
            }
        } else if path.is_dir() {
            subdirs_to_visit.push(path);
        }
    }

    // If a matching file was found in this directory, add it to our set
    if has_matching_file_in_current_dir {
        found_folders.insert(dir_path.to_path_buf());
    }

    // Second pass: recurse into subdirectories
    for subdir in subdirs_to_visit {
        find_folders_with_extension_recursive(&subdir, target_extension, found_folders)?;
    }

    Ok(())
}

fn main() -> io::Result<()> {
    let args: Vec<String> = env::args().collect();

    if args.len() < 3 {
        eprintln!("Usage: {} <directory> <extension_without_dot>", args[0]);
        eprintln!("Example: {} . txt", args[0]);
        eprintln!("Example: {} /home/user/docs pdf", args[0]);
        std::process::exit(1);
    }

    let start_dir_str = &args[1];
    let mut target_extension = args[2].clone();

    // Normalize extension: remove leading dot if present
    if target_extension.starts_with('.') {
        target_extension.remove(0);
    }
    // Convert to lowercase for case-insensitive comparison, as eq_ignore_ascii_case handles the other side.
    // target_extension = target_extension.to_lowercase(); // Not strictly needed if using eq_ignore_ascii_case

    let start_dir = PathBuf::from(start_dir_str);

    if !start_dir.is_dir() {
        eprintln!("Error: '{}' is not a valid directory.", start_dir_str);
        std::process::exit(1);
    }

    println!(
        "Searching for folders in '{}' containing '.{}' files...\n",
        start_dir.display(),
        target_extension
    );

    let mut found_folders_set = HashSet::new();

    // --- Using the recursive function ---
    if let Err(e) = find_folders_with_extension_recursive(&start_dir, &target_extension, &mut found_folders_set) {
        eprintln!("Error during directory traversal: {}", e);
        std::process::exit(1);
    }

    if found_folders_set.is_empty() {
        println!("No folders found containing '.{}' files.", target_extension);
    } else {
        println!("Folders containing '.{}' files:", target_extension);
        // Sort for consistent output (optional)
        let mut sorted_folders: Vec<PathBuf> = found_folders_set.into_iter().collect();
        sorted_folders.sort();
        for folder in sorted_folders {
            println!("{}", folder.display());
        }
    }

    Ok(())
}