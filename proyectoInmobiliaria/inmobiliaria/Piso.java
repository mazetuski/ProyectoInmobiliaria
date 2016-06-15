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
	 * Numero de baños del piso.
	 */
	private int numBaños;

	public Piso(Clientes cliente, String direccion, float precio, float precioAlquiler, int metrosCuadrados,
			int numHabitaciones, int numBaños) throws FormatoInvalidoException {
		super(cliente, direccion, precio, precioAlquiler);
		setMetrosCuadrados(metrosCuadrados);
		setNumBaños(numBaños);
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

	public int getNumBaños() {
		return numBaños;
	}

	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public void setNumBaños(int numBaños) {
		this.numBaños = numBaños;
	}

	/**
	 * Metodo que calcular el precio de la venta.
	 */
	@Override
	public void calcularPrecioVenta() {
		setPrecio((getMetrosCuadrados() + (getNumHabitaciones() * 3) + (getNumBaños() * 2)) * 1000);
	}

	/**
	 * Metodo que calcula el precio del alquiler.
	 */
	@Override
	public void calcularPrecioAlquiler() {
		setPrecioAlquiler(((getMetrosCuadrados() + (getNumHabitaciones() * 3)) * 5));
	}

}
