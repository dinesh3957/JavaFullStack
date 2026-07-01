package com.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;



public class SecondStremDemo {

	public static void main(String[] args) {
		
		List<String>basket=Arrays.asList("cheery","mango","papaya","gauva");
		basket.forEach(System.out::println);
		basket.stream().sorted().forEach(System.out::println);
		
		basket.stream().map(s->s.toUpperCase()).forEach(System.out::println);
	
		basket.stream().filter(s->s.contains("a")).forEach(System.out::println);
		
		System.out.println(basket.stream().filter(s->s.contains("a")).count());
		
		Stream.of("jim","anna","sam","brad","leo").sorted().forEach(System.out::println);
		
	}

}
