package com.my.company.codeaesthetics;

import java.util.ArrayList;
import java.util.List;

public class Loops {

    public record User(
            String name, String age) {}

    public static void main(String[] args) {
        List<User> users = List.of(new User("Alice", "28"), new User("Bob", "17"), new User("Carol", "35"));

        printAdultNames_for_loop(users);

        printAdultNames_filter_map(users);

        printAdultNames_list_comprehension_pure_java(users);
    }

    private static void printAdultNames_for_loop(List<User> users) {
        List<String> adultNames = new ArrayList<>(List.of());
        for (User user : users) {
            if (Integer.parseInt(user.age) >= 18) {
                adultNames.add(user.name);
            }
        }

        System.out.println(adultNames);
    }

    private static void printAdultNames_filter_map(List<User> users) {
        List<String> adultNames = users.stream().filter(u -> Integer.parseInt(u.age) >= 18).map(u -> u.name).toList();
        System.out.println(adultNames);
    }

    private static void printAdultNames_list_comprehension_pure_java(List<User> users) {
        List<String> adultNames = map_using_custom_java_interface(users, new Func<User, String>() {
            public String apply(User u) {
                if (Integer.parseInt(u.age) >= 18) {
                    return u.name;
                }
                return "";
            }
        });
        System.out.println(adultNames);
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
}
