package application;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Program {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>(); // Mais rápido
		// Set<String> set = new LinkedHashSet<>(); // Intermediário
		// Set<String> set = new TreeSet<>();//Mais lento
		set.add("TV");
		set.add("Notebook");
		set.add("Tablet");
		set.add("Mesa");

		System.out.println(set.contains("Notebook"));

		// PREDICADO: remover todo elemento x tal que x.lenght seja maior o igual a 3
		set.removeIf(x -> x.length() <= 2);

		// PREDICADO: remover todo elemento x tal que o primeiro caracter seja igual a T
		set.removeIf(x -> x.charAt(0) == 'T');

		for (String p : set) {
			System.out.println(p);
		}

		// operações com conjuntos

		System.out.println();
		Set<Integer> a = new TreeSet<>(Arrays.asList(0, 2, 4, 5, 6, 8, 10));
		Set<Integer> b = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9, 10));
		
		System.out.println("union");
		Set<Integer> c = new TreeSet<>(a);
		c.addAll(b);
		System.out.println(c);
		
		System.out.println("intersection");
		Set<Integer> d = new TreeSet<>(a);
		d.retainAll(b);
		System.out.println(d);
		
		System.out.println("difference");
		Set<Integer> e = new TreeSet<>(a);
		e.removeAll(b);
		System.out.println(e);

	}

}
