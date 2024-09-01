package reactive.programming.examples.mono_examples.assignment;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class FileServiceImpl implements FileService {

    // private static final Path PATH = Path.of("src/main/resources/assignment");
    private static final Path PATH = Paths.get("src/main/resources/assignment").toAbsolutePath().normalize();

    @Override
    public Mono<String> read(String fileName) {
        // because readString() throws IOException
        return Mono.fromCallable(() -> Files.readString(PATH.resolve(fileName)));
    }

    @Override
    public Mono<Void> write(String fileName, String content) {
        return Mono.fromRunnable(() -> writeFile(fileName, content));
    }

    @Override
    public Mono<Void> delete(String fileName) {
        return Mono.fromRunnable(() -> deleteFile(fileName));
    }

    private void writeFile(String fileName, String content){
        try {
            createRootDirectory();
            Files.writeString(PATH.resolve(fileName), content);
            log.info("created {}", fileName);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void createRootDirectory() {
        try {
            Path p = Files.createDirectories(PATH);
            log.info("created path : {}", p);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    private void deleteFile(String fileName){
        try {
            Files.delete(PATH.resolve(fileName));
            log.info("deleted {}", fileName);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
