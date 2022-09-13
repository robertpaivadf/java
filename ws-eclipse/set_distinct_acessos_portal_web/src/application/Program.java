package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		String path = "C:\\TEMP\\log_acessos.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Set<LogEntry> set = new HashSet<>();//mais rápido e não ordena, será usado apenas para contas 
			
			String line =br.readLine();					
			while (line != null) {
				String[] fields = line.split(" ");
				String username = fields[0];
				Date moment = Date.from(Instant.parse(fields[1]));
				set.add(new LogEntry(username, moment)); //não aceitará nomes repetidos
				line =br.readLine();
			}
			System.out.println("Total users: "+ set.size());
			System.out.println();
			
			for(LogEntry logEntry : set) {
				System.out.println(logEntry);
			}
			
			
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}

	}

}
