package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Installments {

	Date date;
	Double value;
	Integer installment;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Installments(Date date, Double value, Integer installment) {
		this.date = date;
		this.value = value;
		this.installment = installment;
	}

	@Override
	public String toString() {
		return "Installments [date=" + sdf.format(date) + ", value=" + String.format("%.2f", value) + ", installment=" + installment + "]";
	}
	

	
	
	
}
