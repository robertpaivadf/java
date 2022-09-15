package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		List<Product> list = new ArrayList<>();

		list.add(new Product("TV", 900.00));
		list.add(new Product("Notebook", 1200.00));
		list.add(new Product("Castle", 350.50));
		list.add(new Product("Action", 150.00));
		list.add(new Product("Berg", 45.00));
		list.add(new Product("Cobit", 1333.00));

		
		//achar a média usando pipeline
		double avg = list.stream()
				.map(p -> p.getPrice())
				.reduce(0.00, (x, y) -> x+y) / list.size();
		
		System.out.println("Average price: " + String.format("%.2f", avg));
		System.out.println("Lista de produtos: " + Arrays.toString(list.toArray()));
		
		//Usando comparator para ordenar usando .reversed()		
		Comparator<String> comp = (s1,s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
		
		List<String> names = list.stream()
				.filter(p -> p.getPrice() < avg)
				.map(p -> p.getName())
				.sorted(comp.reversed()) //usando o reversed do comparator para gerar resultado em ordem descrescente
				.collect(Collectors.toList());
		
		names.forEach(System.out::println);

		
	}
}