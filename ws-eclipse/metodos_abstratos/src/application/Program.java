 package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities_enum.Color;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
						
		System.out.println("Enter the number of shapes: ");
		int n = sc.nextInt();
		
		List<Shape> list = new ArrayList<>();		
		
		for (int i=1; i<=n; i++) {
			System.out.println("Rectangle or Circle (r/c)? ");
			char o = sc.next().charAt(0);
			System.out.println("Color (BLACK/BLUE/RED)?");
			Color color = Color.valueOf(sc.next());
			if(o=='c') {
				System.out.println("Inform the radius:");
				double radius = sc.nextDouble();
				list.add(new Circle(color, radius));
			}else {
				System.out.println("Inform the width:");
				double width = sc.nextDouble();
				System.out.println("Inform the height:");
				double height = sc.nextDouble();
				list.add(new Rectangle(color, width, height));
			}
			
		}
		
		//print the result here
		System.out.println("Shape Areas:");
		for(Shape shape: list) {
								
			//Usando instanceof para descobrir qual é a classe do objeto
			//operador ternário para fazer o if
			String type = (shape instanceof Circle ? "Circle" : "Rectangle");
			
			System.out.println(type + " - " + shape.getColor().toString() + " - " + shape.area());			
		}
				
		sc.close();
	}

}
