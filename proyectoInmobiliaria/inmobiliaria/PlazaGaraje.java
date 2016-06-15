package proyectoInmobiliaria.inmobiliaria;

import java.io.Serializable;

import proyectoInmobiliaria.excepciones.FormatoInvalidoException;
import proyectoInmobiliaria.interfaces.Alquilable;
import proyectoInmobiliaria.interfaces.Vendible;

/**
 * Clase PlazaGaraje
 * 
 * @author Miguel &Aacute;ngel ZAmora Blanco
 * @version 1.0
 */
public class PlazaGaraje extends Edificaciones implements Vendible, Alquilable, Serializable {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Tipo de la plaza del garaje.
	 */
	private TipoPlazaGaraje tipoPlaza;

	public PlazaGaraje(Clientes cliente, String direccion, float precio, float precioAlquiler,
			TipoPlazaGaraje tipoPlaza) throws FormatoInvalidoException {
		super(cliente, direccion, precio, precioAlquiler);
		setTipoPlaza(tipoPlaza);
		calcularPrecioAlquiler();
		calcularPrecioVenta();
	}

	public PlazaGaraje(String direccion) throws FormatoInvalidoException {
		super(direccion);
	}

	public TipoPlazaGaraje getTipoPlaza() {
		return tipoPlaza;
	}

	public void setTipoPlaza(TipoPlazaGaraje tipoPlaza) {
		this.tipoPlaza = tipoPlaza;
	}

	/**
	 * Metodo que calcula el precio del alquiler.
	 */
	@Override
	public void calcularPrecioAlquiler() {
		switch (getTipoPlaza()) {
		case COCHE:
			setPrecioAlquiler(60);
			break;
		case MOTO:
			setPrecioAlquiler(40);
			break;
		default:
			setPrecioAlquiler(100);
		}
	}

	/**
	 * Metodo que calcula el precio de la venta.
	 */
	@Override
	public void calcularPrecioVenta() {
		switch (getTipoPlaza()) {
		case COCHE:
			setPrecio(11000);
			break;
		case MOTO:
			setPrecio(8000);
			break;
		default:
			setPrecio(20000);
		}
	}
}
