package model.entities;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//O static foi usado para não instancia varia vezes SimpleDateFormat
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {		
	}
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {		
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
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Check-out date must be future date";
		}
		if(!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
		
	}
	@Override
	public String toString() {
		return "Reservation [roomNumber=" + roomNumber + ", checkIn=" + sdf.format(checkIn) + ", checkOut=" + sdf.format(checkOut) + "] "
				+ ", Duration " + duration() + " nights";
	}
	
	
	
	
	
}
