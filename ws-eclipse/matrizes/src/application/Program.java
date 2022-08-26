package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite quantidade de produtos");
		int n = sc.nextInt();

		int[][] mat = new int[n][n];
		
		for(int l =0; l < mat.length; l++) {
			for(int c =0; c < mat[l].length; c++) {
				mat[l][c] = sc.nextInt();
			}
		}
		
		System.out.println();
		System.out.println("Data of matrix:");
		for(int l =0; l < mat.length; l++) {
			for(int c =0; c < mat[l].length; c++) {
				System.out.print(mat[l][c] + "  ") ;
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Main Diagonal:");
		for(int l =0; l < mat.length; l++) {
			for(int c =0; c < mat[l].length; c++) {
				if(l==c) {
					System.out.print(mat[l][c] + "  ") ;
				}
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Negative numbers:");
		for(int l =0; l < mat.length; l++) {
			for(int c =0; c < mat[l].length; c++) {
				if(mat[l][c] < 0) {
					System.out.print(mat[l][c] + "  ") ;
				}
			}
			System.out.println();
		}
		
		sc.close();
	}
	
}
