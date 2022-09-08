package application;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		String[] lines = new String[] {"John","Maria","Jaque"};
		String path = "C:\\TEMP\\teste_java.txt";	
		
		//o true foi usado para não recriar o arquivo, acrescentar ao final dele apenas
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}	

	}

}
