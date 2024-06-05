use std::fs;
use std::fs::ReadDir;
use std::process::Command;
use std::time::Instant;

fn main() {
    let start = Instant::now();

    cleanup();

    regenerate();

    println!("--- done ---");

    let duration = start.elapsed();

    println!("Time elapsed is: {:?}", duration.as_secs());
}

#[warn(dead_code)]
fn cleanup() {

    Command::new("sh")
        .arg("-c")
        .arg("find /home/explorer436/Downloads/GitRepositories/hugo-blog/org -name \"*~*\" -delete")
        .output()
        .expect("successful");

    Command::new("sh")
        .arg("-c")
        .arg("rm -rf /home/explorer436/Downloads/GitRepositories/hugo-blog/content/posts/")
        .output()
        .expect("successful");

    Command::new("sh")
        .arg("-c")
        .arg("rm -rf /home/explorer436/Downloads/GitRepositories/hugo-blog/public/ox-hugo/")
        .output()
        .expect("successful");

    Command::new("sh")
        .arg("-c")
        .arg("rm -rf /home/explorer436/Downloads/GitRepositories/hugo-blog/static/ox-hugo/")
        .output()
        .expect("successful");

    Command::new("sh")
        .arg("-c")
        .arg("rm -rf /home/explorer436/Downloads/GitRepositories/hugo-blog/public/posts/")
        .output()
        .expect("successful");
}

fn regenerate() {
    let paths: ReadDir = fs::read_dir("/home/explorer436/Downloads/GitRepositories/hugo-blog/org/").unwrap();

    for path in paths {
        // println!("File Name: {}", path.unwrap().path().display());

        let mut owned_string: String = "emacs --batch -l /home/explorer436/Downloads/GitRepositories/hugo-blog/init.el -l /home/explorer436/Downloads/GitRepositories/hugo-blog/jethrow-publish.el --eval '(jethro/publish \"".to_owned();
        owned_string.push_str("/home/explorer436/Downloads/GitRepositories/hugo-blog/org/");
        owned_string.push_str(path.unwrap().file_name().to_str().unwrap());
        let borrowed_string: &str = "\")'";
        owned_string.push_str(borrowed_string);

        println!("owned_string: {}", owned_string);

        let output =
            Command::new("sh")
                .arg("-c")
                .arg(owned_string)
                .output()
                .expect("failed to execute process");

        let hello = output.stdout;
        let s = match std::str::from_utf8(&hello) {
            Ok(v) => v,
            Err(e) => panic!("Invalid UTF-8 sequence: {}", e),
        };

        println!("result: {}", s);
    }


    /*let output=
        Command::new("sh")
            .arg("-c")
            .arg("emacs --batch -l /home/explorer436/Downloads/GitRepositories/hugo-blog/init.el -l /home/explorer436/Downloads/GitRepositories/hugo-blog/jethrow-publish.el --eval '(jethro/publish \"/home/explorer436/Downloads/GitRepositories/hugo-blog/org/20230904180044-vim_search.org\")'")
            .output();
    ;

    let command_output = match &output {
        Ok(v) => v,
        Err(e) => panic!("Invalid UTF-8 sequence: {}", e),
    };

    // FIXME this  is not printing anything
    let s = String::from_utf8_lossy(&command_output.stdout);
    println!("result: {}", s);*/
}

