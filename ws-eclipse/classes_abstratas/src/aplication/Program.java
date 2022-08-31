package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;


public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
			
		List<Account> list = new ArrayList<>();
		
		list.add(new SavingsAccount(1001, "Alex", 500.00, 0.01));
		list.add(new SavingsAccount(1002, "Maria", 600.00, 0.01));
		list.add(new SavingsAccount(1003, "José", 750.00, 0.01));
		list.add(new SavingsAccount(1004, "Bob", 300.00, 0.01));
		list.add(new BusinessAccount(1005, "LJ Informática", 2000.00, 200.0));
		list.add(new BusinessAccount(1005, "Politec LTDA", 3000.00, 300.0));
		
		double sum = 0.00;
		
		for (Account acc : list) {
			sum += acc.getBalance();
		}
		
		System.out.printf("Total balance: %.2f%n", sum);		
		
		for (Account acc : list) {
			acc.deposit(10.0);
		}
		for (Account acc : list) {
			System.out.println("Total balance per account: " + acc.getHolder() + " Account " + acc.getNumber() + " Balance " + acc.getBalance());		

		}
		
		
		
		
		sc.close();
		
	}

}
