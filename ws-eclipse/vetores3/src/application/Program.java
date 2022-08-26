package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String[] vect= new String[] {"Maria", "Bob", "Alex"};
		
		for (String sV : vect) {
			System.out.println(sV);
		}
		
		sc.close();
	}
	
}
