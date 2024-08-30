package reactive.programming.examples.custom_implementation_of_the_interfaces.publisher;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class PublisherImpl implements Publisher<String> {

    @Override
    public void subscribe(Subscriber<? super String> subscriber) {

        // The Publisher just gives the Subscription object to the Subscribers.

        Subscription subscription = new SubscriptionImpl(subscriber);

        // Give subscription reference to subscriber.
        // Give subscriber reference to subscription.
        // Both the subscriber and the subscription will know about each other.

        subscriber.onSubscribe(subscription);
    }

}
