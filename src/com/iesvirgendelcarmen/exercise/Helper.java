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
	}

}
