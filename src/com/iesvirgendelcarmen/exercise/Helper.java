package com.iesvirgendelcarmen.exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class Helper {

	public static Map<String,String[]> getDataFromFile(File file)
			throws FileNotFoundException{
		//Map<K,V> Key: plate, Value: [model, maker]
		Map<String,String[]> listCars = new HashMap<>();  //map empty
		Gson gson = new Gson();
		BufferedReader in = new BufferedReader(
				new FileReader(file));
		Car[] cars = gson.fromJson(in, Car[].class);
		//String[] values = new String[2]; // bad
		for (Car car : cars) {
			String[] values = new String[2];
			//		System.out.printf("%s - %s - %s%n",   
			//					car.getModel(), car.getMaker(), car.getPlate()); // check the list
			values[0] = car.getModel(); values[1] = car.getMaker();
			listCars.put(car.getPlate(), values);
		}
		return listCars;
	}

	public static boolean checkPlate(String plate) {
		if (plate == null)
			return false;
		return plate.toLowerCase().matches("[\\d]{4}[a-z]{3}");
	}
	
	public static boolean checkModel(String model) {
		// 9-3, Express 2500, Leone
		//regex:  [0-9a-zA-z][0-9a-zA-z\\s-]*[0-9a-zA-z]
		return model.matches("[0-9a-zA-z][0-9a-zA-z\\s-]*");
	}
	
	public static boolean checkMaker(String maker) {
		// 9-3, Express 2500, Leone
		//regex:  [0-9a-zA-z][0-9a-zA-z\\s-]*[0-9a-zA-z]
		return maker.matches("[a-zA-z][a-zA-z\\s-]*[a-zA-z]");
	}
	public static void main(String[] args) {
		

		try {
			Map<String,String[]> listCars = getDataFromFile(new File("data/cars.json"));
			for (String plate : listCars.keySet()) {
				System.out.println(plate + " -> " +  Arrays.toString(listCars.get(plate)));
			}
			//System.out.println(listCars);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(checkPlate("1234abc"));
//		System.out.println(checkPlate("1234abcd"));
//		System.out.println(checkPlate("123abc"));
//		System.out.println(checkPlate("aabc123"));
//		System.out.println(checkPlate("1234111"));
//		System.out.println(checkPlate("aaaaabc"));
//		System.out.println(checkPlate(null));
		System.out.println(checkMaker("9-3"));
		System.out.println(checkMaker("Land Rover"));
		System.out.println(checkMaker("Leone"));
		System.out.println(checkMaker("  "));







	}

}
