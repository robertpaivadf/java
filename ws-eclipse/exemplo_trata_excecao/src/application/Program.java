package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		try {
			//Open of account
			System.out.println("Enter the number of account:");
			int number = sc.nextInt();
			System.out.println("Enter the holder of account:");
			String holder = sc.next();
			System.out.println("Enter the value of initial deposit:");
			double balance = sc.nextDouble();
			System.out.println("Enter the value of withdraw Limit:");
			double withdrawLimit = sc.nextDouble();		
			Account acc = new Account(number, holder, balance, withdrawLimit);		
			System.out.println(acc);
			
			//New deposit
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println("enter a new deposit amount:");
			double amount = sc.nextDouble();
			acc.deposit(amount);
			System.out.println(acc);
			
			//New withdraw
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println();
			System.out.println("enter the withdrae value:");
			amount = sc.nextDouble();
			acc.withdraw(amount);
			System.out.println(acc);					
			
		}
		catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("Error, input correct data: " + e.toString() );
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error in operation: " + e.getMessage());
		}
		System.out.println();
		
		
		sc.close();
	}

}
