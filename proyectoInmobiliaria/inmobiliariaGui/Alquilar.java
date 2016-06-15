package proyectoInmobiliaria.inmobiliariaGui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import proyectoInmobiliaria.excepciones.EdificacionNoExisteException;
import proyectoInmobiliaria.excepciones.FormatoInvalidoException;
import proyectoInmobiliaria.inmobiliaria.MesesAlquiler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.awt.event.ItemEvent;
import javax.swing.JComboBox;

/**
 * JDialog Alquilar, que alquila una edificacion.
 * 
 * @author Miguel &Aacute;ngel ZAmora Blanco
 * @version 1.0
 */
public class Alquilar extends VentanaAlquilarComprar {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate fecha;
	private JComboBox<MesesAlquiler> comboBoxMeses;

	/**
	 * Create the dialog.
	 */
	public Alquilar() {
		setTitle("Alquilar");
		btnOk.setText("<");
		btnSalir.setText(">");
		btnOk.setEnabled(false);
		btnSalir.setEnabled(false);
		btnMostrar.setText("Alquilar");
		desactivarEdicion();
		desactivarVisibilidad();
		comboBoxEdificacion.setVisible(true);
		textPrecioAlquiler.setVisible(true);
		textPrecioAlquiler.setEditable(false);
		lblEdificaciones.setVisible(true);

		comboBoxMeses = new JComboBox<MesesAlquiler>(new DefaultComboBoxModel<>(MesesAlquiler.values()));
		comboBoxMeses.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (inmobiliaria.size() != 0)
					elegirMes();
			}
		});
		comboBoxMeses.setBounds(219, 168, 95, 17);
		getContentPane().add(comboBoxMeses);

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguiente();
				reiniciarAlquilar();
			}
		});
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarAnterior();
				reiniciarAlquilar();
			}
		});

		comboBoxEdificacion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				iniciarAlquilarComprar();
				reiniciarAlquilar();
			}
		});

		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alquilar();
			}
		});

		iniciarAlquilarComprar();
		reiniciarAlquilar();
	}

	/**
	 * Metodo que compra una Edificacion.
	 */
	private void alquilar() {
		try {
			obtenerFechaVencimiento();
			edificacion = Gestion.getInmobiliaria().getEdificacion(textDireccion.getText());
			edificacion.setAlquilado(true);
			edificacion.setFechaAlquiler(fecha);
			JOptionPane.showMessageDialog(contentPanel, "Edificacion alquilada con un coste de: "
					+ textPrecioAlquiler.getText() + "\nFecha de vencimiento: " + fecha);
			actualizar();
			btnOk.setEnabled(false);
			reiniciarAlquilar();
			comprobarInmobiliariaVacia();
			Gestion.getInmobiliaria().setModificado(true);
		} catch (EdificacionNoExisteException | FormatoInvalidoException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error al comprar.",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que elige la cantidad de meses que se alquilara el piso.
	 */
	private void elegirMes() {
		double precioAlquiler = edificacion.getPrecioAlquiler();
		if (comboBoxMeses.getSelectedItem().equals(MesesAlquiler.UN_MES))
			textPrecioAlquiler.setText(precioAlquiler + "€");
		if (comboBoxMeses.getSelectedItem().equals(MesesAlquiler.DOS_MESES))
			textPrecioAlquiler.setText(precioAlquiler * 2 + "€");
		if (comboBoxMeses.getSelectedItem().equals(MesesAlquiler.MEDIO_AÑO))
			textPrecioAlquiler.setText(precioAlquiler * 6 + "€");
		if (comboBoxMeses.getSelectedItem().equals(MesesAlquiler.UN_AÑO))
			textPrecioAlquiler.setText(precioAlquiler * 12 + "€");
	}

	/**
	 * Metodo que comprueba si la inmobiliaria esta vacia para activar o
	 * desactiva el combobox meses.
	 */
	private void comprobarMesesPrecio() {
		if (inmobiliaria.size() == 0){
			comboBoxMeses.setVisible(false);
			textPrecioAlquiler.setVisible(false);
		}else{
			comboBoxMeses.setVisible(true);
			textPrecioAlquiler.setVisible(true);
			textPrecioAlquiler.setEditable(false);
		}
	}

	/**
	 * Metodo que reinicia los meses a su valor por defecto.
	 */
	private void reiniciarAlquilar() {
		comprobarMesesPrecio();
		comboBoxMeses.setSelectedIndex(0);
	}

	/**
	 * Metodo que obtiene la fecha de vencimiento del alquiler.
	 */
	private void obtenerFechaVencimiento() {
		if (comboBoxMeses.getSelectedItem().equals(MesesAlquiler.UN_MES))
			fecha = ChronoUnit.MONTHS.addTo(LocalDate.now(), 1);
		else if (comboBoxMeses.getSelectedItem().equals(MesesAlquiler.DOS_MESES))
			fecha = ChronoUnit.MONTHS.addTo(LocalDate.now(), 2);
		else if (comboBoxMeses.getSelectedItem().equals(MesesAlquiler.MEDIO_AÑO))
			fecha = ChronoUnit.MONTHS.addTo(LocalDate.now(), 6);
		else
			fecha = ChronoUnit.YEARS.addTo(LocalDate.now(), 1);

	}
}
