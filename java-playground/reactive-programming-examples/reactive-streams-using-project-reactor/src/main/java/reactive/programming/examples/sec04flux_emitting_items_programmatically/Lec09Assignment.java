package reactive.programming.examples.sec04flux_emitting_items_programmatically;

import reactive.programming.examples.sec04flux_emitting_items_programmatically.assignment.FileReaderService;
import reactive.programming.examples.sec04flux_emitting_items_programmatically.assignment.FileReaderServiceImpl;
import reactive.programming.examples.utilities.Util;

import java.nio.file.Path;

public class Lec09Assignment {

    public static void main(String[] args) {

        Path path = Path.of("/home/explorer436/Downloads/GitRepositories/programming-playground/java-playground/reactive-programming-examples/reactive-streams-using-project-reactor/src/main/resources/flux_emitting_items_programmatically_assignment/file.txt");
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        fileReaderService.read(path)
                .take(10)
                // .takeUntil(s -> s.equalsIgnoreCase("line17"))
                .subscribe(Util.subscriber());


    }

}
