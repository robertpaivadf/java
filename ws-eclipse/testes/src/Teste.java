import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class Teste {

	public static void main(String[] args) {
		
		//Locale.setDefault(Locale.US);
		
		BigDecimal i = new BigDecimal(3757887.876876898);
				
		String a = String.format("%.5f",i); //converte para 5 casas decimais
		a = a.substring(0, a.indexOf(",",0)+5); //pega da posição inicial até a virgula + 4 casas
		
		System.out.println(a); //String
		
		System.out.println();
		
		System.out.println(i.setScale(4, RoundingMode.DOWN)); //BigDecimal
		

	}

}
