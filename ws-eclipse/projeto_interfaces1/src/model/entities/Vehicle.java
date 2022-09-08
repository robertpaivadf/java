package model.entities;

public class Vehicle {

	private String model; 
	
	public Vehicle() {
	}

	public Vehicle(String model) {
		this.model = model;
	}

	private String getModel() {
		return model;
	}

	private void setModel(String model) {
		this.model = model;
	}

}
