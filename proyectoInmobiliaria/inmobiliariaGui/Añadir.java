package proyectoInmobiliaria.inmobiliariaGui;

import proyectoInmobiliaria.excepciones.ClienteNoExisteException;
import proyectoInmobiliaria.excepciones.DniInvalidoException;
import proyectoInmobiliaria.excepciones.EdificacionYaExisteException;
import proyectoInmobiliaria.excepciones.FormatoInvalidoException;
import proyectoInmobiliaria.inmobiliaria.Local;
import proyectoInmobiliaria.inmobiliaria.Piso;
import proyectoInmobiliaria.inmobiliaria.PlazaGaraje;
import proyectoInmobiliaria.inmobiliaria.TipoEdificacion;
import proyectoInmobiliaria.inmobiliaria.TipoLocal;
import proyectoInmobiliaria.inmobiliaria.TipoPlazaGaraje;

import javax.swing.JOptionPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * JDialog Añadir, que añade una edificacion.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 *
 */
public class Añadir extends VentanaAñadirEliminar {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Añadir() {
		setTitle("Añadir Edificacion");
		btnMostrar.setVisible(false);
		textPlaza.setVisible(false);
		textLocal.setVisible(false);
		textEdificaciones.setVisible(false);
		textPrecio.setVisible(false);
		textPrecioAlquiler.setVisible(false);
		btnSiguiente.setVisible(false);
		btnAnterior.setVisible(false);
		textDni.setVisible(false);

		textDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				dniValido();
			}

			@Override
			public void focusGained(FocusEvent e) {
				annadirFocusGained();
			}
		});

		comboBoxEdificacion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				elegirEdificacion((TipoEdificacion) comboBoxEdificacion.getSelectedItem());
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (elegirEdificacion((TipoEdificacion) comboBoxEdificacion.getSelectedItem()) == "PISO")
					annadirPiso();
				else if (elegirEdificacion((TipoEdificacion) comboBoxEdificacion.getSelectedItem()) == "LOCAL")
					annadirLocal();
				else
					annadirPlazaGaraje();
			}
		});

		elegirEdificacion((TipoEdificacion) comboBoxEdificacion.getSelectedItem());
		iniciarComboBoxDni();
	}

	/**
	 * Metodo que inserta una Plaza de garaje.
	 */
	private void annadirPlazaGaraje() {
		try {
			Gestion.getInmobiliaria()
					.annadir(new PlazaGaraje(
							Gestion.getClientes()
									.getCliente((comboBoxDni.getSelectedItem().toString().substring(0, 9))),
							textDireccion.getText(), 0, 0, (TipoPlazaGaraje) comboBoxPlaza.getSelectedItem()));
			JOptionPane.showMessageDialog(contentPanel, "Se ha añadido con exito!");
			iniciarValores();
		} catch (EdificacionYaExisteException | DniInvalidoException | FormatoInvalidoException
				| ClienteNoExisteException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error al añadir", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que inserta un Local.
	 */
	private void annadirLocal() {
		try {
			Gestion.getInmobiliaria()
					.annadir(new Local(
							Gestion.getClientes().getCliente(comboBoxDni.getSelectedItem().toString().substring(0, 9)),
							textDireccion.getText(), 0, 0, Integer.parseInt(textMetros.getText()),
							(TipoLocal) comboBoxLocal.getSelectedItem()));
			JOptionPane.showMessageDialog(contentPanel, "Se ha añadido con exito!");
			iniciarValores();
		} catch (EdificacionYaExisteException | DniInvalidoException | FormatoInvalidoException
				| ClienteNoExisteException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error al añadir", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(contentPanel, "El campo metros solo admite numeros enteros.",
					"Error al añadir", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que inserta un Piso.
	 */
	private void annadirPiso() {
		try {
			Gestion.getInmobiliaria()
					.annadir(new Piso(
							Gestion.getClientes().getCliente(comboBoxDni.getSelectedItem().toString().substring(0, 9)),
							textDireccion.getText(), 0, 0, Integer.parseInt(textMetros.getText()),
							Integer.parseInt(textHabitaciones.getText()), Integer.parseInt(textBaños.getText())));
			JOptionPane.showMessageDialog(contentPanel, "Se ha añadido con exito!");
			iniciarValores();
		} catch (EdificacionYaExisteException | DniInvalidoException | FormatoInvalidoException
				| ClienteNoExisteException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error al añadir", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(contentPanel,
					"Los campos Metros, Habitaciones y Baños solo admiten numeros enteros.", "Error al añadir",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
