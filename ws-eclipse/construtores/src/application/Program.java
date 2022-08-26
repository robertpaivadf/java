package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
				
		System.out.println("Enter product data:");
		System.out.println("Name:");
		String name = sc.nextLine();
		
		System.out.println("Enter price data:");
		System.out.println("Price:");
		double price = sc.nextDouble();
				
		Product product = new Product(name, price);
	
		System.out.println(product);
		
		//Add product in Stock
		System.out.println("Enter the number of products to be added in stock: ");
		int quantity = sc.nextInt();
		product.addProducts(quantity);		
		System.out.println(product);
		
		
		System.out.println("Enter the number of products to be revoved in stock: ");
		quantity = sc.nextInt();
		product.removeProducts(quantity);		
		System.out.println(product);		
		
		
		sc.close();
		
	}

}
