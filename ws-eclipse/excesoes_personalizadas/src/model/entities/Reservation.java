package model.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//O static foi usado para não instancia varia vezes SimpleDateFormat
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {		
	}
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {	
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}				
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); //pega a diff entre duas datas em milesegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);	//convert de milesegundos para dias	
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Error in reservation: Check-out date must be future date");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Error in reservation: Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	@Override
	public String toString() {
		return "Reservation [roomNumber=" + roomNumber + ", checkIn=" + sdf.format(checkIn) + ", checkOut=" + sdf.format(checkOut) + "] "
				+ ", Duration " + duration() + " nights";
	}
	
	
	
	
	
}
