package proyectoInmobiliaria.inmobiliariaGui;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import proyectoInmobiliaria.excepciones.ClientesExisteException;
import proyectoInmobiliaria.excepciones.DniInvalidoException;
import proyectoInmobiliaria.inmobiliaria.Clientes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * JDialog A�adirCliente, que a�ade un cliente.
 * 
 * @author Miguel &Aacute;ngel ZAmora Blanco
 * @version 1.0
 */
public class A�adirCliente extends VentanaA�adirEliminar {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textApellidos;
	private JTextField textNombre;

	public A�adirCliente() {
		setTitle("A�adir Clientes");
		desactivarVisibilidad();
		btnOk.setVisible(true);
		btnOk.setText("A�adir");
		btnSalir.setVisible(true);
		textDni.setVisible(true);
		lblDni.setVisible(true);
		lblDireccin.setVisible(true);
		lblDireccin.setText("Nombre");
		lblMetros.setVisible(true);
		lblMetros.setText("Apellidos");
		comboBoxDni.setVisible(false);
		ajustarVentana(250, 200);

		btnSalir.setLocation(134, 136);
		btnOk.setLocation(35, 136);

		textApellidos = new JTextField();
		textApellidos.setBounds(123, 84, 86, 20);
		getContentPane().add(textApellidos);
		textApellidos.setColumns(10);

		textNombre = new JTextField();
		textNombre.setBounds(123, 59, 86, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textDni.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				annadirFocusGained();
			}

			@Override
			public void focusLost(FocusEvent e) {
				dniValido();
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a�adirCliente();
			}
		});
	}

	/**
	 * Metodo que a�ade un cliente.
	 */
	private void a�adirCliente() {
		try {
			Gestion.getClientes()
					.annadirCliente(new Clientes(textDni.getText(), textNombre.getText(), textApellidos.getText()));
			JOptionPane.showMessageDialog(contentPanel, "Cliente a�adido con exito.");
			Gestion.getInmobiliaria().setModificado(true);
			iniciarValores();
			textApellidos.setText("");
			textNombre.setText("");
		} catch (ClientesExisteException | DniInvalidoException e1) {
			JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error al a�adir cliente",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
