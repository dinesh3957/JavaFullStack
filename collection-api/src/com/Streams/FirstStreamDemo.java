package com.Streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FirstStreamDemo {

	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static int add(int a, int b) {
		return a + b;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] arr = { 2, 4, 5, 2, };
		List<Integer> number = Arrays.asList(arr);
// for(int n:number) {
//	 System.out.println(n);
// }
// 
// Stream<Integer>str1=number.stream();
// str1.forEach(System.out::println);
// System.out.println(str1.count());
//  

// number.stream().distinct().forEach(System.out::println);

//System.out.println(number.stream().distinct().count());

// System.out.println(number.stream().filter(n->n>5).count());

// number.stream().distinct().sorted().forEach(System.out::println); 

// System.out.println(number.stream().reduce(0,(n,m)->n+m));

// System.out.println(number.stream().reduce(0,Integer::sum));

// System.out.println(number.stream().reduce(0,FirstStreamDemo::add));
// 
// number.stream().limit(5).forEach(System.out::println);
		
		IntStream istr=IntStream.range(1,99);
//		System.out.println(istr.count());
//		System.out.println(istr.sum());
//		System.out.println(istr.skip(50).sum());
//		
//		
//		IntStream istr2=IntStream.of(5,9,23,46);
//		System.out.println(istr2.count());
//		System.out.println(istr2.sum());
//		
//		
		IntSummaryStatistics statics=istr.summaryStatistics();
		System.out.println(statics);

	}

}
