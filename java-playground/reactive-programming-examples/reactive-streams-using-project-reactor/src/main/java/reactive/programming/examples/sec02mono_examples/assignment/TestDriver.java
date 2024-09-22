package reactive.programming.examples.sec02mono_examples.assignment;

import reactive.programming.examples.utilities.Util;

public class TestDriver {

    public static void main(String[] args) {
        var fileService = new FileServiceImpl();

        fileService.write("file.txt", "This is a test file").subscribe(Util.subscriber());

        fileService.read("file.txt").subscribe(Util.subscriber());

        fileService.delete("file.txt").subscribe(Util.subscriber());
    }

}
