package proyectoInmobiliaria.inmobiliaria;

import java.io.Serializable;

/**
 * Clase EnvoltorioPadre.
 * 
 * @author Miguel &Aacute;ngel ZAmora Blanco
 * @version 1.0
 */
public class EnvoltorioPadre implements Serializable {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	private Inmobiliaria inmobiliaria;
	private EnvoltorioClientes clientes;

	public EnvoltorioPadre(Inmobiliaria inmobiliaria, EnvoltorioClientes clientes) {
		setInmobiliaria(inmobiliaria);
		setClientes(clientes);
	}

	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public EnvoltorioClientes getClientes() {
		return clientes;
	}

	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public void setClientes(EnvoltorioClientes clientes) {
		this.clientes = clientes;
	}

}
