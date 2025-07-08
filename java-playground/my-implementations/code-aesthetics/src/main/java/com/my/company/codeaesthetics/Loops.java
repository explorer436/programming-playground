package com.my.company.codeaesthetics;

import com.github.javafaker.Faker;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.apache.commons.lang3.time.StopWatch;
import org.jspecify.annotations.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loops {

    public record User(
            String name, String age) {}

    static StopWatch watch = new StopWatch();

    static Faker faker = new Faker();

    static Random random = new Random();

    public static void main(String[] args) {
        List<User> users = new ArrayList<>(List.of());

        for (int i = 0; i < 100; i++) {
            users.add(new User(
                    faker.name().firstName(),
                    String.valueOf(random.ints(1, 100).findFirst().getAsInt())
            ));
        }

        printAdultNames_for_loop(users);

        printAdultNames_filter_map(users);

        printAdultNames_list_comprehension_pure_java(users);

        printAdultNames_guava_filter(users);

        printAdultNames_guava_filter_using_predicates(users);

        printAdultNames_guava_filter_transform(users);
    }

    private static void printAdultNames_for_loop(List<User> users) {
        watch.start();
        List<String> adultNames = new ArrayList<>(List.of());
        for (User user : users) {
            if (Integer.parseInt(user.age) >= 18) {
                adultNames.add(user.name);
            }
        }

        watch.stop();
        System.out.println(adultNames);
        System.out.println("Printing names using for loop took " + watch.getNanoTime() + " nano seconds.");
    }

    private static void printAdultNames_filter_map(List<User> users) {
        watch.reset();
        watch.start();

        List<String> adultNames = users.stream().filter(u -> Integer.parseInt(u.age) >= 18).map(u -> u.name).toList();

        watch.stop();
        System.out.println(adultNames);
        System.out.println("Printing names using filter map took " + watch.getNanoTime() + " nano seconds.");
    }

    private static void printAdultNames_list_comprehension_pure_java(List<User> users) {

        watch.reset();
        watch.start();

        List<String> adultNames = map_using_custom_java_interface(users, new Func<User, String>() {
            public String apply(User u) {
                if (Integer.parseInt(u.age) >= 18) {
                    return u.name;
                }
                return "";
            }
        });

        watch.stop();
        System.out.println(adultNames);
        System.out.println("Printing names using java list comprehension took " + watch.getNanoTime() + " nano seconds.");
    }

    // Custom interface
    public interface Func<In, Out> {
        Out apply(In in);
    }

    // map function using Custom interface
    public static <In, Out> List<Out> map_using_custom_java_interface(List<In> in, Func<In, Out> f) {
        List<Out> out = new ArrayList<Out>(in.size());
        for (In inObj : in) {
            out.add(f.apply(inObj));
        }
        return out;
    }

    private static void printAdultNames_guava_filter(List<User> users) {

        watch.reset();
        watch.start();

        // Filter using Iterable.filter()
        // Transform using Iterable.transform()
        Iterable<String> adultNames = Iterables.transform(Iterables.filter(users, u -> Integer.parseInt(u.age) >= 18), u -> u.name);

        watch.stop();
        System.out.println(adultNames);
        System.out.println("Printing names using guava filter took " + watch.getNanoTime() + " nano seconds.");
    }

    private static void printAdultNames_guava_filter_using_predicates(List<User> users) {

        watch.reset();
        watch.start();

        Predicate<User> predicate = new Predicate<User>() {
            @Override
            public boolean apply(User u) {
                return Integer.parseInt(u.age) >= 18;
            }
        };
        Iterable<String> adultNames = Iterables.transform(Iterables.filter(users, predicate), u -> u.name);

        watch.stop();
        System.out.println(adultNames);
        System.out.println("Printing names using guava filter and predicates took " + watch.getNanoTime() + " nano seconds.");
    }

    private static void printAdultNames_guava_filter_transform(List<User> users) {

        watch.reset();
        watch.start();

        Predicate<User> predicateFunction = new Predicate<User>() {
            @Override
            public boolean apply(User u) {
                return Integer.parseInt(u.age) >= 18;
            }
        };

        Function<User, String> transformationFunction = new Function<User,String>(){
            @Override
            public String apply(User u) {
                return u.name;
            }
        };

        ImmutableList<@NonNull String> adultNames = FluentIterable.from(users)
                .filter(predicateFunction)
                .transform(transformationFunction)
                .toList();

        watch.stop();
        System.out.println(adultNames);
        System.out.println("Printing names using guava filter transform took " + watch.getNanoTime() + " nano seconds.");
    }
}
