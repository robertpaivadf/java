package aplication;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;


public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		//POLIMORFISMO
		//POR MEIO DO UPCASTING AS VARIÁVEIS ACC1, SACC1 E ACC2 QUE SÃO DO TIPO ACCOUNT, OU SEJA, DO MESMO TIPO
		//PODE SE COMPORTAR DE VÁRIAS FORMAS (POLIMORFISMO)
		
		
		Account acc1 = new Account(1001, "Alex", 1000.0);
		acc1.withdraw(50.0);
		System.out.println("Balance = " + acc1.getBalance());	
	
		Account sacc1 = new SavingsAccount(1001, "Maria", 1000.0, 0.01); 
		sacc1.withdraw(50.0);
		System.out.println("Balance = " + sacc1.getBalance());
		
		Account acc2 = new BusinessAccount(1003, "Bob", 1000.0, 500.0); 
		acc2.withdraw(50.0);
		System.out.println("Balance = " + acc2.getBalance());
		
		
		sc.close();
		
	}

}
