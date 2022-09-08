package application;

import java.io.File;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		
		File[] folders = path.listFiles(File::isDirectory); //gera um vetor com uma lista de pastas
		System.out.println("FOLDERS:");
		for(File folder : folders) {
			System.out.println(folder);
		}
		
		File[] files = path.listFiles(File::isFile); //gera um vetor com uma lista de arquivos
		System.out.println("FILES:");
		for(File file : files) {
			System.out.println(file);
		}

		//Criando um diretório/pasta	
		boolean success = new File(strPath + "\\subpasta").mkdir();
		System.out.println("Directory created successfully: " + success);
		
		sc.close();
	}

}
