package proyectoInmobiliaria.excepciones;

/**
 * Clase EdificacionNoExisteException
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class EdificacionNoExisteException extends Exception {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	public EdificacionNoExisteException(String message) {
		super(message);
	}
}
