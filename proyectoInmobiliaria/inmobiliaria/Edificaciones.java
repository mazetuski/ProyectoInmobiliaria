package proyectoInmobiliaria.inmobiliaria;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.regex.Pattern;

import proyectoInmobiliaria.excepciones.FormatoInvalidoException;

/**
 * Clase Edificaciones
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class Edificaciones implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private Clientes cliente;
	private String direccion;
	private float precio;
	private float precioAlquiler;
	private boolean alquilado;
	private LocalDate fechaAlquiler;
	protected static final String FORMATODIRECCION = "^(\\w+\\s*[.,]?\\s?)+$";

	public Edificaciones(Clientes cliente, String direccion, float precio, float precioAlquiler)
			throws FormatoInvalidoException {
		setCliente(cliente);
		setDireccion(direccion);
		setPrecio(precio);
		setPrecioAlquiler(precioAlquiler);
		setAlquilado(false);
	}

	public Edificaciones(String direccion) throws FormatoInvalidoException {
		setDireccion(direccion);
	}

	public String getDireccion() {
		return direccion;
	}

	public float getPrecio() {
		return precio;
	}

	protected void setDireccion(String direccion) throws FormatoInvalidoException {
		if (!Pattern.matches(FORMATODIRECCION, direccion))
			throw new FormatoInvalidoException("La direccion no es valida.");
		this.direccion = direccion;
	}

	protected void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPrecioAlquiler() {
		return precioAlquiler;
	}

	protected void setPrecioAlquiler(float precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Edificaciones other = (Edificaciones) obj;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		return true;
	}

	public boolean isAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}

	public LocalDate getFecha() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(LocalDate fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	
}
