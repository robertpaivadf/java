package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite quantidade de pessoas");
		int n = sc.nextInt();
		
		double[] vect= new double[n];
		
		for(int i=0; i<n; i++) {
			System.out.println("Digite a altura da pessoa " + (i+1));
			vect[i] = sc.nextDouble(); 			
		}
		
		double sum = 0.00;
		for(int i=0; i<n; i++) {
			System.out.println("Dados da Pessoa " + (i+1));
			System.out.println(vect[i]);
			sum += vect[i];
		}
		
		double avg = sum/n;
		
		System.out.printf("Average Height: %.2f%n" , avg);
		
		sc.close();
		
	}

}
