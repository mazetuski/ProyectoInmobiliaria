package proyectoInmobiliaria.inmobiliariaGui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import proyectoInmobiliaria.excepciones.ClienteNoExisteException;
import proyectoInmobiliaria.excepciones.DniInvalidoException;
import proyectoInmobiliaria.excepciones.EdificacionNoExisteException;
import proyectoInmobiliaria.excepciones.EdificacionYaExisteException;
import proyectoInmobiliaria.inmobiliaria.Clientes;
import javax.swing.JComboBox;

/**
 * Clase VentanaAñadirEliminar.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 *
 */
public class VentanaAñadirEliminar extends VentanaPadre {
	protected JButton btnAnterior;
	protected JButton btnSiguiente;
	protected JComboBox<Clientes> comboBoxDni;
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;

	public VentanaAñadirEliminar() {
		btnSiguiente = new JButton("Salir");
		btnSiguiente.setBounds(201, 253, 89, 23);
		getContentPane().add(btnSiguiente);

		btnAnterior = new JButton("Eliminar");
		btnAnterior.setBounds(106, 253, 86, 23);
		getContentPane().add(btnAnterior);
		btnAnterior.setEnabled(false);

		comboBoxDni = new JComboBox<Clientes>();
		comboBoxDni.setBounds(123, 31, 167, 20);
		getContentPane().add(comboBoxDni);

	}

	/**
	 * Metodo que comprueba si el dni es valido y lo pone de color verde, rojo
	 * en caso contrario.
	 */
	protected boolean comprobarDni() {
		if (Clientes.comprobarLetraDni(textDni.getText())) {
			textDni.setForeground(Color.GREEN);
			return true;
		} else {
			textDni.setForeground(Color.RED);
			return false;
		}
	}

	/**
	 * Metodo que añade el focusLost, comprueba el dni y si es correcto lo pone
	 * en verde, rojo en caso contrario.
	 */
	protected boolean dniValido() {
		textDni.setText(textDni.getText().toUpperCase());
		if (Pattern.matches(Clientes.COMPROBAR_DNI, textDni.getText())) {
			return comprobarDni();
		} else {
			textDni.setForeground(Color.RED);
			return false;
		}
	}

	/**
	 * Metodo que pone el texto del dni de color negro.
	 */
	protected void annadirFocusGained() {
		textDni.setForeground(Color.BLACK);
	}

	/**
	 * Metodo que busca una edificacion.
	 * 
	 * @throws DniInvalidoException
	 *             Si el dni es invalido.
	 * @throws EdificacionNoExisteException
	 *             Si la edificacion no existe.
	 */
	protected void buscar() {
		try {
			Gestion.getClientes().getCliente(comboBoxDni.getSelectedItem().toString().substring(0, 9));
			edificios = Gestion.getInmobiliaria()
					.getEdificacionPorCliente(new Clientes(comboBoxDni.getSelectedItem().toString().substring(0, 9)));
			generarInmobiliariaBuscar();
		} catch (EdificacionYaExisteException | DniInvalidoException | ClienteNoExisteException e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "Error al buscar", JOptionPane.ERROR_MESSAGE);
			desactivarVisibilidad();
		}
	}

	/**
	 * Genera la inmobiliaria para buscar.
	 * 
	 * @throws EdificacionYaExisteException
	 *             Si la edificacion ya existe.
	 */
	private void generarInmobiliariaBuscar() throws EdificacionYaExisteException {
		if (edificios != null) {
			generarInmobiliariaYMostrar();
			btnAnterior.setEnabled(true);
			comprobarBotones(listIterator);
			btnOk.setEnabled(false);
		} else {
			desactivarVisibilidad();
			btnOk.setEnabled(false);
			btnSalir.setEnabled(false);
			btnAnterior.setEnabled(false);
		}
	}

	/**
	 * Metodo que inicia el comboBox dni.
	 */
	protected void iniciarComboBoxDni() {
		DefaultComboBoxModel<Clientes> clientesDni = new DefaultComboBoxModel<Clientes>();
		ArrayList<Clientes> clientesArray = Gestion.getClientes().getArrayList();
		for (Clientes c : clientesArray)
			clientesDni.addElement(c);
		comboBoxDni.setModel(clientesDni);
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
			btnAnterior.setEnabled(false);
			lblEdificaciones.setVisible(false);
			comboBoxEdificacion.setVisible(false);
		}
	}
}
