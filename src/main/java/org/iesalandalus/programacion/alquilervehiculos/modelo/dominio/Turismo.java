package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Turismo {

	//Atributos
	private static final String ER_MARCA ;
	private static final String ER_MATRICULA = ("(^[A-Z][a-z]+)|(^[A-Z][a-z]+\s[A-Z][a-z]+)|(^[A-Z]+)|(^[A-Z][a-z]+-[A-Z][a-z]+)|(^[A-Z][a-z]+[A-Z][a-z]+)");
	
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;
}
