package proyectoInmobiliaria.inmobiliariaGui;

import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import proyectoInmobiliaria.excepciones.DniInvalidoException;
import proyectoInmobiliaria.excepciones.FormatoInvalidoException;
import proyectoInmobiliaria.inmobiliaria.Clientes;
import proyectoInmobiliaria.inmobiliaria.Local;
import proyectoInmobiliaria.inmobiliaria.Piso;
import proyectoInmobiliaria.inmobiliaria.PlazaGaraje;
import proyectoInmobiliaria.inmobiliaria.TipoEdificacion;
import proyectoInmobiliaria.inmobiliaria.TipoLocal;
import proyectoInmobiliaria.inmobiliaria.TipoPlazaGaraje;

import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 * JDialog CalcularPrecio.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class CalcularPrecio extends VentanaPadre {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private String eleccionEdificacion;

	/**
	 * Create the dialog.
	 */
	public CalcularPrecio() {
		setTitle("Calcular Precio");
		textPrecioAlquiler.setEditable(false);
		textPrecio.setEditable(false);
		textEdificaciones.setVisible(false);
		comboBoxEdificacion.setLocation(123, 151);
		lblEdificaciones.setLocation(10, 154);
		textPrecioAlquiler.setLocation(219, 112);
		textPrecio.setLocation(123, 112);
		lblNHabitaciones.setLocation(10, 84);
		textHabitaciones.setLocation(123, 81);
		textLocal.setVisible(false);
		comboBoxLocal.setLocation(123, 50);
		lblTipoLocal.setLocation(10, 53);
		textBaños.setLocation(123, 50);
		lblNumBaos.setLocation(10, 53);
		textPlaza.setVisible(false);
		comboBoxPlaza.setLocation(123, 25);
		lblTipoPlaza.setLocation(10, 28);
		textMetros.setLocation(123, 25);
		lblMetros.setLocation(10, 28);
		textDireccion.setLocation(145, 273);
		textDni.setLocation(145, 245);
		lblDni.setLocation(32, 248);
		lblDireccin.setLocation(32, 276);

		btnMostrar.setLocation(24, 197);
		btnOk.setLocation(120, 197);
		btnOk.setText("Calcular");
		btnSalir.setLocation(216, 197);
		btnMostrar.setText("Limpiar");
		ajustarVentana(326, 280);

		JLabel lblPrecioCompraalquiler = new JLabel(
				"<html>\r\n<p>Precio compra<br/>\r\nPrecio \u20AC/mes</p>\r\n</html>");
		lblPrecioCompraalquiler.setBounds(10, 109, 112, 34);
		getContentPane().add(lblPrecioCompraalquiler);

		comboBoxEdificacion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				eleccionEdificacion = elegirEdificacion((TipoEdificacion) comboBoxEdificacion.getSelectedItem());
				textDni.setVisible(false);
				lblDni.setVisible(false);
				lblDireccin.setVisible(false);
				textDireccion.setVisible(false);
				iniciarValores();
			}
		});

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (eleccionEdificacion == "PISO") {
					calcularPiso();
				} else if (eleccionEdificacion == "LOCAL")
					calcularLocal();
				else
					calcularPlaza();

			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarValores();
			}
		});

		eleccionEdificacion = elegirEdificacion(TipoEdificacion.PISO);
		textDni.setVisible(false);
		lblDni.setVisible(false);
		lblDireccin.setVisible(false);
		textDireccion.setVisible(false);

	}

	/**
	 * Metodo que calcula el precio de compra y el precio de alquiler de un piso
	 * y lo muestra.
	 */
	private void calcularPiso() {
		try {
			textPrecio.setText(new Piso(new Clientes("12345678Z"), "a", 0, 0, Integer.parseInt(textMetros.getText()),
					Integer.parseInt(textHabitaciones.getText()), Integer.parseInt(textBaños.getText())).getPrecio()
					+ "€");
			textPrecioAlquiler
					.setText(new Piso(new Clientes("12345678Z"), "a", 0, 0, Integer.parseInt(textMetros.getText()),
							Integer.parseInt(textHabitaciones.getText()), Integer.parseInt(textBaños.getText()))
									.getPrecioAlquiler()
							+ "€");
		} catch (DniInvalidoException | FormatoInvalidoException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error al calcular",
					JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(contentPanel,
					"Los campos Baños, Habitaciones, Metros solo admiten numeros enteros", "Error al escribir",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que calcula el precio de compra y el precio de alquiler de un
	 * local y lo muestra.
	 */
	private void calcularLocal() {
		try {
			textPrecio.setText(new Local(new Clientes("12345678Z"), "a", 0, 0, Integer.parseInt(textMetros.getText()),
					(TipoLocal) comboBoxLocal.getSelectedItem()).getPrecio() + "€");
			textPrecioAlquiler
					.setText(new Local(new Clientes("12345678Z"), "a", 0, 0, Integer.parseInt(textMetros.getText()),
							(TipoLocal) comboBoxLocal.getSelectedItem()).getPrecioAlquiler() + "€");
		} catch (DniInvalidoException | FormatoInvalidoException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error al calcular",
					JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(contentPanel, "El campo Metros solo admite numeros enteros.",
					"Error al escribir", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que calcula el precio de compra y el precio de alquiler de una
	 * plaza de garaje y la muestra.
	 */
	private void calcularPlaza() {
		try {
			textPrecio.setText(new PlazaGaraje(new Clientes("12345678Z"), "a", 0, 0,
					(TipoPlazaGaraje) comboBoxPlaza.getSelectedItem()).getPrecio() + "€");
			textPrecioAlquiler.setText(new PlazaGaraje(new Clientes("12345678Z"), "a", 0, 0,
					(TipoPlazaGaraje) comboBoxPlaza.getSelectedItem()).getPrecioAlquiler() + "€");
		} catch (DniInvalidoException | FormatoInvalidoException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error al calcular",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
