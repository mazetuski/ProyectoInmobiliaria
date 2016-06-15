package proyectoInmobiliaria.inmobiliaria;

import java.io.Serializable;
import java.util.regex.Pattern;

import proyectoInmobiliaria.excepciones.DniInvalidoException;

/**
 * Clase Clientes.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 *
 */
public class Clientes implements Serializable {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private String apellidos;
	public static final String COMPROBAR_DNI = "^(?i)\\d{8}[A-Z&&[^IOU]]$";
	private static final String DNI_LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

	public Clientes(String dni, String nombre, String apellidos) throws DniInvalidoException {
		setDni(dni);
		setNombre(nombre);
		setApellidos(apellidos);
	}

	public Clientes(String dni) throws DniInvalidoException {
		setDni(dni);
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	protected void setDni(String dniPropietario) throws DniInvalidoException {
		if (!Pattern.matches(COMPROBAR_DNI, dniPropietario))
			throw new DniInvalidoException("El dni es invalido.");
		if (!comprobarLetraDni(dniPropietario))
			throw new DniInvalidoException("La letra no es valida");
		this.dni = dniPropietario;
	}

	/**
	 * Metodo que comprueba la letra del dni.
	 * 
	 * @param dni
	 *            Dni que se comprueba.
	 * @return Devuelve true si la letra coincide, false en caso contrario.
	 */
	public static boolean comprobarLetraDni(String dni) {
		char letra = dni.charAt(8);
		int numeroDni = Integer.parseInt(dni.substring(0, 8));
		if (letra != DNI_LETRAS.charAt(numeroDni % 23))
			return false;
		return true;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return dni + ", " + nombre + ", " + apellidos;
	}

}
