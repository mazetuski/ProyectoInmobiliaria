package proyectoInmobiliaria.excepciones;

/**
 * Clase EdificacionYaExisteException
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class EdificacionYaExisteException extends Exception {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	public EdificacionYaExisteException(String message) {
		super(message);
	}
}
