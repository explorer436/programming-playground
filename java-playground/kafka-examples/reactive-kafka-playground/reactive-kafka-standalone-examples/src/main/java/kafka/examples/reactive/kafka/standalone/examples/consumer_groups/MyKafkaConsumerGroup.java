package kafka.examples.reactive.kafka.standalone.examples.consumer_groups;

/*
    Ensure that topic has multiple partitions
 */
public class MyKafkaConsumerGroup {

    private static class Consumer1{
        public static void main(String[] args) {
            MyKafkaConsumer.start("1");
        }
    }

    private static class Consumer2{
        public static void main(String[] args) {
            MyKafkaConsumer.start("2");
        }
    }

    private static class Consumer3{
        public static void main(String[] args) {
            MyKafkaConsumer.start("3");
        }
    }

}