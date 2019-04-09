package com.iesvirgendelcarmen.teoria;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Colecciones3 {

	public static void main(String[] args) {

		//Map<K,V>  K: key clave, V: value valor
		Map<Integer,String> map = new HashMap<>();
		//para introduccir datos, usamo put
		map.put(1, "manuel");
		map.put(2, "gabriel");
		map.put(3, "rafael");
		map.put(4, "samuel");
		map.put(5, "ismael");
		map.put(5, "isabel");  //repetimos la clave
		map.put(6, "manuel");  //repetimos el valor

		System.out.printf("Tamaño de la colección: %d%n", 
				map.size());
		System.out.printf("¿Contiene la clave %d %B%n",
				1, map.containsKey(1));
		System.out.printf("¿Contiene la clave %d %B%n",
				11, map.containsKey(11));
		System.out.printf("¿Contiene el valor %s %B%n",
				"manuel", map.containsValue("manuel"));
		System.out.printf("¿Contiene el valor %s %B%n",
				"raquel", map.containsValue("raquel"));
		System.out.printf("Valor de la clave %d %s%n",
				1, map.get(1));
		
		for (Integer integer : map.keySet()) {
			System.out.println(integer + ": " + map.get(integer));
		}
		
		Map<String,Persona> mapNuevo = new HashMap<>();
		mapNuevo.put("persona 1", new Persona("manuel", 25));
		mapNuevo.put("persona 2", new Persona("isabel", 45));
		mapNuevo.put("persona 3", new Persona("ismael", 35));

		mapNuevo.keySet().forEach(e ->
			System.out.println(e + ": " + mapNuevo.get(e)));
		
	}

}
