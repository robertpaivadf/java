import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Seta a localização para US (serve para Diferenciar o separador de decimais)
		Locale.setDefault(Locale.US);

		//Scanner para receber dados pelo teclado
		Scanner sc = new Scanner(System.in);

		/*
		 * String x; x=sc.next(); System.out.println("Você digitou: " + x);
		 * 
		 * int i; i=sc.nextInt(); System.out.println("Você digitou: " + i);
		 * 
		 * double y; y=sc.nextDouble(); System.out.println("Você digitou: " + y);
		 * 
		 * char a; a=sc.next().charAt(0); //pega o 1o caracter apenas
		 * System.out.println("Você digitou: " + a);
		 */

		/*
		String x;
		int i;
		double y;
		char a;
		x = sc.next();
		i = sc.nextInt();
		y = sc.nextDouble();
		a = sc.next().charAt(0); //pega o 1o caracter da string apenas
		System.out.println(x);
		System.out.println(i);
		System.out.println(y);
		System.out.println(a);
		*/
		
		
		int i;
		String x;
		double y;
		char a;		
		i = sc.nextInt();
		sc.nextLine(); //Para limpar o buffer de leitura 
		x = sc.nextLine();
		y = sc.nextDouble();
		a = sc.next().charAt(0); //pega o 1o caracter da string apenas
		System.out.println(i);
		System.out.println(x);		
		System.out.println(y);
		System.out.println(a);

		sc.close();
	}

}
