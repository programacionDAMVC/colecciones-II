package com.iesvirgendelcarmen.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TestCars {
	private static CarDAO carDAO;
	private static Scanner sc;
	public static void main(String[] args) {
		try {

			Path pathDB = Paths.get("database", "cars.sql");
			if (!Files.exists(pathDB) || Files.size(pathDB) == 0) {
				System.out.println("Get data from file");
				carDAO  = new CarDAO();
				carDAO.setListCars(Helper.getDataFromFile(new File("data/cars.json")));
			}
			else {
				System.out.println("Get data from DB");
				carDAO  = new CarDAO();
				carDAO.setListCars(carDAO.getCarsFromDataBase());
			}
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sc = new Scanner(System.in);
	sc.useDelimiter("(\n|\r\n|\r)"); 
	int iOption = -1;
	do {
		showMenu();
		String sOption = sc.next();
		if (sOption.matches("[0-5]")) {
			iOption = Integer.parseInt(sOption);
			executeCrud(iOption);
		}
		//			if (option == 0)
		//				break;
	} while (iOption != 0);
	System.out.println("END APP");
}

private static void executeCrud(int iOption) {
	switch (iOption) {
	case 0:
		exit();
		break;
	case 1:
		deleteByPlate();
		break;
	case 2:
		listAllCars();
		break;
	case 3: 
		listCarByPlate();
		break;
	case 4:
		addCar();
		break;
	case 5:
		updateCar();
		break;
	default:
		break;
	}

}

private static void updateCar() {
	//System.out.println("add car");
	String plate;
	do {
		System.out.println("Enter a valid plate");
		plate = sc.next();
	} while (!Helper.checkPlate(plate));

	String model;
	do {
		System.out.println("Enter a valid model");
		model = sc.next();
	} while (!Helper.checkModel(model));

	String maker;
	do {
		System.out.println("Enter a valid maker");
		maker = sc.next();
	} while (!Helper.checkMaker(maker));

	Car car = new Car(model, maker, plate);
	if (carDAO.updateCarByPlate(car))
		System.out.println("Add car");
	else
		System.out.println("I can't update car");

}

private static void addCar() {
	//System.out.println("add car");
	String plate;
	do {
		System.out.println("Enter a valid plate");
		plate = sc.next();
	} while (!Helper.checkPlate(plate));

	String model;
	do {
		System.out.println("Enter a valid model");
		model = sc.next();
	} while (!Helper.checkModel(model));

	String maker;
	do {
		System.out.println("Enter a valid maker");
		maker = sc.next();
	} while (!Helper.checkMaker(maker));

	Car car = new Car(model, maker, plate);
	if (carDAO.addCar(car))
		System.out.println("Add car");
	else
		System.out.println("I can't add car");

}

private static void listCarByPlate() {
	//		System.out.println("list car by plate");
	String plate;
	do {
		System.out.println("Enter a valid plate");
		plate = sc.next();
		//			if (Helper.checkPlate(plate))
		//				break;
	} while (!Helper.checkPlate(plate));
	//		System.out.println("list car by plate " + plate);
	Car car = carDAO.getCarByPlate(plate);
	if (car == null)
		System.out.printf("The plate %s doesn't exist%n", plate);
	else
		System.out.println(car);
}

private static void listAllCars() {
	//		System.out.println("list all car");
	Map<String, String[]> listCars = carDAO.getListCars();
	Set<String> plates = listCars.keySet();
	for (String plate : plates) {
		System.out.println(plate +": " + 
				Arrays.toString(listCars.get(plate)));
	}

}

private static void deleteByPlate() {
	//System.out.println("delete car");
	String plate;
	do {
		System.out.println("Enter a valid plate");
		plate = sc.next();
	} while (!Helper.checkPlate(plate));
	if (carDAO.deleteCarByPlate(plate))
		System.out.printf("Delete car");
	else
		System.out.printf("The plate %s doesn't exist%n", plate);

}

private static void exit() {
	carDAO.createTableCar();
	carDAO.fillTableCar(carDAO.getListCars());
	System.out.println("exit");
}

private static void showMenu() {
	System.out.println("\n\n0- Exit");
	System.out.println("1- Delete car by plate");
	System.out.println("2- List cars");
	System.out.println("3- List car by plate");
	System.out.println("4- Add car");
	System.out.println("5- Update car");
	System.out.print("Choose option: ");
}

}
