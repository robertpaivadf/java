import java.util.Locale;
import java.util.Scanner; 

	public class Main {

		public static void main(String[] args) {
		

			Locale.setDefault(Locale.US);
			
			Scanner sc = new Scanner(System.in);
			int x;
			x = sc.nextInt();
			
			if(x==6) {		
				System.out.println("Junho");
			}if(x==7) {		
				System.out.println("Julho");
			}else {
				System.out.println("Não existe");
			}
						
			x = sc.nextInt();
			
			switch (x) {
			case 6:
				System.out.println("Junho");
				break;
			case 7:
				System.out.println("Julho");
				break;
			default:
				System.out.println("Não existe");
				break;
			}
			
			//Expressão condicional ternária (novidade)
			String a;
			x = sc.nextInt();
			
			a = (x==6) ? "OK é Junho":"Não é Junho";
			System.out.println(a);			
			
			
			sc.close();			
			
		}

	}
	  