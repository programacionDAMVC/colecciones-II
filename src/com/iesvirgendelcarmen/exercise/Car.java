package com.iesvirgendelcarmen.exercise;

public class Car {
//{"model":"Yukon","maker":"GMC","plate":"3482NNP"},
	private String model;
	private String maker;
	private String plate;
	public Car(String model, String maker, String plate) {
		this.model = model;
		this.maker = maker;
		this.plate = plate;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getPlate() {
		return plate;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
}
