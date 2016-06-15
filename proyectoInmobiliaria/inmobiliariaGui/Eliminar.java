package proyectoInmobiliaria.inmobiliariaGui;

import javax.swing.JOptionPane;

import proyectoInmobiliaria.excepciones.EdificacionNoExisteException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * JDialog Eliminar, que elimina una edificacion.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 *
 */
public class Eliminar extends VentanaAñadirEliminar {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Eliminar() {
		btnSalir.setSize(58, 23);
		btnOk.setBounds(10, 219, 58, 23);
		btnSalir.setLocation(70, 219);
		setTitle("Eliminar Edificacion");
		desactivarVisibilidad();
		desactivarEdicion();
		btnOk.setText("<");
		btnSalir.setText(">");
		textDni.setVisible(false);
		btnOk.setEnabled(false);
		btnSalir.setEnabled(false);
		btnMostrar.setVisible(false);

		comboBoxDni.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				buscar();
				comprobarInmobiliariaVacia();
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});

		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});

		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		iniciarComboBoxDni();
		buscar();
	}

	/**
	 * Metodo que elimina una edificacion.
	 */
	private void eliminar() {
		try {
			Gestion.getInmobiliaria().eliminarEdificacion(edificacion);
			JOptionPane.showMessageDialog(contentPanel, "Se ha eliminado con éxito.");
			buscar();
			comprobarInmobiliariaVacia();
		} catch (EdificacionNoExisteException e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "Error al eliminar", JOptionPane.ERROR_MESSAGE);
		}
	}
}
