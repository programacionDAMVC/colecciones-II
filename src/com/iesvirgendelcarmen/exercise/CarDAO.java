package com.iesvirgendelcarmen.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Map;

public class CarDAO {
	Map<String, String[]> listCars;
	Connection connection;

	public CarDAO() {
		try {
			connection =  ConnectionDB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//create table
	public void createTableCar() {
		//DOS OPERACIONES: DROP Y CREATE. SE DEBEN HACER LAS DOS O NINGUNA
		//IMPLICA TRANSACCIONES
		
			
	//	int rowsDrop = 0, rowsCreate = 0;
		String dropTable   = " DROP TABLE IF EXISTS car;";
		String createTable = "CREATE TABLE car ( model TEXT NOT NULL, " + 
				"maker TEXT NOT NULL, plate TEXT PRIMARY KEY);";
		Statement statement = null;
		try {
			//OBLIGAMOS A SQLITE QUE LAS OPERACIONES NO SEAN ATÓMICAS
			connection.setAutoCommit(false); 
			statement = connection.createStatement();
			statement.executeUpdate(dropTable);
			statement.executeUpdate(createTable);
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				if (statement != null)
					try {
						statement.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				try {
					connection.setAutoCommit(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
	}
	
	//Fill table car
	public void fillTableCar(Map<String, String[]> listCars) {
		int count = 0;
		String sqlInsert = "INSERT INTO car VALUES (? , ? , ?);";
		try (PreparedStatement psStatement = connection.prepareStatement(sqlInsert);){
			for (String plate : listCars.keySet()) {
				psStatement.setString(3, plate);
				String[] values = listCars.get(plate);
				psStatement.setString(1, values[0]);
				psStatement.setString(2, values[1]);
				count += psStatement.executeUpdate();
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Insert %d rows%n", count);
	}
	
    //get cars from database
	public Map<String,String[]> getCarsFromDataBase(){
		return null;
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

	public static void main(String[] args) throws FileNotFoundException {
		CarDAO carDAO = new CarDAO();
		carDAO.createTableCar();
		carDAO.fillTableCar(Helper.getDataFromFile(new File("data/cars.json")));
	}

}
