package proyectoInmobiliaria.inmobiliariaGui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * JDialog Mostrar,
 * 
 * Muestra las Edificaciones disponibles.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class Mostrar extends VentanaMostrarModificar {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Mostrar() {
		textPrecioAlquiler.setLocation(123, 165);
		textPrecio.setLocation(123, 165);
		setTitle("Mostrar Edificaciones");
		btnMostrar.setVisible(false);
		btnOk.setText("<");
		btnSalir.setText(">");
		desactivarEdicion();

		

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarAnterior();
				comprobarAlquilado();
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
				comprobarAlquilado();
			}
		});

		inicializarMostrar();
		comprobarAlquilado();
	}

	/**
	 * Metodo que inicializa la ventana mostrar.
	 */
	private void inicializarMostrar() {
		iniciarListIterator(Gestion.getInmobiliaria());
		mostrarEdificaciones(edificacion);
		comprobarBotones(listIterator);
		btnOk.setEnabled(false);
	}
}
