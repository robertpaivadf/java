package model.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.services.PaymentFee;
import model.services.PaymentService;

public class Contract {
	
	private Integer number;
	private Date date;
	private Double value;
	private Integer iStallments;	
	private List<Installments> installments;
	private PaymentFee paymentFee;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	
	public Contract(Integer number, Date date, Double value, Integer iStallments, PaymentFee paymentFee) throws ParseException {
		this.number = number;
		this.date = date;
		this.value = value;
		this.iStallments = iStallments;
		installments = new ArrayList<>(); 
		
		//preenche a lista de parcelas
		for(int i=1; i<=iStallments; i++) {				
			installments.add(new PaymentService().generateInstalment(date, value, iStallments, i, paymentFee));
		}
		
	}

	private Integer getNumber() {
		return number;
	}

	private void setNumber(Integer number) {
		this.number = number;
	}

	private Date getDate() {
		return date;
	}

	private void setDate(Date date) {
		this.date = date;
	}

	private Double getValue() {
		return value;
	}

	private void setValue(Double value) {
		this.value = value;
	}

	private Integer getiStallments() {
		return iStallments;
	}

	private void setiStallments(Integer iStallments) {
		this.iStallments = iStallments;
	}
	
	
	public List<Installments> getInstallments() {
		return installments;
	}

	private void setInstallments(List<Installments> installments) {
		this.installments = installments;
	}

	@Override
	public String toString() {
		return "Contract [number=" + number + ", date=" + sdf.format(date) + ", value=" + value + ", iStallments=" + iStallments
				+ "]";
	}
	
	
}
