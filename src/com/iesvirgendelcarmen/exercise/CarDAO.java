package com.iesvirgendelcarmen.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
			listCars.put(car.getPlate(), new String[] { car.getModel(), car.getMaker()});
			return true;
		}
	}
	//read all car
	public Map<String, String[]> getListCars() {
		return listCars;
	}
	//read one car
	public Car getCarByPlate(String plate) {
		if (plate == null || listCars.get(plate) == null)	
			return null;
		return new Car(listCars.get(plate)[0],listCars.get(plate)[1], plate);
	}
	//update model/maker one car
	public boolean updateCarByPlate(Car car) {
		if (car.getMaker() == null || car.getModel() == null || 
				car.getPlate() == null || !listCars.containsKey(car.getPlate()))
			return false;
		else {
			listCars.put(car.getPlate(), new String[] {car.getModel(), car.getMaker()});
			return true;
		}
	}
	//delete car 
	public boolean deleteCarByPlate(String plate) {
//		String[] values = listCars.remove(plate);
//		System.out.println(Arrays.toString(values));
//		return values != null;
		return listCars.remove(plate) != null;
	}

	public static void main(String[] args) {
		try {
			CarDAO cdDao = new CarDAO(Helper.getDataFromFile(new File("data/cars.json")));
//			System.out.println(cdDao.addCar(new Car(null, "hola", "kjdf")));
//			System.out.println(cdDao.addCar(new Car("hola",null, "kjdf")));
//			System.out.println(cdDao.addCar(new Car("hola", "kjdf", null)));
			System.out.println(cdDao.addCar(new Car("modelo", "fabricante", "matricula")));
//			System.out.println(cdDao.addCar(new Car("modelo", "fabricante", "matricula")));
//			System.out.println(cdDao.getCarByPlate(null));
//			System.out.println(cdDao.getCarByPlate("modelo"));
//			System.out.println(cdDao.getCarByPlate("0183NTY"));
//			System.out.println(cdDao.updateCarByPlate(new Car(null, "hola", "kjdf")));
//			System.out.println(cdDao.updateCarByPlate(new Car("hola",null, "kjdf")));
//			System.out.println(cdDao.updateCarByPlate(new Car("hola", "kjdf", null)));
//			System.out.println(cdDao.updateCarByPlate(new Car("modelo", "fabricante", "matricula")));
//			System.out.println(cdDao.updateCarByPlate(new Car("modelo", "fabricante", "0183NTY")));
//			System.out.println(cdDao.updateCarByPlate(new Car("modelo", "fabricante", "0183NTY")));
			System.out.println(cdDao.deleteCarByPlate("matricula"));
			System.out.println(cdDao.deleteCarByPlate("matricula"));


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
