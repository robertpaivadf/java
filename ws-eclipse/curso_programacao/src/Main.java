import java.util.Locale; 

public class Main {

	public static void main(String[] args) {
	
		int i = 10+6;
		double x = 55.898;
		String nome = "Maria";
		int idade = 31;
		
		System.out.println(i);
		System.out.println(x);
		System.out.printf("%.2f%n",x);
		Locale.setDefault(Locale.US);
		System.out.printf("%.2f%n",x);
		System.out.println("teste="+ x + " teste2 ="+i);
		System.out.printf("%s tem %d anos e ganha R$ %.2f reais%n", nome,idade,x);
		
		System.out.println("Olá Mundo!");
		
		
	}

}
  