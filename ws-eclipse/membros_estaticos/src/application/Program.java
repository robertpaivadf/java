package application;

import java.util.Locale;
import java.util.Scanner;

import util.Calculator;

public class Program {

	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Enter radius: ");
		double radius = sc.nextDouble();
			
		double c = Calculator.circuference(radius);
		
		double v = Calculator.volume(radius);
		
		System.out.printf("Circufenrence: %.2f%n", c);
		System.out.printf("Volume: %.2f%n", v);
		System.out.printf("Value of PI: %.5f%n", Calculator.PI);
		
		sc.close();
	}
	
	
	

}
