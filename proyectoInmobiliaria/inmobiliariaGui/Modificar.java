package proyectoInmobiliaria.inmobiliariaGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import proyectoInmobiliaria.inmobiliaria.Local;
import proyectoInmobiliaria.inmobiliaria.Piso;
import proyectoInmobiliaria.inmobiliaria.PlazaGaraje;
import proyectoInmobiliaria.inmobiliaria.TipoLocal;
import proyectoInmobiliaria.inmobiliaria.TipoPlazaGaraje;

/**
 * JDialog Modificar, que modifica una edificacion.
 * 
 * @author Miguel &Aacute;ngel ZAmora Blanco
 * @version 1.0
 */
public class Modificar extends VentanaMostrarModificar {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Modificar() {
		textPrecioAlquiler.setLocation(123, 165);
		textPrecio.setLocation(123, 165);
		setTitle("Modificar Edificaciones");
		btnMostrar.setText("Modificar");
		btnOk.setText("<");
		btnSalir.setText(">");
		desactivarEdicion();
		textMetros.setEditable(true);
		textBaños.setEditable(true);
		textHabitaciones.setEditable(true);

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarAnterior();
				iniciarAlquilado();
				iniciarCamposModificar();
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
				iniciarAlquilado();
				iniciarCamposModificar();
			}
		});

		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});

		inicializarModificar();
		iniciarAlquilado();
	}

	/**
	 * Metodo que inicia los campos de la edificacion comprobando si esta
	 * alquilada o no.
	 */
	private void iniciarAlquilado() {
		comprobarAlquilado();
		comprobarcheckBoxAlquilado();
	}

	/**
	 * Metodo que inicializa la ventana mostrar.
	 */
	private void inicializarModificar() {
		iniciarListIterator(Gestion.getInmobiliaria());
		mostrarEdificaciones(edificacion);
		comprobarBotones(listIterator);
		btnOk.setEnabled(false);
		iniciarCamposModificar();
	}

	/**
	 * Metodo que comprueba si una edificacion esta alquilada.
	 */
	private void comprobarcheckBoxAlquilado() {
		if (edificacion.isAlquilado())
			chckbxAlquilado.setEnabled(true);
		else
			chckbxAlquilado.setEnabled(false);
	}

	/**
	 * Metodo que inicia los campos de la ventana modificar.
	 */
	private void iniciarCamposModificar() {
		if (edificacion.getClass() == PlazaGaraje.class)
			iniciarPlaza();
		else if (edificacion.getClass() == Local.class)
			iniciarLocal();
		else
			textMetros.setEditable(true);
		textPlaza.setVisible(false);
		textLocal.setVisible(false);
	}

	/**
	 * Metodo que inicia el local.
	 */
	private void iniciarLocal() {
		comboBoxLocal.setVisible(true);
		comboBoxPlaza.setVisible(false);
		textMetros.setEditable(true);
	}

	/**
	 * Metodo que inicia la plaza.
	 */
	private void iniciarPlaza() {
		comboBoxPlaza.setVisible(true);
		comboBoxLocal.setVisible(false);
	}

	/**
	 * Metodo que elimina una edificacion.
	 */
	private void modificar() {
		try {
			modificarEdificacion();
			JOptionPane.showMessageDialog(contentPanel, "Se ha modificado con éxito.");
			Gestion.getInmobiliaria().setModificado(true);
			modificarAlquilado();
			comprobarAlquilado();
			if (edificios.indexOf(edificacion) == 0)
				btnOk.setEnabled(false);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPanel, "Solo se pueden introducir numeros", "Error al modificar",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que modifica una edificacion.
	 */
	private void modificarEdificacion() {
		if (edificacion.getClass() == PlazaGaraje.class)
			((PlazaGaraje) edificacion).setTipoPlaza((TipoPlazaGaraje) comboBoxPlaza.getSelectedItem());
		else if (edificacion.getClass() == Local.class) {
			((Local) edificacion).setTipoLocal((TipoLocal) comboBoxLocal.getSelectedItem());
			((Local) edificacion).setMetrosCuadrados((Integer.parseInt(textMetros.getText())));
		} else {
			((Piso) edificacion).setMetrosCuadrados(Integer.parseInt(textMetros.getText()));
			((Piso) edificacion).setNumHabitaciones(Integer.parseInt(textHabitaciones.getText()));
			((Piso) edificacion).setNumBaños(Integer.parseInt(textBaños.getText()));
		}
	}

	/**
	 * Metodo que modifica si una edificacion esta alquilada o no.
	 */
	private void modificarAlquilado() {
		if (chckbxAlquilado.isSelected())
			edificacion.setAlquilado(true);
		else
			edificacion.setAlquilado(false);
	}
}
