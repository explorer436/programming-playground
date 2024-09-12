package com.my.company.processapi;

import java.util.stream.Stream;

public class DestroyProcessesTestDriver {

    public static void main(String[] args) {
        Stream<ProcessHandle> childProc = ProcessHandle.current().children();
        childProc.forEach(procHandle -> {
            // procHandle.destroy();
        });
    }

}
