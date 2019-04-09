package com.iesvirgendelcarmen.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

public class CarDAO {
	Map<String, String[]> listCars;

	public CarDAO(Map<String, String[]> listCars) {
		this.listCars = listCars;
	}



	public void setListCars(Map<String, String[]> listCars) {
		this.listCars = listCars;
	}
	//methods CRUD
	//add entry to map
	public boolean addCar(Car car) {
		if (car.getMaker() == null || car.getModel() == null || 
				car.getPlate() == null || listCars.containsKey(car.getPlate()))
			return false;
		else {
			listCars.put(car.getPlate(), new String[] {car.getMaker(), car.getModel()});
			return true;
		}
	}
	//read all car
	public Map<String, String[]> getListCars() {
		return listCars;
	}
	//read one car
	public Car getCarByPlate(String plate) {
		return null;
	}
	//update model/maker one car
	public boolean updateCarByPlate(Car car) {
		return false;
	}
	//delete car 
	public boolean deleteCarByPlate(String plate) {
		return false;
	}

	public static void main(String[] args) {
		try {
			CarDAO cdDao = new CarDAO(Helper.getDataFromFile(new File("data/cars.json")));
			System.out.println(cdDao.addCar(new Car(null, "hola", "kjdf")));
			System.out.println(cdDao.addCar(new Car("hola",null, "kjdf")));
			System.out.println(cdDao.addCar(new Car("hola", "kjdf", null)));
			System.out.println(cdDao.addCar(new Car("modelo", "fabricante", "matricula")));
			System.out.println(cdDao.addCar(new Car("modelo", "fabricante", "matricula")));



		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
