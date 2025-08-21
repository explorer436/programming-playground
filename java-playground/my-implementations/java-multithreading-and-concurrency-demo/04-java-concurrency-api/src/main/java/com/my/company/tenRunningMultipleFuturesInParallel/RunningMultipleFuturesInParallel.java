package com.my.company.tenRunningMultipleFuturesInParallel;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RunningMultipleFuturesInParallel {

    private CompletableFuture<String> calculateHelloAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");
        return completableFuture;
    }

    private CompletableFuture<String> calculateBeautifulAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Beautiful");
        return completableFuture;
    }

    private CompletableFuture<String> calculateWorldAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "World");
        return completableFuture;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        RunningMultipleFuturesInParallel classUnderTest = new RunningMultipleFuturesInParallel();

        CompletableFuture<String> future1 = classUnderTest.calculateHelloAsync();
        CompletableFuture<String> future2 = classUnderTest.calculateBeautifulAsync();
        CompletableFuture<String> future3 = classUnderTest.calculateWorldAsync();

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();

        System.out.println(future1.isDone()); // true
        System.out.println(future2.isDone()); // true
        System.out.println(future3.isDone()); // true

        // The return type of the CompletableFuture.allOf() is a CompletableFuture<Void>.
        // The limitation of this method is that it does not return the combined results of all Futures.
        // Instead, we have to manually get results from Futures.
        // Fortunately, CompletableFuture.join() method and Java 8 Streams API makes it simple:

        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining("-"));
        System.out.println("combined: " + combined);
        // combined: Hello-Beautiful-World

        // -------------------------

        // Another example:
        // See downloadWebPage() below.
        // Now, when all the web pages are downloaded, you want to count the number of web pages that contain a keyword - ‘CompletableFuture’. Let’s use CompletableFuture.allOf() to achieve this:
        List<String> webPageLinks = Arrays.asList("link1", "link2");    // A list of 100 web page links

        // Download contents of all the web pages asynchronously
        List<CompletableFuture<String>> pageContentFutures = webPageLinks.stream()
                .map(webPageLink -> classUnderTest.downloadWebPage(webPageLink))
                .collect(Collectors.toList());

        // Create a combined Future using allOf()
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                pageContentFutures.toArray(new CompletableFuture[pageContentFutures.size()])
        );
        // The problem with CompletableFuture.allOf() is that it returns CompletableFuture<Void>.
        // But we can get the results of all the wrapped CompletableFutures by writing few additional lines of code -
        // When all the Futures are completed, call `future.join()` to get their results and collect the results in a list -
        CompletableFuture<List<String>> allPageContentsFuture = allFutures.thenApply(v -> {
            return pageContentFutures.stream()
                    .map(pageContentFuture -> pageContentFuture.join())
                    .collect(Collectors.toList());
        });

        // Let’s now count the number of web pages that contain our keyword -

        // Count the number of web pages having the "CompletableFuture" keyword.
        CompletableFuture<Long> countFuture = allPageContentsFuture.thenApply(pageContents -> {
            return pageContents.stream()
                    .filter(pageContent -> pageContent.contains("CompletableFuture"))
                    .count();
        });

        System.out.println("Number of Web Pages having CompletableFuture keyword - " + countFuture.get());
    }

    // Let’s say that you want to download the contents of 100 different web pages of a website.
    // You can do this operation sequentially but this will take a lot of time. 
    // So, write a function which takes a web page link, and returns a CompletableFuture,
    // i.e. It downloads the web page’s content asynchronously -
    public CompletableFuture<String> downloadWebPage(String pageLink) {
        return CompletableFuture.supplyAsync(() ->
                "Code to download and return the web page's content"
        );
    }
}
