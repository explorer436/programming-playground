package reactive.programming.examples.sec06operators;

import reactive.programming.examples.sec06operators.assignment.ExternalServiceClient;
import reactive.programming.examples.utilities.Util;

/*
    Ensure that the external service is up and running!
 */
public class Lec11Assignment {

    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        for (int i = 1; i < 5; i++) {
            client.getProductName(i)
                    .subscribe(Util.subscriber());
        }

        Util.sleepSeconds(3);

    }

}
