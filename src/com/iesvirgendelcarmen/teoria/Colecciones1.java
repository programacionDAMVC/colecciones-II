package com.iesvirgendelcarmen.teoria;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Colecciones1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lista = new ArrayList<>();
		Set<String> conjunto = new HashSet<>();
		lista.add("uno");
		conjunto.add("uno");
		lista.add("dos");
		conjunto.add("dos");
		lista.add("tres");
		conjunto.add("tres");
		lista.add("cuatro");
		conjunto.add("cuatro");
		lista.add("uno");
		conjunto.add("uno");
		System.out.printf("Tamaño de la lista %d%n", lista.size());
		for (String stringLista : lista) {
			System.out.println(stringLista);
		}
		System.out.printf("Tamaño del conjunto %d%n", conjunto.size());
		conjunto.forEach( e -> System.out.println(e));

	}

}
