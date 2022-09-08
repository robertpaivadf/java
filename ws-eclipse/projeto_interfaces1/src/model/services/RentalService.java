package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {
	
	private Double pricePerDay;
	private Double pricePerHour;
	
	
	private BrazilTaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxService brazilTaxService) {
		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = brazilTaxService;
	}
	
	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime(); //getTime() retorna o valor em milesegundos
		long t2 = carRental.getFinish().getTime(); //getTime() retorna o valor em milesegundos
		double hours = (double) (t2 - t1) / 1000 / 60 / 60; // converte para seg / min / hora
		
		double basicPayment;
		if(hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour; //arredonda qtd horas pra cima e multiplica pelo valor por hora
		}
		else {
			basicPayment = Math.ceil(hours/24) * pricePerDay; //arredonda qtd horas pra cima e multiplica pelo valor por dia
		}		
		
		double tax = taxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
		
	}
	
	
	
}
