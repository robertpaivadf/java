package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number: ");
		int number = sc.nextInt();
		
		System.out.println("You typed: " + number);
		System.out.println();
		
		System.out.println("Iniciando a contagem: ");
		
		for(int i=1; i<=number; i++) {
			System.out.println("# " + i);
		}

		sc.close();
	}

}
