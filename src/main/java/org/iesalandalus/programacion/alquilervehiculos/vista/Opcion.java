package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {

	// Enumerados:

	SALIR("Salir"), INSERTAR_CLIENTE("Insertar cliente"), INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"), BUSCAR_CLIENTE("Buscar cliente"), BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"), MODIFICAR_CLIENTE("Modificar cliente"), DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"), BORRAR_TURISMO("Borrar turismo"), BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"), LISTAR_TURISMO("Listar turismos"), LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar alquileres de cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar alquileres de turismo");

	// Atributo
	private String texto;

	// Métodos:

	// Método Constructor
	private Opcion(String texto) {
		this.texto = texto;
	}

	// Método esOrdinalValido comprobará si el ordinal pasado se encuentra entre los
	// ordinales válidos o no
	public static boolean isOrdinalValido(int ordinal) {
		return ordinal >= 0 && ordinal < values().length;
	}

	// Método get devuelve opción adecuada si el ordinal pasado es correcto
	public static Opcion get(int ordinal) {
		if (isOrdinalValido(ordinal) == true) {
			return values()[ordinal];

		}
		throw new IllegalArgumentException("Ordinal inválido");

	}

	@Override
	public String toString() {
		return String.format("%d. %s", ordinal(), texto);
	}

}