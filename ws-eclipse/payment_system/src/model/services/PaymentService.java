package model.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installments;

public class PaymentService {
	
	public PaymentService() {		
	}

	public void generateInstalment(Contract contract, Integer iStallments, PaymentFee paymentFee) throws ParseException {
		
		//preenche a lista de parcelas
		for(int i=1; i<=iStallments; i++) {
			//ajusta a data da parcela
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate d = LocalDate.parse(sdf1.format(contract.getDate()));		
			Date dateAux = sdf.parse(d.plusMonths(i).format(dtf));
			
			//aplica a taxa padrão
			double valueAux = (contract.getValue()/iStallments) * (1+(0.01 * i));
			
			//aplica a taxa da operadora de pagamentos
			valueAux = valueAux * paymentFee.tax();
			
			contract.getInstallments().add(new Installments(dateAux, valueAux, i));
			
		}			
		
	}
	
}
