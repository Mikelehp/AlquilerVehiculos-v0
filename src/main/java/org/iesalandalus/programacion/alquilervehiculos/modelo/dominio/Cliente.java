package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.awt.PointerInfo;
import java.util.Objects;

public class Cliente {
	
		//Atributos
		private static final String ER_NOMBRE="[A-ZÁÉÍÓÚÑ][a-záéíóúüñ]+([ ][A-ZÁÉÍÓÚÑ][a-záéíóúüñ]+)*";
		private static final String ER_DNI = "([0-9]{8})([A-Z])"; 
		private static final String ER_TELEFONO= "[96][0-9]{8}";
		
		private String nombre;
		private String dni;
		private String telefono;
		
		//Métodos:
		public Cliente(String nombre, String dni, String telefono) {
			setNombre(nombre);
			setDni(dni);
			setTelefono(telefono);
			
		}
		public Cliente(Cliente cliente) {
			if (cliente == null) {
				throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
			}
			setNombre(cliente.getNombre());
			setDni(cliente.getDni());
			setTelefono(cliente.getTelefono());
		}
		
		//Getter and Setters con sus respectivos null pointer exception
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			if (nombre == null) {
				throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
			}
			if (!nombre.matches(ER_NOMBRE)) {
				throw new IllegalArgumentException("ERROR: El nombre no tiene un formato válido.");
				}
			
			this.nombre = nombre;
		}
		
		public String getDni() {
			return dni;
		}
		private void setDni(String dni) {
			if (dni == null) {
				throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
			}
			if (!dni.matches(ER_DNI)) {
				throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
			}
			if(comprobarLetraDni(dni) == false) {
				throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
			}
			this.dni = dni;
		}
		
		private boolean comprobarLetraDni(String dni) {
			boolean comprobaciondni = false;
			final char[] LETRAS_DNI = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
			//Sacar solo letra
			char letradni = dni.charAt(dni.length()-1);
			//Sacar solo número Dni
			int num = Integer.parseInt(dni.substring(0, dni.length()-1));
			//Comprobación
			if (LETRAS_DNI[num % 23] == letradni) {
				comprobaciondni = true;
			}
			return comprobaciondni;
		}
			
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			if (telefono == null) {
				throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
			}
			if (!telefono.matches(ER_TELEFONO)) {
				throw new IllegalArgumentException("ERROR: El teléfono no tiene un formato válido.");
			}
			this.telefono = telefono;
		}
	
		public static final Cliente getClienteConDni(String dni) {
			return new Cliente("Bob Esponja", dni, "950112233");
		}
		@Override
		public int hashCode() {
			return Objects.hash(dni);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cliente other = (Cliente) obj;
			return Objects.equals(dni, other.dni);
		}
		@Override
		public String toString() {
			return String.format("%s - %s (%s)",nombre,dni,telefono);
		}
		
		
		
		
		

}