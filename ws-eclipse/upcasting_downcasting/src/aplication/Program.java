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
			
		Account acc = new Account(1001, "Alex", 0.0);
		
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		//UPCASTING

		Account acc1 = bacc; //Herança é uma relação É-um, ou seja, bacc é uma Account, ou seja, uma conta empresarial também é uma conta
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
		
				
		//DOWNCASTING
		
		BusinessAccount acc4 = (BusinessAccount) acc2; //Foi necessário fazer um Cast para converter acc2 para BusinessAccount 
		acc4.loan(100.0);//emprestimo
		
		
		//BusinessAccount acc5 = (BusinessAccount)acc3; //vai dar erro em tempo de execução		
		//BusinessAccount acc6 = (SavingsAccount)acc3; //erro na coversão 
		
		//EXEMPLOS SOBRE COMO TESTAR O TIPO DE INSTÂNCIA
		if(acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			acc5.updateBalance();
			System.out.println("Update!");
		}
		
		sc.close();
		
	}

}
