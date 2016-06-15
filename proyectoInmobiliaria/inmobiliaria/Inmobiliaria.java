package proyectoInmobiliaria.inmobiliaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

import proyectoInmobiliaria.excepciones.EdificacionNoExisteException;
import proyectoInmobiliaria.excepciones.EdificacionYaExisteException;
import proyectoInmobiliaria.excepciones.FormatoInvalidoException;

/**
 * Clase Inmobiliaria
 * 
 * @author Miguel &Aacute;ngel ZAmora Blanco
 * @version 1.0
 */
public class Inmobiliaria implements Serializable {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Edificaciones> edificios = new ArrayList<Edificaciones>();
	private boolean modificado = false;

	/**
	 * Metodo que inserta una Edificacion en la inmobiliaria.
	 * 
	 * @param edificacion
	 *            Edificacion que se inserta.
	 * @throws EdificacionYaExisteException
	 *             Si la edificacion ya existe.
	 */
	public void annadir(Edificaciones edificacion) throws EdificacionYaExisteException {
		if (edificios.contains(edificacion))
			throw new EdificacionYaExisteException("La edificacion ya existe.");
		edificios.add(edificacion);
		setModificado(true);
	}

	/**
	 * Metodo que elimina una Edificacion de la inmobiliaria.
	 * 
	 * @param edificacion
	 *            La edificacion que se elimina.
	 * @throws EdificacionNoExisteException
	 *             Si la edificacion no existe.
	 */
	public void eliminarEdificacion(Edificaciones edificacion) throws EdificacionNoExisteException {
		if (!edificios.contains(edificacion))
			throw new EdificacionNoExisteException("La edificacion no existe.");
		edificios.remove(edificacion);
		setModificado(true);
	}

	/**
	 * Metodo que devuelve una edificacion mediante la inserccion del dni del
	 * propietario.
	 * 
	 * @param direccion
	 *            Direccion de la edificacion.
	 * @return Devuelve la Edificacion.
	 * @throws EdificacionNoExisteException
	 *             Si la edificacion no existe.
	 * @throws FormatoInvalidoException
	 *             Si el formato es invalido.
	 */
	public Edificaciones getEdificacion(String direccion)
			throws EdificacionNoExisteException, FormatoInvalidoException {
		Edificaciones e = new Edificaciones(direccion);
		int index = edificios.indexOf(e);
		if (index != -1)
			return edificios.get(index);
		throw new EdificacionNoExisteException("La Edificacion no existe.");
	}

	/**
	 * Metodo que devuelve una Edificacion pasandole su posicion en la
	 * inmobiliaria.
	 * 
	 * @param indice
	 *            Posicion donde se encuentra en la inmobiliaria.
	 * @return Devuelve la Edificacion.
	 */
	public Edificaciones get(int indice) {
		if (edificios.size() == 0)
			return null;
		if (indice < 0 || indice > edificios.size() - 1)
			return null;
		return edificios.get(indice);
	}

	/**
	 * Metodo que devuelve el tama&ntilde;o del arraylist.
	 * 
	 * @return tama&ntilde;o del arraylist.
	 */
	public int size() {
		return edificios.size();
	}

	public boolean isModificado() {
		return modificado;
	}

	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	/**
	 * Metodo que devuelve un arraylist de las Edificaciones de un tipo pasado
	 * por parametro.
	 * 
	 * @param edificacion
	 *            El arraylist se creara con el tipo de esta Edificacion.
	 * @return Devuelve el arraylist, null si no hay ninguna edificacion de ese
	 *         tipo.
	 */
	public ArrayList<Edificaciones> getTipoEdificacion(Edificaciones edificacion) {
		ArrayList<Edificaciones> e = new ArrayList<Edificaciones>();
		for (Edificaciones edificaciones : edificios)
			if (edificaciones.getClass() == edificacion.getClass())
				e.add(edificaciones);
		if (e.size() == 0)
			return null;
		return e;
	}

	/**
	 * Metodo que devuelve un arraylist de edificaciones de un solo cliente.
	 * 
	 * @param cliente
	 *            Cliente que tiene las edificaciones
	 * @return Devuelve null si no hay ningun cliente, en cas contraro devuelve
	 *         un arrayList de sus edificaciones
	 */
	public ArrayList<Edificaciones> getEdificacionPorCliente(Clientes cliente) {
		ArrayList<Edificaciones> e = new ArrayList<Edificaciones>();
		for (Edificaciones edificaciones : edificios)
			if (edificaciones.getCliente().equals(cliente))
				e.add(edificaciones);
		if (e.size() == 0)
			return null;
		return e;
	}

	public ListIterator<Edificaciones> getListIterator() {
		return edificios.listIterator();
	}

	/**
	 * Metodo que devuelve el ArrayList.
	 * 
	 * @return Array que devuelve.
	 */
	public ArrayList<Edificaciones> getArrayList() {
		return edificios;
	}
}
