package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {

	// Atributos
	static DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA = 20;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;

	private Cliente cliente;
	private Turismo turismo;

	// Métodos:

	// Método Constructor
	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {

		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
	}

	// Constructor copia
	public Alquiler(Alquiler alquiler) {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}
		setCliente(new Cliente(alquiler.getCliente()));
		setTurismo(new Turismo(alquiler.getTurismo()));
		setFechaAlquiler(alquiler.getFechaAlquiler());

		if (alquiler.getFechaDevolucion() != null) {
			setFechaDevolucion(alquiler.getFechaDevolucion());
		}

	}

	// Getter and setters con sus respectivos filtros
	public Cliente getCliente() {
		return cliente;
	}

	private void setCliente(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
		this.cliente = cliente;
	}

	public Turismo getTurismo() {
		return turismo;
	}

	private void setTurismo(Turismo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		}
		this.turismo = turismo;
	}

	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}

	// Filtro de Fecha Alquiler
	private void setFechaAlquiler(LocalDate fechaAlquiler) {
		if (fechaAlquiler == null) {
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		if (fechaAlquiler.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		}
		this.fechaAlquiler = fechaAlquiler;
	}

	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}

	// Filtro de Fecha Devolucion
	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion == null) {
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if (fechaDevolucion.isBefore(fechaAlquiler) || fechaDevolucion == fechaAlquiler) {
			throw new IllegalArgumentException(
					"ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}

		if (fechaDevolucion.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		this.fechaDevolucion = fechaDevolucion;
	}

	// Método devolver
	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (this.fechaDevolucion != null) {
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		}
		setFechaDevolucion(fechaDevolucion);
	}

	// Get Precio
	public int getPrecio() {
		if (fechaDevolucion == null) {
			return 0;
		} else {

			int factorCilindrada = turismo.getCilindrada() / 10;
			int numDias = (int) (ChronoUnit.DAYS.between(fechaAlquiler, fechaDevolucion));
			return (PRECIO_DIA + factorCilindrada) * numDias;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}

	@Override
	public String toString() {
		if (fechaDevolucion == null) {
			return String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo, fechaAlquiler.format(FORMATO_FECHA),
					"Aún no devuelto", getPrecio());
		} else {
			return String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo, fechaAlquiler.format(FORMATO_FECHA),
					fechaDevolucion.format(FORMATO_FECHA), getPrecio());
		}
	}

}
