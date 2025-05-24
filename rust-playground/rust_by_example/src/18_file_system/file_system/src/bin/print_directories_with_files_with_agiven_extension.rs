use std::fs;
use std::path::{Path, PathBuf};
use std::io;
use std::time::Instant;

fn main() -> io::Result<()> {

    let start1 = Instant::now();

    let target_extension = "HEIC";
    let start_dir = PathBuf::from("/home/explorer436/pCloudDrive/FromSync");

    if !start_dir.is_dir() {
        eprintln!("Error: '{:?}' is not a valid directory.", start_dir);
        std::process::exit(1);
    }

    println!(
        "Searching for folders in '{}' containing '.{}' files...\n",
        start_dir.display(),
        target_extension
    );

    // --- Using the recursive function ---
    if let Err(e) = find_folders_with_extension_recursive(&start_dir, &target_extension) {
        eprintln!("Error during directory traversal: {}", e);
        std::process::exit(1);
    }

    println!("---done---");
    let duration1 = start1.elapsed();
    println!("Time taken : {:?}", duration1);
    // For more human-readable output:
    println!(
        "Time taken by my_long_function: {} ms",
        duration1.as_millis()
    );
    
    Ok(())
}

// Using custom recursive function (more direct for this specific problem) ---
fn find_folders_with_extension_recursive(
    dir_path: &Path,
    target_extension: &str,
) -> io::Result<()> {

    if !dir_path.is_dir() {
        return Ok(()); // Not a directory, nothing to do
    }

    // First pass: check files in the current directory and collect subdirectories
    for entry_result in fs::read_dir(dir_path)? {
        let entry = entry_result?;
        let path = entry.path();

        if path.is_dir() {
            find_folders_with_extension_recursive(&path, target_extension)?;
        }

        if path.is_file() {
            if let Some(ext) = path.extension() {
                // Convert OsStr to &str for comparison
                if let Some(ext_str) = ext.to_str() {
                    // If a matching file was found in this directory, add it to our set
                    if ext_str.eq_ignore_ascii_case(target_extension) {
                        println!(
                            "Found '{}' files in '{}'",
                            target_extension,
                            dir_path.to_string_lossy(),
                        );
                        // We can't break here yet, need to collect all subdirs
                        break;
                    }
                }
            }
        }
    }

    Ok(())
}