package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Produto> list = new ArrayList<>();
		
		System.out.println("Informe o caminho do arquivo: ");
		String strPath = sc.nextLine();
		strPath = "C:\\TEMP\\lista_produtos.csv";
		
		File souceFile = new File(strPath);
		String sourceFolder = souceFile.getParent();
		//criar a pasta out
		boolean success = new File(sourceFolder + "\\out").mkdir();
		
		String targetFileStr = sourceFolder + "\\out\\soma_produtos.csv";
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(strPath), "UTF-8"))){
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				
				String[] fields = itemCsv.split(",");
				String name = fields[0];				
				Integer quantidade = Integer.parseInt(fields[1].trim());
				Double valor = Double.parseDouble(fields[2].trim());
				list.add(new Produto(name, valor, quantidade));				
				itemCsv = br.readLine();				
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){				
				for (Produto item : list) {
					bw.write( item.getNome() + ", " + String.format("%.2f", item.total()));
					bw.newLine();
				}				
			}
			catch (IOException e) {
				System.out.println("Erro ao escrever aquivo" + e.getMessage());
			}
			System.out.println("Arquivo de saída gerado com sucesso (" + targetFileStr + ")");
		}
		catch (IOException e) {
			System.out.println("Erro ao ler aquivo" + e.getMessage());
		}
		
		sc.close();
	}

}
