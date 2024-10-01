package com.my.company.common.validation;

import com.my.company.common.exception.EventAlreadyProcessedException;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/*
    With kafka, there is always a possibility of duplicate messages coming from the topic.
    This class is to validate the incoming messages to make sure that it is not a duplicate.
 */
@Slf4j
public class DuplicateEventValidator {

    // We can pass a second publisher to the validate function - which gets executed if the validation fails.
    // See the commented code in PaymentServiceImpl, InventoryServiceImpl and ShippingServiceImpl.
    /*public static <T> Mono<T> validate(Mono<Boolean> eventValidationPublisher, Mono<T> eventProcessingPublisher){
        return eventValidationPublisher
                .transform(emitErrorForRedundantProcessing())
                .then(eventProcessingPublisher)
                ;
    }*/

    public static <T> Mono<Void> validate(Mono<Boolean> eventValidationPublisher){
        Mono<Void> validationResult = eventValidationPublisher
                .transform(emitErrorForRedundantProcessing())
                .then();
        return validationResult;
    }

    /*
        pseudo-code to show how validate() is expected to be used by the classes in the sub-modules.

            DuplicateEventValidator.validate(  isPresentInDB(some-id), process(some-id) )
                                .doOnNext(...)
                                .map(...)
                                ...
                                ...


       If the validate() returns error, the entire pipeline will stop.
       If not, eventProcessingPublisher will be returned and then, the pipeline will proceed with the happy-path scenario.

     */

    public static Function<Mono<Boolean>, Mono<Void>> emitErrorForRedundantProcessing() {
        return mono -> mono
                .flatMap(
                        // ternary operator to see if the first Mono is true or not.
                        // if it is true, it means that it is a duplicate. raise an error to stop reactive pipelines.
                        // if it is not true, just return Mono.empty
                        b -> b ? Mono.error(new EventAlreadyProcessedException()) : Mono.empty())
                .doOnError(EventAlreadyProcessedException.class, ex -> log.warn("Duplicate event"))
                .then();
    }

}
