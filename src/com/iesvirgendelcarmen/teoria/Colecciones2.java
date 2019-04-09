package com.iesvirgendelcarmen.teoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Colecciones2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Persona> lista = new ArrayList<>();
		Set<Persona> conjunto = new HashSet<>();
		lista.add(new Persona("juan", 12));
		conjunto.add(new Persona("juan", 12));
		lista.add(new Persona("pedrito", 2));
		conjunto.add(new Persona("pedrito", 2));
		lista.add(new Persona("luisito", 13));
		conjunto.add(new Persona("luisito", 13));
		lista.add(new Persona("juan", 12));
		lista.add(new Persona("juan", 22));
		conjunto.add(new Persona("juan", 12));
		conjunto.add(new Persona("juan", 22));
		Collections.sort(lista);
		System.out.printf("Tamaño de la lista %d%n", lista.size());
		for (Persona stringLista : lista) {
			System.out.println(stringLista);
		}
		System.out.println("\n\n");

		//cambiamos el orden de la lista, usamos el criterio de la edad
		//de mayor a menor
		Collections.sort(lista, new Comparator<Persona>() {
			@Override
			public int compare(Persona p0, Persona p1) {
				// TODO Auto-generated method stub
				return -(p0.getEdad() - p1.getEdad());
			}
		});
		for (Persona stringLista : lista) {
			System.out.println(stringLista);
		}
		System.out.println("\n\n");

		System.out.printf("Tamaño del conjunto %d%n", conjunto.size());
		conjunto.forEach( e -> System.out.println(e));

	}

}
