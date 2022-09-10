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
	private List<Installments> installments = new ArrayList<>(); ;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Contract(Integer number, Date date, Double value) throws ParseException {
		this.number = number;
		this.date = date;
		this.value = value;		
	}

	private Integer getNumber() {
		return number;
	}

	private void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	private void setDate(Date date) {
		this.date = date;
	}

	public Double getValue() {
		return value;
	}

	private void setValue(Double value) {
		this.value = value;
	}
	
	public List<Installments> getInstallments() {
		return installments;
	}
	

	@Override
	public String toString() {
		return "Contract [number=" + number + ", date=" + sdf.format(date) + ", value=" + String.format("%.2f", value) + "]";
	}
	
	
}
