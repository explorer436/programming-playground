package reactive.programming.examples.sec03flux_examples_with_in_memory_data;


import reactive.programming.examples.sec03flux_examples_with_in_memory_data.client.ExternalServiceClient;
import reactive.programming.examples.utilities.Util;

/**
 * To demo non-blocking IO with streaming messages
 * Ensure that the external service is up and running!
 */
public class Lec08NonBlockingStreamingMessages {

    public static void main(String[] args) {

        ExternalServiceClient client = new ExternalServiceClient();

        client.getNames()
                .subscribe(Util.subscriber("sub1"));

        client.getNames()
                .subscribe(Util.subscriber("sub2"));

        Util.sleepSeconds(6);

    }

}
