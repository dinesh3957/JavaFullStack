package com.Day1.AlphaBeta;

public class AlphaBetaTest {

	public static void main(String[] args) {
		
		Alpha a = new Alpha();
		a.demo();
		
		Beta b = new Beta();
		b.test();
		b.demo();
		
		Alpha ab = b; // up- casting (implicit)
		ab.demo();
		
		Beta bt = (Beta)ab; // down- casting (explicit)
		bt.test();
		bt.demo();
	}

}
