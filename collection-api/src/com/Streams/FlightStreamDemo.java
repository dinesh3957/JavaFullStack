package com.Streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightStreamDemo {

	public static void main(String[] args) {

	    try (Stream<String> lines = Files.lines(Paths.get("src/Flight.txt"))) {

	        List<Flight> flights = lines
	                .map(line -> {
	                    String[] record = line.split(",");

	                    return new Flight(
	                            Integer.parseInt(record[0]), // code
	                            record[1],                   // carrier
	                            record[2],                   // source
	                            record[3]                    // destination
	                    );
	                })
	                .collect(Collectors.toList());

	        // Print all Flight objects
//	        flights.forEach(f -> {
//	            System.out.println(
//	                    "Code : " + f.getCode() +
//	                    ", Carrier : " + f.getCarrire() +
//	                    ", Source : " + f.getSource() +
//	                    ", Destination : " + f.getDestination()
//	            );
//	        });
	        
	        flights.stream().filter(f->f.getCode()==123).forEach(System.out::println);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    
	}
}