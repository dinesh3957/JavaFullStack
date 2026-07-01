package com.Streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapStreamDemo {

    public static void main(String[] args) {

        Map<String, String> people = new HashMap<>();

        people.put("polo", "pune");
        people.put("mili", "mum");
        people.put("deny", "delhi");

        List<String> cities = people.values()
                                    .stream()
                                    .map(c -> c.toUpperCase())
                                    .sorted()
                                    .collect(Collectors.toList());

        System.out.println("Cities:");
        cities.forEach(System.out::println);

        Map<String, List<String>> contact = new HashMap<>();

        contact.put("Frudo", Arrays.asList("121212", "56565-563"));
        contact.put("sean", Arrays.asList("122517-122", "89892-27972"));
        contact.put("ben", Arrays.asList("213321", "7686238-28989"));

        System.out.println("\nAll Phone Numbers:");
        contact.values()
               .stream()
               .flatMap(Collection::stream)
               .forEach(System.out::println);

        System.out.println("\nPhone Numbers Containing 8:");
        contact.values()
               .stream()
               .flatMap(Collection::stream)
               .filter(s -> s.contains("8"))
               .forEach(System.out::println);

        long count = contact.values()
                            .stream()
                            .flatMap(Collection::stream)
                            .filter(s -> s.contains("8"))
                            .count();

        System.out.println("\nCount = " + count);
        
        
        contact.values()
        .stream()
        .flatMap(Collection::stream)
        .map(s -> s.replace("-", ""))
        .forEach(System.out::println);

        
    }
}