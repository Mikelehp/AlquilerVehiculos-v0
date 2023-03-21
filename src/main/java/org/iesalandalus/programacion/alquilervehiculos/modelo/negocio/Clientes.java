package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente; 

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

public class Clientes {
	// Variable ArrayList
	private ArrayList<Cliente> coleccionClientes;

	public Clientes() {
		this.coleccionClientes = new ArrayList<>();
	}

	public ArrayList<Cliente> get() {
		ArrayList<Cliente> copiaClientes = new ArrayList<>();

		copiaClientes.addAll(coleccionClientes);
		return copiaClientes;
	}

	// Método calcular Cantidad
	public int getCantidad() {
		return coleccionClientes.size();
	}

	// Método Insertar cliente al arrayList con respectivos filtros
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}

		if (coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese DNI.");
		}

		coleccionClientes.add(cliente);
	}

	// Método Buscar cliente en arrayList con respectivos filtros
	public Cliente buscar(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}

		if (coleccionClientes.contains(cliente)) {
			return cliente;
		} else {
			return null;
		}

	}

	// Método borrar cliente de arrayList con respectivos filtros
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		if (coleccionClientes.contains(cliente)) {
			coleccionClientes.remove(cliente);
		} else {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}

	}

	// Método modificar cliente
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede modificar un cliente nulo.");
		}

		if (!coleccionClientes.contains(cliente)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente con ese DNI.");
		}

		if (nombre != null && telefono != null) {
			cliente.setNombre(nombre);
			cliente.setTelefono(telefono);
		} else if (nombre != null) {
			cliente.setNombre(nombre);
		} else if (telefono != null) {
			cliente.setTelefono(telefono);
		}

	}
}
