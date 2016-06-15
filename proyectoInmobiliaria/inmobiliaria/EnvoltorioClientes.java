package proyectoInmobiliaria.inmobiliaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

import proyectoInmobiliaria.excepciones.ClienteNoExisteException;
import proyectoInmobiliaria.excepciones.ClientesExisteException;
import proyectoInmobiliaria.excepciones.DniInvalidoException;

/**
 * Clase EnvoltorioClientes.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class EnvoltorioClientes implements Serializable {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Clientes> clientes = new ArrayList<Clientes>();

	/**
	 * Metodo que añade un cliente al arrayList.
	 * 
	 * @param cliente
	 *            Cliente que se añade
	 * @throws ClientesExisteException
	 *             Si el cliente existe.
	 */
	public void annadirCliente(Clientes cliente) throws ClientesExisteException {
		if (clientes.contains(cliente))
			throw new ClientesExisteException("El cliente ya existe.");
		clientes.add(cliente);
	}

	/**
	 * Metodo que devuelve un cliente del arraylist.
	 * 
	 * @param dni
	 *            Dni con el que se localiza el cliente.
	 * @return Devuelve el cliente con ese dni.
	 * @throws ClienteNoExisteException
	 *             Si el cliente no existe.
	 * @throws DniInvalidoException
	 *             Si el dni es invalido.
	 */
	public Clientes getCliente(String dni) throws ClienteNoExisteException, DniInvalidoException {
		Clientes c = new Clientes(dni);
		int index = clientes.indexOf(c);
		if (index != -1)
			return clientes.get(index);
		throw new ClienteNoExisteException("El cliente no existe.");
	}

	/**
	 * Metodo que devuelve un array del ArrayList.
	 * 
	 * @return Array que devuelve.
	 */
	public ArrayList<Clientes> getArrayList() {
		return clientes;
	}

	/**
	 * Metodo que devuelve el tamaño del arrayList.
	 * 
	 * @return Devuelve el tamaño del arrayList.
	 */
	public int getSize() {
		return clientes.size();
	}

	public boolean clienteExiste(Clientes cliente) {
		return clientes.contains(cliente);
	}

	public ListIterator<Clientes> getListIterator() {
		return clientes.listIterator();
	}
	
}
