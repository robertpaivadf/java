package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installments;
import model.services.PayPal;
import model.services.PaymentService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter contract data: ");
		System.out.print("Number:");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double value = sc.nextDouble();
		System.out.print("Enter number of stallments: ");
		int iStallments = sc.nextInt();
		
		//inicia um novo contrato
		Contract contract = new Contract(number, date, value);

		//processa parcelas
		new PaymentService().generateInstalment(contract, iStallments, new PayPal());	 
		
		
		
		System.out.println();
		System.out.println("Catract data:");
		System.out.println(contract);
		System.out.println();
		System.out.println("Stallments: ");
		System.out.println();
		for(Installments stalInstallment : contract.getInstallments()) {
			System.out.println(stalInstallment);
		}
		
		
		
		sc.close();
	}

}
