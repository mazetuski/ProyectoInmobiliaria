package proyectoInmobiliaria.inmobiliaria;

import java.io.Serializable;

import proyectoInmobiliaria.excepciones.FormatoInvalidoException;
import proyectoInmobiliaria.interfaces.Alquilable;
import proyectoInmobiliaria.interfaces.Vendible;

/**
 * Clase Piso.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class Piso extends Edificaciones implements Vendible, Alquilable, Serializable {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Metros cuadrados que mide el piso.
	 */
	private int metrosCuadrados;
	/**
	 * Numero de habitaciones del piso.
	 */
	private int numHabitaciones;
	/**
	 * Numero de ba�os del piso.
	 */
	private int numBa�os;

	public Piso(Clientes cliente, String direccion, float precio, float precioAlquiler, int metrosCuadrados,
			int numHabitaciones, int numBa�os) throws FormatoInvalidoException {
		super(cliente, direccion, precio, precioAlquiler);
		setMetrosCuadrados(metrosCuadrados);
		setNumBa�os(numBa�os);
		setNumHabitaciones(numHabitaciones);
		calcularPrecioVenta();
		calcularPrecioAlquiler();
	}

	public Piso(String direccion) throws FormatoInvalidoException {
		super(direccion);
	}

	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public int getNumBa�os() {
		return numBa�os;
	}

	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public void setNumBa�os(int numBa�os) {
		this.numBa�os = numBa�os;
	}

	/**
	 * Metodo que calcular el precio de la venta.
	 */
	@Override
	public void calcularPrecioVenta() {
		setPrecio((getMetrosCuadrados() + (getNumHabitaciones() * 3) + (getNumBa�os() * 2)) * 1000);
	}

	/**
	 * Metodo que calcula el precio del alquiler.
	 */
	@Override
	public void calcularPrecioAlquiler() {
		setPrecioAlquiler(((getMetrosCuadrados() + (getNumHabitaciones() * 3)) * 5));
	}

}
