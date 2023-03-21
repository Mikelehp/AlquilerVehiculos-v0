package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo {
	// Atributos
	private Clientes clientes;
	private Turismos turismos;
	private Alquileres alquileres;

	// Métodos:

	// Método Comenzar creará la instancia de las clases de negocio anteriores.
	public void comenzar() {
		clientes = new Clientes();
		turismos = new Turismos();
		alquileres = new Alquileres();
	}

	// Método Terminar mostrará un mensaje informativo indicando que el modelo ha
	// terminado.
	public void terminar() {
		System.out.println("El modelo ha terminado.");
	}

	// Métodos Insertar que insertan nuevas instancias.
	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(new Cliente(cliente));
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		turismos.insertar(new Turismo(turismo));
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.insertar(new Alquiler(alquiler));
	}

	// Métodos Buscar que devolverán una nueva instancia del elemento encontrado si
	// éste existe.
	public Cliente buscar(Cliente cliente) {

		if (clientes.buscar(cliente) == null) {
			return null;
		}
		return new Cliente(clientes.buscar(cliente));
	}

	public Turismo buscar(Turismo turismo) {

		if (turismos.buscar(turismo) == null) {
			return null;
		}
		return new Turismo(turismos.buscar(turismo));
	}

	public Alquiler buscar(Alquiler alquiler) {
		if (alquileres.buscar(alquiler) == null) {
			return null;
		}
		return new Alquiler(alquileres.buscar(alquiler));
	}
	
	// Método Modificar que modifica cliente nombre o telefono
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}
	
	// Método devolver
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		alquileres.devolver(alquiler, fechaDevolucion);
	}

	// Métodos borrar que los borrados se realizarán en cascada
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		ArrayList<Alquiler> lista = alquileres.get(cliente);
		for (Alquiler alquiler : lista) {

			alquileres.borrar(alquiler);
		}
		clientes.borrar(cliente);
	}

	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		ArrayList<Alquiler> lista = alquileres.get(turismo);
		for (Alquiler alquiler : lista) {

			alquileres.borrar(alquiler);
		}
		turismos.borrar(turismo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {

		alquileres.borrar(alquiler);
	}

	// Métodos get que devolveran una nueva lista pero que contenga nuevas instancias.
	public List<Cliente> getClientes() {
		ArrayList<Cliente> a = new ArrayList<>();
		for (int i = 0; i < clientes.get().size(); i++) {
			a.add(new Cliente(clientes.get().get(i)));
		}
		return a;
	}

	public List<Turismo> getTurismos() {
		ArrayList<Turismo> b = new ArrayList<>();
		for (int i = 0; i < turismos.get().size(); i++) {
			b.add(new Turismo(turismos.get().get(i)));
		}
		return b;
	}

	public List<Alquiler> getAlquileres() {
		ArrayList<Alquiler> c = new ArrayList<>();
		for (int i = 0; i < alquileres.get().size(); i++) {
			c.add(new Alquiler(alquileres.get().get(i)));
		}
		return c;
	}

	public List<Alquiler> getAlquileres(Turismo turismo) {

		List<Alquiler> copiaAlquilerTurismo = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get(turismo)) {
			copiaAlquilerTurismo.add(new Alquiler(alquiler));
		}
		return copiaAlquilerTurismo;
	}

}
