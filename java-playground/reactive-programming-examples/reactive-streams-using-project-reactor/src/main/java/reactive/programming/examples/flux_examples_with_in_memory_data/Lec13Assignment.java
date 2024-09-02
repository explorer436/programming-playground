package reactive.programming.examples.flux_examples_with_in_memory_data;


import reactive.programming.examples.flux_examples_with_in_memory_data.assignment.StockPriceObserver;
import reactive.programming.examples.flux_examples_with_in_memory_data.client.ExternalServiceClient;
import reactive.programming.examples.util.Util;

/**
 * Ensure that the external service is up and running!
 *
 * 1. Create a subscriber with a starting balance of $1000.
 * 2. Whenever the price drops below 90, you buy a stock.
 * 3. When the price goes above 110,
 *    - sell all the quantities
 *    - cancel the subscription
 *    - print the profit you made
 */
public class Lec13Assignment {

    public static void main(String[] args) {

        ExternalServiceClient client = new ExternalServiceClient();
        StockPriceObserver subscriber = new StockPriceObserver();
        client.getPriceChanges().subscribe(subscriber);

        Util.sleepSeconds(20);

    }

}
