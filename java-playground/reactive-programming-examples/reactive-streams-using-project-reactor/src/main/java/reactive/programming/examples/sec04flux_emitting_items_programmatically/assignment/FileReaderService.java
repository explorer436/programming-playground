package reactive.programming.examples.sec04flux_emitting_items_programmatically.assignment;

import reactor.core.publisher.Flux;

import java.nio.file.Path;

/**
 * - do the work only when it is subscribed
 * - do the work based on the demand
 * - stop producing when subscriber cancels
 * - produce only the requested items
 * - file should be closed once done
 */
public interface FileReaderService {

    Flux<String> read(Path path);

}
