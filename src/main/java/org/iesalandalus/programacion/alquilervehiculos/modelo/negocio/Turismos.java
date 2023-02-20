package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {

	// Variable ArrayList
	private ArrayList<Turismo> coleccionTurismos;

	public Turismos() {
		this.coleccionTurismos = new ArrayList<>();
	}

	public ArrayList<Turismo> get() {
		ArrayList<Turismo> copiaTurismos = new ArrayList<>();

		copiaTurismos.addAll(coleccionTurismos);
		return copiaTurismos;
	}

	// Método calcular Cantidad
	public int getCantidad() {
		return coleccionTurismos.size();
	}

	// Método Insertar turismo al arrayList con respectivos filtros
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}

		if (coleccionTurismos.contains(turismo)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}

		coleccionTurismos.add(turismo);
	}

	// Método Buscar turismo en arrayList con respectivos filtros
	public Turismo buscar(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}

		if (coleccionTurismos.contains(turismo)) {
			return turismo;
		} else {
			return null;
		}

	}

	// Método borrar turismo de arrayList con respectivos filtros
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		if (coleccionTurismos.contains(turismo)) {
			coleccionTurismos.remove(turismo);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		}

	}

}
