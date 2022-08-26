import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Main {

	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	
	int x = 1;
	int soma=0;
	
	//Enquanto
	while (x != 0) {
		x = sc.nextInt();
		System.out.println("Você digitou " + x);
		soma += x;
	}	
	System.out.println("Fim, vc digitou 0 zero");	
	System.out.println("A soma dos números é " + soma);
	
	//Para	
		for (int i=0; i <= 10; i++) {
			System.out.println(i);			
		}
	
	}
		

}
