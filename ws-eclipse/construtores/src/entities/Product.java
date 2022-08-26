package entities;

public class Product {
	
	public String name;
	public double price;
	public int quantity;
	
	//nesse ponto será criado o método contrutor para forçar instanciar o objeto já passando os parametros iniciais
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;		
	}
	//Sobrecarga, mais de uma forma de chamar o método contrutor
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	
	public double totalValueInStock() {
		return price * quantity;
	}
	
	public void addProducts(int quantity) {
		this.quantity += quantity;
	}
	
	public void removeProducts(int quantity) {
		this.quantity -= quantity;
	}
	
	public String toString() {
		return "You input data: Name: " + name + " and Price: " + String.format("%.2f", price) + " and Quantity: " + quantity + " Total in Stock: " + String.format("%.2f", totalValueInStock());
	}
	

}
