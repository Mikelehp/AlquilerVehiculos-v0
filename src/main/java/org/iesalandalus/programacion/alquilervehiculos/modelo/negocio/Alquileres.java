package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres {

	// Variable ArrayList
	private ArrayList<Alquiler> coleccionAlquileres;
	// Métodos:

	// Constructor por defecto
	public Alquileres() {
		this.coleccionAlquileres = new ArrayList<>();

	}

	// Método get que devolverá una nueva lista con los mismos elementos
	public ArrayList<Alquiler> get() {
		ArrayList<Alquiler> copiaAlquileres = new ArrayList<>();

		copiaAlquileres.addAll(coleccionAlquileres);
		return copiaAlquileres;
	}

	// Método get que devuelve el alquiler de un dado cliente
	public ArrayList<Alquiler> get(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("El cliente no puede ser nulo ");
		}
		ArrayList<Alquiler> copiaAlquileres = new ArrayList<>();

		for (int i = 0; i < coleccionAlquileres.size(); i++) {

			if (coleccionAlquileres.get(i).getCliente().equals(cliente)) {
				copiaAlquileres.add(coleccionAlquileres.get(i));

			}

		}

		return copiaAlquileres;

	}

	// Método get que devuelve un aluqiler de un dado turismo
	public ArrayList<Alquiler> get(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("El turismo no puede ser nulo ");
		}
		ArrayList<Alquiler> copiaAlquileres = new ArrayList<>();

		for (int i = 0; i < coleccionAlquileres.size(); i++) {

			if (coleccionAlquileres.get(i).getTurismo().equals(turismo)) {
				copiaAlquileres.add(coleccionAlquileres.get(i));

			}

		}

		return copiaAlquileres;

	}

	// Método getCantidad
	public int getCantidad() {
		return coleccionAlquileres.size();
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");

		}

		coleccionAlquileres.add(alquiler);

	}

	// Métodod De Comprobación
	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {

	}

	// Método Devolver
	public void devolver(Cliente cliente, LocalDate fechaDevolucion) {
		if (fechaDevolucion.) {
			
		}
	}

	// Método Buscar turismo en arrayList con respectivos filtros
	public Alquiler buscar(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}

		if (coleccionAlquileres.contains(alquiler)) {
			return alquiler;
		} else {
			return null;
		}

	}

	// Método borrar alquiler de arrayList con respectivos filtros
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		if (coleccionAlquileres.contains(alquiler)) {
			coleccionAlquileres.remove(alquiler);
		}

	}

}
