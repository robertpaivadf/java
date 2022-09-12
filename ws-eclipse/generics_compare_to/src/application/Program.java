package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Products;
import services.CalculationService;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		List<Products> list = new ArrayList<>();		
		
		list.add(new Products("Computador", 2500.00));
		list.add(new Products("Mesa", 500.00));
		list.add(new Products("Teclado", 150.00));
				
		Products x = CalculationService.max(list);
		System.out.println("Min:");
		System.out.println(x);
		System.out.println();
		x = CalculationService.min(list);
		System.out.println("Max:");
		System.out.println(x);
	}

}
