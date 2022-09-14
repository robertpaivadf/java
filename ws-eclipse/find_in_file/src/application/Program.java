package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path: ");
		System.out.println();
		String path = "C:\\TEMP\\PREV_UNIF_D180215_H010841.TXT";//sc.nextLine();
		System.out.println("Origem: " + path);
		
		System.out.print("Enter the word to be searched for: ");
		String word = sc.nextLine();
		System.out.println();
		
		

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path+".result", false))) {
				
				String  line = br.readLine();
				int 	nLinha = 1;
				while (line != null) {
					
					if (line.toUpperCase().indexOf(word.toUpperCase())>=0) {
						bw.write(nLinha + " " + line);
						bw.newLine();	
					}
					line = br.readLine();
					nLinha++;
				}		
			}
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}	
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		System.out.println("Resultado: " + path+".result");
		sc.close();	
		

	}

}
