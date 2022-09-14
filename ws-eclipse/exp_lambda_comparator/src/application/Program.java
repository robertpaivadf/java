package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Tablet", 450.00));
		list.add(new Product("Action", 150.00));
		list.add(new Product("Berg", 45.00));
		list.add(new Product("Cobit", 333.00));

		list.removeIf(p -> p.getName() == "Berg");
		
		list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

		//list.forEach(Product::consumerProd);
		list.forEach(p -> p.setPrice(p.getPrice()*1.1));
		
		list.forEach(System.out::println);
		
		/*for (Product p : list) {
			System.out.println(p);
		}*/
	}
}