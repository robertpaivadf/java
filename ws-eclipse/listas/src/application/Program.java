package application;

import java.util.Locale;
//import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		List<String> list = new ArrayList<>();
		
		System.out.println("ADD ITENS NA LISTA");
		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Anna");		
		list.add("Paul");
		list.add(1,"Raul"); //inserindo elemento na posição 2
	
		for(String l : list) {
			System.out.println(l);
		}
		System.out.println();
	
		System.out.println("REMOVENDO ITENS DA LISTA");
		//list.remove("Anna"); //removendo pela comparação do valor		
		//list.remove(1); //removendo pela posição				
		list.removeIf(x -> x.charAt(0) =='M'); //removendo todos que começam com M
		
		for(String l : list) {
			System.out.println(l);
		}
		
		System.out.println();
		System.out.println("PESQUISANDO ITENS NA LISTA");
		System.out.println("Idex of Bob: " + (list.indexOf("Bob")+1));
		
		System.out.println();
		System.out.println("GERANDO UMA LISTA FILTRADA");
		List<String> result = list.stream().filter(x -> x.charAt(0)=='A').collect(Collectors.toList());
		for(String l : result) {
			System.out.println(l);
		}
		
		System.out.println();
		
		System.out.println("ENCONTRAR ELEMENTO NA LISTA");
		String name = list.stream().filter(x -> x.charAt(0)=='A').findFirst().orElse(null);
		System.out.println(name); 			
		
		System.out.println();
		System.out.println("TAMANHO DA LISTA");
		System.out.println(list.size());//tamanho da lista 
		
		 
		
	}
	
}
