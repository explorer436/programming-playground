package reactive.programming.examples.flux_emitting_items_programmatically;

import reactive.programming.examples.flux_emitting_items_programmatically.assignment.FileReaderService;
import reactive.programming.examples.flux_emitting_items_programmatically.assignment.FileReaderServiceImpl;
import reactive.programming.examples.util.Util;

import java.nio.file.Path;

public class Lec09Assignment {

    public static void main(String[] args) {

        Path path = Path.of("src/main/resources/flux_emitting_items_programmatically_assignment/file.txt");
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        fileReaderService.read(path)
                .take(10)
                // .takeUntil(s -> s.equalsIgnoreCase("line17"))
                .subscribe(Util.subscriber());


    }

}
