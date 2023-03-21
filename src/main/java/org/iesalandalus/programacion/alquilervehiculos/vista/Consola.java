package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.format.DateTimeFormatter;

public class Consola {

	// Atributos
	private String PATRON_FECHA;
	private DateTimeFormatter FORMATO_FECHA;

	// Métodos:

	// Método Constructor
	private Consola(String pATRON_FECHA, DateTimeFormatter fORMATO_FECHA) {
		PATRON_FECHA = PATRON_FECHA;
		FORMATO_FECHA = FORMATO_FECHA;
	}
	// Método Mostrar Cabezera con subrayado
	public static void mostrarCabezera(String mensaje) {

		System.out.println(mensaje);
		for (int i = 0; i < mensaje.length(); i++) {
			System.out.print("-");
		}
		System.out.println();

	}
}
