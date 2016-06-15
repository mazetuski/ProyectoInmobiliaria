package proyectoInmobiliaria.inmobiliariaGui;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import proyectoInmobiliaria.excepciones.EdificacionNoExisteException;
import proyectoInmobiliaria.excepciones.FormatoInvalidoException;
import proyectoInmobiliaria.inmobiliaria.Edificaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.awt.event.ItemEvent;

/**
 * JDialog Comprar, que compra una edificacion.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco.
 * @version 1.0
 *
 */
public class Comprar extends VentanaAlquilarComprar {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private Edificaciones edificacion;

	/**
	 * Create the dialog.
	 */
	public Comprar() {
		setTitle("Comprar");
		btnMostrar.setLocation(12, 238);
		btnSalir.setLocation(211, 238);
		btnOk.setLocation(120, 238);
		btnOk.setText("<");
		btnSalir.setText(">");
		btnMostrar.setText("Comprar");
		desactivarEdicion();
		desactivarVisibilidad();
		comboBoxEdificacion.setVisible(true);
		lblEdificaciones.setVisible(true);

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
			}
		});

		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprar();
			}
		});

		comboBoxEdificacion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				iniciarComprar();
			}
		});

		iniciarComprar();
	}

	/**
	 * Metodo que inicia la ventana comprar.
	 */
	private void iniciarComprar() {
		iniciarAlquilarComprar();
		reiniciarPrecio();
	}

	/**
	 * Metodo que compra una Edificacion.
	 */
	private void comprar() {
		try {
			edificacion = Gestion.getInmobiliaria().getEdificacion(textDireccion.getText());
			Gestion.getInmobiliaria().eliminarEdificacion(edificacion);
			inmobiliaria.eliminarEdificacion(edificacion);
			JOptionPane.showMessageDialog(contentPanel, "Edificio comprado con un coste de: " + edificacion.getPrecio()
					+ "€\nComprado a fecha de: " + LocalDate.now());
			actualizar();
			btnOk.setEnabled(false);
			comprobarInmobiliariaVacia();
		} catch (EdificacionNoExisteException | FormatoInvalidoException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error al comprar.",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Metodo que reinicia el textPrecio.
	 */
	private void reiniciarPrecio(){
		if (inmobiliaria.size() == 0){
			textPrecio.setVisible(false);
		}else{
			textPrecio.setVisible(true);
			textPrecio.setEditable(false);
		}
	}
}
