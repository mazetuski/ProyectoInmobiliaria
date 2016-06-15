package proyectoInmobiliaria.inmobiliariaGui;

/**
 * JDialog VentanaAlquilarComprar
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 * @version 1.0
 */
public class VentanaAlquilarComprar extends VentanaPadre {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Metodo que inicia la ventana alquilar.
	 */
	protected void iniciarAlquilarComprar() {
		cambiarEdificacion();
		if (inmobiliaria.size() != 0) {
			comprobarBotones(listIterator);
			btnOk.setEnabled(false);
		}
		comprobarInmobiliariaVacia();
	}

	/**
	 * Metodo que comprueba si la inmobiliaria esta vacia.
	 */
	protected void comprobarInmobiliariaVacia() {
		if (inmobiliaria.size() == 0) {
			iniciarValores();
			btnMostrar.setEnabled(false);
			btnOk.setEnabled(false);
			btnSalir.setEnabled(false);
			desactivarVisibilidad();
			lblEdificaciones.setVisible(true);
			comboBoxEdificacion.setVisible(true);
		}
	}

}
