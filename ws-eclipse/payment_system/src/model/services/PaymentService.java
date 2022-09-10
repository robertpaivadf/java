package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import model.entities.Installments;

public class PaymentService {
	
	//private PaymentFee paymentFee;
	
	public PaymentService() {		
	}

	public Installments generateInstalment(Date data, Double value, Integer iStallments, Integer i, PaymentFee paymentFee) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate d = LocalDate.parse(sdf1.format(data));		
		Date dateAux = sdf.parse(d.plusMonths(i).format(dtf));
		double valueAux = (value/iStallments) * (1+(0.01 * i));
		
		valueAux = valueAux * paymentFee.tax();
		
		Installments installment = new Installments(dateAux, valueAux, i);
		
		return installment;
	}
	
}
