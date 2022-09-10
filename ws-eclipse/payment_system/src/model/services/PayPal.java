package model.services;

public class PayPal implements PaymentFee{
	
		
	@Override
	public double tax() {		
		return 1.02;
	}

}
