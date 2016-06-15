package proyectoInmobiliaria.inmobiliariaGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;

import javax.swing.JTextField;

import proyectoInmobiliaria.inmobiliaria.Clientes;
import proyectoInmobiliaria.inmobiliaria.EnvoltorioClientes;

/**
 * JDialog MostrarClientes, que muestra los distintos clientes.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class MostrarClientes extends VentanaPadre {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textApellidos;
	private JTextField textNombre;

	/**
	 * Create the dialog.
	 */
	public MostrarClientes() {
		btnOk.setSize(69, 23);
		btnSalir.setSize(69, 23);
		btnSalir.setLocation(161, 111);
		btnOk.setLocation(82, 112);
		setTitle("Mostrar Clientes");
		desactivarVisibilidad();
		btnMostrar.setVisible(false);
		btnOk.setText("<");
		btnSalir.setText(">");
		textDni.setVisible(true);
		lblDni.setVisible(true);
		lblDireccin.setVisible(true);
		lblDireccin.setText("Nombre");
		lblMetros.setVisible(true);
		lblMetros.setText("Apellidos");
		desactivarEdicion();
		ajustarVentana(250, 200);

		textApellidos = new JTextField();
		textApellidos.setBounds(123, 84, 86, 20);
		getContentPane().add(textApellidos);
		textApellidos.setColumns(10);
		textApellidos.setEditable(false);

		textNombre = new JTextField();
		textNombre.setBounds(123, 59, 86, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		textNombre.setEditable(false);

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarAnteriorCliente();

			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarSiguienteCliente();

			}
		});

		inicializarMostrarClientes();

	}

	/**
	 * Metodo que inicializa la ventana mostrar.
	 */
	private void inicializarMostrarClientes() {
		iniciarListIteratorClientes(Gestion.getClientes());
		mostrarCliente(cliente);
		comprobarBotonesCliente(listIteratorCliente);
		btnOk.setEnabled(false);
	}

	/**
	 * Metodo que inicializa el listIterator de cliente
	 * 
	 * @param en
	 *            Envoltorio de clientes.
	 */
	protected void iniciarListIteratorClientes(EnvoltorioClientes en) {
		listIteratorCliente = en.getListIterator();
		cliente = listIteratorCliente.next();
	}

	protected void mostrarSiguienteCliente() {
		clienteAux = listIteratorCliente.next();
		if (cliente == clienteAux)
			cliente = listIteratorCliente.next();
		else
			cliente = clienteAux;
		mostrarCliente(cliente);
		comprobarBotonesCliente(listIteratorCliente);
	}

	/**
	 * Metodo que muestra la edificacion anterior.
	 */
	protected void mostrarAnteriorCliente() {
		clienteAux = listIteratorCliente.previous();
		if (cliente == clienteAux)
			cliente = listIteratorCliente.previous();
		else
			cliente = clienteAux;
		mostrarCliente(cliente);
		comprobarBotonesCliente(listIteratorCliente);
	}

	/**
	 * Metodo que comprueba los botones de siguiente y anterior.
	 * 
	 * @param list
	 *            ListIterator que contiene las Edificaciones.
	 */
	protected void comprobarBotonesCliente(ListIterator<Clientes> list) {
		if (!list.hasNext())
			btnSalir.setEnabled(false);
		else
			btnSalir.setEnabled(true);
		if (!list.hasPrevious())
			btnOk.setEnabled(false);
		else
			btnOk.setEnabled(true);
	}

	/**
	 * Metodo que muestra un cliente.
	 * 
	 * @param cliente
	 *            Cliente que se muestra.
	 */
	protected void mostrarCliente(Clientes cliente) {
		textDni.setText(cliente.getDni());
		textNombre.setText(cliente.getNombre());
		textApellidos.setText(cliente.getApellidos());
	}
}
