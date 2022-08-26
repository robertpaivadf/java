package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite quantidade de produtos");
		int n = sc.nextInt();
		
		Product[] vect= new Product[n];
				
		for(int i=0; i<vect.length; i++) {
			sc.nextLine();
			System.out.println("Digite o nome do produto " + (i+1));
			String name = sc.nextLine();
			System.out.println("Digite o preço do produto " + (i+1));
			double price = sc.nextDouble();
			vect[i] = new Product(name, price);			
		}
		
		double sum = 0.00;
		for(int i=0; i<vect.length; i++) {
			sum += vect[i].getPrice();
		}
		
		double avg = sum/n;
		
		System.out.println();
		
		System.out.println("This are the products: ");
		for(int i=0; i<vect.length; i++) {
			System.out.println(vect[i].getName());			
		}
		System.out.println();
		System.out.printf("Average Height: %.2f%n" , avg);
		
		sc.close();
	}
	
}
