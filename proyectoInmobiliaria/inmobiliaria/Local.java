package proyectoInmobiliaria.inmobiliaria;

import java.io.Serializable;

import proyectoInmobiliaria.excepciones.FormatoInvalidoException;
import proyectoInmobiliaria.interfaces.Alquilable;
import proyectoInmobiliaria.interfaces.Vendible;

/**
 * Clase Local
 * 
 * @author Miguel &Aacute;ngel ZAmora Blanco
 * @version 1.0
 */
public class Local extends Edificaciones implements Vendible, Alquilable, Serializable {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Metros cuadrados que mide el local.
	 */
	private int metrosCuadrados;
	/**
	 * Tipo del local.
	 */
	private TipoLocal tipoLocal;

	public Local(Clientes cliente, String direccion, float precio, float precioAlquiler, int metrosCuadrados,
			TipoLocal tipoLocal) throws FormatoInvalidoException {
		super(cliente, direccion, precio, precioAlquiler);
		setMetrosCuadrados(metrosCuadrados);
		setTipoLocal(tipoLocal);
		calcularPrecioAlquiler();
		calcularPrecioVenta();
	}

	public Local(String direccion) throws FormatoInvalidoException {
		super(direccion);
	}

	public int getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public TipoLocal getTipoLocal() {
		return tipoLocal;
	}

	public void setMetrosCuadrados(int metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

	public void setTipoLocal(TipoLocal tipoLocal) {
		this.tipoLocal = tipoLocal;
	}

	/**
	 * Metodo que calcula el precio del alquiler.
	 */
	@Override
	public void calcularPrecioAlquiler() {
		switch (getTipoLocal()) {
		case ESTUDIO:
			setPrecioAlquiler(getMetrosCuadrados() * 5);
			break;
		case NEGOCIO:
			setPrecioAlquiler(getMetrosCuadrados() * 6);
			break;
		default:
			setPrecioAlquiler(getMetrosCuadrados() * 4);
		}
	}

	/**
	 * Metodo que calcula el precio de la venta.
	 */
	@Override
	public void calcularPrecioVenta() {
		switch (getTipoLocal()) {
		case ESTUDIO:
			setPrecio(getMetrosCuadrados() * 900);
			break;
		case NEGOCIO:
			setPrecio(getMetrosCuadrados() * 1000);
			break;
		default:
			setPrecio(getMetrosCuadrados() * 800);
		}
	}
}
