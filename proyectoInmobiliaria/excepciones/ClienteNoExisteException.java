package proyectoInmobiliaria.excepciones;

/**
 * Clase ClienteNoExisteException
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class ClienteNoExisteException extends Exception {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	public ClienteNoExisteException(String message) {
		super(message);
	}

}
