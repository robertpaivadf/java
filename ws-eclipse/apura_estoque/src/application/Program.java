package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {			
		List<String> lDados = processaEntrada("C:\\TEMP\\lista_produtos.csv");
		geraSaida(lDados, "C:\\TEMP\\out\\soma_produtos.csv");
	}
	
	private static List<String> processaEntrada(String strPath){
		List<String> lista = new ArrayList<>();
		String[] vLinha = new String[3];
		double soma;		
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(strPath), "UTF-8"))) {			
			String line = br.readLine();
			while (line != null) {				
				vLinha = line.split(",");
				soma = Integer.parseInt(vLinha[1].trim()) * Double.parseDouble(vLinha[2].trim());
				lista.add(vLinha[0] + ", " + soma);				
				line = br.readLine();				
			}						
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}			
		return lista;		
	}
	
	private static void geraSaida(List<String> lDados, String strPath) {				
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(strPath, true))) {
			for(String line : lDados) {
				bw.write(line);
				bw.newLine();
			}
			System.out.println("Arquivo de saída gerado com sucesso! (" + strPath + ")");
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}		
	}
	

}
