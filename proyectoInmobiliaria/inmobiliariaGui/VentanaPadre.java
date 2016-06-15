package proyectoInmobiliaria.inmobiliariaGui;

import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import proyectoInmobiliaria.excepciones.DniInvalidoException;
import proyectoInmobiliaria.excepciones.EdificacionYaExisteException;
import proyectoInmobiliaria.excepciones.FormatoInvalidoException;
import proyectoInmobiliaria.inmobiliaria.Clientes;
import proyectoInmobiliaria.inmobiliaria.Edificaciones;
import proyectoInmobiliaria.inmobiliaria.Inmobiliaria;
import proyectoInmobiliaria.inmobiliaria.Local;
import proyectoInmobiliaria.inmobiliaria.Piso;
import proyectoInmobiliaria.inmobiliaria.PlazaGaraje;
import proyectoInmobiliaria.inmobiliaria.TipoEdificacion;
import proyectoInmobiliaria.inmobiliaria.TipoLocal;
import proyectoInmobiliaria.inmobiliaria.TipoPlazaGaraje;

/**
 * JDialog VentanaPadre.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 *
 */
public class VentanaPadre extends JDialog {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textHabitaciones;
	protected JTextField textBaños;
	protected JTextField textMetros;
	protected JTextField textDireccion;
	protected JTextField textDni;
	protected JComboBox<TipoLocal> comboBoxLocal;
	protected JComboBox<TipoPlazaGaraje> comboBoxPlaza;
	protected JComboBox<TipoEdificacion> comboBoxEdificacion;
	protected JLabel lblTipoLocal;
	protected JLabel lblTipoPlaza;
	protected JLabel lblNHabitaciones;
	protected JLabel lblNumBaos;
	protected JLabel lblMetros;
	protected JLabel lblDireccin;
	protected JLabel lblDni;
	protected JButton btnOk;
	protected JButton btnSalir;
	protected JLabel lblEdificaciones;
	protected JButton btnMostrar;
	protected JTextField textPlaza;
	protected JTextField textLocal;
	protected JTextField textEdificaciones;
	protected JTextField textPrecio;
	protected ArrayList<Edificaciones> edificios = new ArrayList<Edificaciones>();
	protected Inmobiliaria inmobiliaria = new Inmobiliaria();
	protected JTextField textPrecioAlquiler;
	protected ListIterator<Edificaciones> listIterator;
	protected ListIterator<Clientes> listIteratorCliente;
	protected Edificaciones edificacion;
	protected Clientes cliente;
	private Edificaciones edificioAux;
	protected Clientes clienteAux;
	protected String dni;

	/**
	 * Create the dialog.
	 */
	public VentanaPadre() {
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 326, 332);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		lblDni = new JLabel("Dni");
		lblDni.setBounds(10, 34, 69, 14);
		getContentPane().add(lblDni);

		lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(10, 62, 81, 14);
		getContentPane().add(lblDireccin);

		lblMetros = new JLabel("Metros ");
		lblMetros.setBounds(10, 87, 81, 14);
		getContentPane().add(lblMetros);

		lblNumBaos = new JLabel("N\u00BA Ba\u00F1os");
		lblNumBaos.setBounds(10, 115, 81, 14);
		getContentPane().add(lblNumBaos);

		lblNHabitaciones = new JLabel("N\u00BA Habitaciones");
		lblNHabitaciones.setBounds(10, 140, 103, 14);
		getContentPane().add(lblNHabitaciones);

		lblTipoPlaza = new JLabel("Tipo Plaza");
		lblTipoPlaza.setBounds(10, 87, 81, 14);
		getContentPane().add(lblTipoPlaza);

		lblTipoLocal = new JLabel("Tipo Local");
		lblTipoLocal.setBounds(10, 115, 91, 14);
		getContentPane().add(lblTipoLocal);

		textHabitaciones = new JTextField();
		textHabitaciones.setBounds(123, 137, 86, 20);
		getContentPane().add(textHabitaciones);
		textHabitaciones.setColumns(10);

		textBaños = new JTextField();
		textBaños.setColumns(10);
		textBaños.setBounds(123, 112, 86, 20);
		getContentPane().add(textBaños);

		textMetros = new JTextField();
		textMetros.setColumns(10);
		textMetros.setBounds(123, 84, 86, 20);
		getContentPane().add(textMetros);

		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(123, 59, 86, 20);
		getContentPane().add(textDireccion);

		textDni = new JTextField();
		textDni.setColumns(10);
		textDni.setBounds(123, 31, 86, 20);
		getContentPane().add(textDni);

		comboBoxPlaza = new JComboBox<TipoPlazaGaraje>();
		comboBoxPlaza.setBounds(123, 84, 86, 20);
		getContentPane().add(comboBoxPlaza);

		comboBoxLocal = new JComboBox<TipoLocal>();
		comboBoxLocal.setBounds(123, 112, 86, 20);
		getContentPane().add(comboBoxLocal);

		lblEdificaciones = new JLabel("Edificaciones");
		lblEdificaciones.setBounds(10, 200, 95, 14);
		getContentPane().add(lblEdificaciones);

		comboBoxEdificacion = new JComboBox<TipoEdificacion>();
		comboBoxEdificacion.setBounds(123, 197, 88, 20);
		getContentPane().add(comboBoxEdificacion);
		comboBoxEdificacion.setModel(new DefaultComboBoxModel<TipoEdificacion>(TipoEdificacion.values()));
		comboBoxLocal.setModel(new DefaultComboBoxModel<TipoLocal>(TipoLocal.values()));
		comboBoxPlaza.setModel(new DefaultComboBoxModel<TipoPlazaGaraje>(TipoPlazaGaraje.values()));

		btnOk = new JButton("Insertar");
		btnOk.setBounds(102, 253, 89, 23);
		getContentPane().add(btnOk);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(201, 253, 89, 23);
		getContentPane().add(btnSalir);

		btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(201, 219, 89, 23);
		getContentPane().add(btnMostrar);

		textPlaza = new JTextField();
		textPlaza.setBounds(123, 84, 86, 20);
		getContentPane().add(textPlaza);
		textPlaza.setColumns(10);

		textLocal = new JTextField();
		textLocal.setBounds(123, 112, 86, 20);
		getContentPane().add(textLocal);
		textLocal.setColumns(10);

		textEdificaciones = new JTextField();
		textEdificaciones.setBounds(123, 197, 86, 20);
		getContentPane().add(textEdificaciones);
		textEdificaciones.setColumns(10);

		textPrecio = new JTextField();
		textPrecio.setBounds(123, 166, 86, 20);
		getContentPane().add(textPrecio);
		textPrecio.setColumns(10);

		textPrecioAlquiler = new JTextField();
		textPrecioAlquiler.setBounds(123, 166, 86, 20);
		getContentPane().add(textPrecioAlquiler);
		textPrecioAlquiler.setColumns(10);
	}

	/**
	 * Metodo que dependiendo de la edificacion activa unos campos u otros.
	 * 
	 * @param string
	 *            Tipo de edificacion.
	 * @return Devuelve el tipo de edificacion.
	 */
	String elegirEdificacion(TipoEdificacion tipo) {
		textPlaza.setVisible(false);
		textLocal.setVisible(false);
		if (tipo.equals(TipoEdificacion.PISO)) {
			elegirPiso();
			return "PISO";
		} else if (tipo.equals(TipoEdificacion.LOCAL)) {
			elegirLocal();
			return "LOCAL";
		} else {
			elegirPlaza();
			return "PLAZA_GARAJE";
		}
	}

	/**
	 * Metodo que muestra todos los campos de plaza y desactiva los otros.
	 */
	private void elegirPlaza() {
		lblDireccin.setVisible(true);
		textDireccion.setVisible(true);
		textBaños.setVisible(false);
		lblNumBaos.setVisible(false);
		lblNHabitaciones.setVisible(false);
		textHabitaciones.setVisible(false);
		comboBoxLocal.setVisible(false);
		lblTipoLocal.setVisible(false);
		lblMetros.setVisible(false);
		textMetros.setVisible(false);
		lblTipoPlaza.setVisible(true);
		comboBoxPlaza.setVisible(true);
	}

	/**
	 * Metodo que muestra los campos de local y desactiva los otros.
	 */
	private void elegirLocal() {
		lblDireccin.setVisible(true);
		textDireccion.setVisible(true);
		lblTipoPlaza.setVisible(false);
		comboBoxPlaza.setVisible(false);
		textBaños.setVisible(false);
		lblNumBaos.setVisible(false);
		lblNHabitaciones.setVisible(false);
		textHabitaciones.setVisible(false);
		comboBoxLocal.setVisible(true);
		lblTipoLocal.setVisible(true);
		lblMetros.setVisible(true);
		textMetros.setVisible(true);
	}

	/**
	 * Metodo que muestra los campos de piso y desactiva los otros.
	 */
	private void elegirPiso() {
		lblDireccin.setVisible(true);
		textDireccion.setVisible(true);
		lblTipoLocal.setVisible(false);
		lblTipoPlaza.setVisible(false);
		comboBoxLocal.setVisible(false);
		comboBoxPlaza.setVisible(false);
		textBaños.setVisible(true);
		lblNumBaos.setVisible(true);
		lblNHabitaciones.setVisible(true);
		textHabitaciones.setVisible(true);
		lblMetros.setVisible(true);
		textMetros.setVisible(true);
	}

	/**
	 * Metodo que ajusta la ventana.
	 * 
	 * @param ancho
	 *            El ancho de la ventana.
	 * @param largo
	 *            El largo de la ventana.
	 */
	protected void ajustarVentana(int ancho, int largo) {
		setBounds(100, 100, ancho, largo);
	}

	/**
	 * Metodo que inicia todos los valores.
	 */
	protected void iniciarValores() {
		textDni.setText("");
		textDireccion.setText("");
		textPrecio.setText("");
		textMetros.setText("");
		textBaños.setText("");
		textHabitaciones.setText("");
		textPlaza.setText("");
		textLocal.setText("");
		textPrecioAlquiler.setText("");
	}

	/**
	 * Metodo que introduce los valores del padre.
	 * 
	 * @param edificio
	 *            Edificio del que se obtienen los valores.
	 */
	private void setValoresPadre(Edificaciones edificio) {
		textDni.setText(edificio.getCliente().getDni());
		textDireccion.setText(edificio.getDireccion());
		textPrecio.setText(edificio.getPrecio() + "€");
		textPrecioAlquiler.setText(edificio.getPrecioAlquiler() + "€");
	}

	/**
	 * Metodo que muestra las edificaciones.
	 * 
	 * @param edificio
	 *            Edificio que se muestra
	 */
	protected void mostrarEdificaciones(Edificaciones edificio) {
		if (edificio.getClass() == Piso.class)
			mostrarPiso(edificio);
		else if (edificio.getClass() == Local.class)
			mostrarLocal(edificio);
		else
			mostrarPlazaGaraje(edificio);

	}

	/**
	 * Metodo que muestra una plaza de garaje
	 * 
	 * @param edificio
	 *            Plaza que se muestra.
	 */
	private void mostrarPlazaGaraje(Edificaciones edificio) {
		elegirEdificacion(TipoEdificacion.PLAZA_GARAJE);
		setValoresPadre(edificio);
		comboBoxPlaza.setVisible(false);
		textPlaza.setVisible(true);
		textPlaza.setText(((PlazaGaraje) edificio).getTipoPlaza().name());
		textEdificaciones.setText("PLAZA_GARAJE");
	}

	/**
	 * Metodo que muestra un local.
	 * 
	 * @param edificio
	 *            Local que se muestra.
	 */
	private void mostrarLocal(Edificaciones edificio) {
		elegirEdificacion(TipoEdificacion.LOCAL);
		setValoresPadre(edificio);
		textMetros.setText(Integer.toString(((Local) edificio).getMetrosCuadrados()));
		comboBoxLocal.setVisible(false);
		textPlaza.setVisible(false);
		textLocal.setVisible(true);
		textLocal.setText(((Local) edificio).getTipoLocal().name());
		textEdificaciones.setText("LOCAL");
	}

	/**
	 * Metodo que muestra un piso.
	 * 
	 * @param edificio
	 *            Piso que se muestra.
	 */
	private void mostrarPiso(Edificaciones edificio) {
		elegirEdificacion(TipoEdificacion.PISO);
		setValoresPadre(edificio);
		textMetros.setText(Integer.toString(((Piso) edificio).getMetrosCuadrados()));
		textBaños.setText(Integer.toString(((Piso) edificio).getNumBaños()));
		textHabitaciones.setText(Integer.toString(((Piso) edificio).getNumHabitaciones()));
		textEdificaciones.setText("PISO");
	}

	/**
	 * Metodo que comprueba los botones de siguiente y anterior.
	 * 
	 * @param list
	 *            ListIterator que contiene las Edificaciones.
	 */
	protected void comprobarBotones(ListIterator<Edificaciones> list) {
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
	 * Metodo que muestra la siguiente edificacion.
	 */
	protected void mostrarSiguiente() {
		edificioAux = listIterator.next();
		if (edificioAux == edificacion)
			edificacion = listIterator.next();
		else
			edificacion = edificioAux;
		mostrarEdificaciones(edificacion);
		comprobarBotones(listIterator);
	}

	/**
	 * Metodo que muestra la edificacion anterior.
	 */
	protected void mostrarAnterior() {
		edificioAux = listIterator.previous();
		if (edificacion == edificioAux)
			edificacion = listIterator.previous();
		else
			edificacion = edificioAux;
		mostrarEdificaciones(edificacion);
		comprobarBotones(listIterator);
	}

	/**
	 * Metodo que cambia el tipo de edificacion que se muestra.
	 */
	protected void cambiarEdificacion() {
		try {
			generarEdificacion();
		} catch (EdificacionYaExisteException | FormatoInvalidoException e) {
			JOptionPane.showMessageDialog(contentPanel, e.getMessage(), "Error al mostrar.", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que genera las edificaciones de un tipo.
	 * 
	 * @throws DniInvalidoException
	 *             si el dni es invalido.
	 * @throws EdificacionYaExisteException
	 *             si la edificacion ya existe.
	 * @throws FormatoInvalidoException
	 */
	private void generarEdificacion() throws EdificacionYaExisteException, FormatoInvalidoException {
		if (comboBoxEdificacion.getSelectedItem().equals(TipoEdificacion.PISO)) {
			generarPiso();
		} else if (comboBoxEdificacion.getSelectedItem().equals(TipoEdificacion.LOCAL)) {
			generarLocal();
		} else
			generarPlazasGaraje();
	}

	/**
	 * Metodo que genera un arraylist de pisos.
	 * 
	 * @throws DniInvalidoException
	 *             Si el dni es invalido.
	 * @throws EdificacionYaExisteException
	 *             Si la edificacion ya existe.
	 * @throws FormatoInvalidoException
	 */
	protected void generarPiso() throws EdificacionYaExisteException, FormatoInvalidoException {
		if (Gestion.getInmobiliaria().getTipoEdificacion(new Piso("Una direccion")) != null) {
			edificios = Gestion.getInmobiliaria().getTipoEdificacion(new Piso("Una direccion"));
			generarInmobiliariaYMostrar();
			btnMostrar.setEnabled(true);
		} else
			iniciarMostrar();
	}

	/**
	 * Metodo que genera un arrayList de locales
	 * 
	 * @throws DniInvalidoException
	 *             Si el dni es invalido.
	 * @throws EdificacionYaExisteException
	 *             Si la edificacion ya existe.
	 * @throws FormatoInvalidoException
	 */
	protected void generarLocal() throws EdificacionYaExisteException, FormatoInvalidoException {
		if (Gestion.getInmobiliaria().getTipoEdificacion(new Local("Una direccion")) != null) {
			edificios = Gestion.getInmobiliaria().getTipoEdificacion(new Local("Una direccion"));
			generarInmobiliariaYMostrar();
			btnMostrar.setEnabled(true);
		} else
			iniciarMostrar();
	}

	/**
	 * Metodo que genera un arrayList de plazas de garaje.
	 * 
	 * @throws DniInvalidoException
	 *             Si el dni es invalido.
	 * @throws EdificacionYaExisteException
	 *             Si la edificacion ya existe.
	 * @throws FormatoInvalidoException
	 */
	protected void generarPlazasGaraje() throws EdificacionYaExisteException, FormatoInvalidoException {
		if (Gestion.getInmobiliaria().getTipoEdificacion(new PlazaGaraje("Una direccion")) != null) {
			edificios = Gestion.getInmobiliaria().getTipoEdificacion(new PlazaGaraje("Una direccion"));
			generarInmobiliariaYMostrar();
			btnMostrar.setEnabled(true);
		} else
			iniciarMostrar();
	}

	/**
	 * Metodo que genera una inmobiliaria y la muestra.
	 * 
	 * @throws EdificacionYaExisteException
	 *             Si la edificacion ya existe.
	 * @throws DniInvalidoException
	 *             Si el dni es invalido.
	 */
	protected void generarInmobiliariaYMostrar() throws EdificacionYaExisteException {
		inmobiliaria = generarInmobiliaria();
		if (inmobiliaria.size() != 0) {
			iniciarListIterator(inmobiliaria);
			mostrarEdificaciones(edificacion);
		}
	}

	/**
	 * Metodo que genera una inmobiliaria.
	 * 
	 * @return Devuelve la inmobiliaria generada.
	 * @throws EdificacionYaExisteException
	 *             Si la edificacion ya existe.
	 * @throws DniInvalidoException
	 *             Si el dni es invalido
	 */
	protected Inmobiliaria generarInmobiliaria() throws EdificacionYaExisteException {
		Inmobiliaria in = new Inmobiliaria();
		for (Edificaciones edificaciones : edificios) {
			if (!(edificaciones.isAlquilado()))
				in.annadir(edificaciones);
		}
		return in;
	}

	/**
	 * Metodo que inicia los valores de los campos y de la inmobiliaria.
	 */
	protected void iniciarMostrar() {
		iniciarValores();
		inmobiliaria = new Inmobiliaria();
		btnOk.setEnabled(false);
		btnSalir.setEnabled(false);
		btnMostrar.setEnabled(false);
	}

	/**
	 * Metodo que desactiva los campos.
	 */
	protected void desactivarEdicion() {
		comboBoxEdificacion.setVisible(false);
		textPrecio.setVisible(false);
		textDni.setEditable(false);
		textDireccion.setEditable(false);
		textMetros.setEditable(false);
		textBaños.setEditable(false);
		textHabitaciones.setEditable(false);
		textEdificaciones.setEditable(false);
		textPlaza.setEditable(false);
		textLocal.setEditable(false);
		textPrecioAlquiler.setVisible(false);
	}

	/**
	 * Metodo que desactiva la visibilidad de los campos.
	 */
	protected void desactivarVisibilidad() {
		lblDireccin.setVisible(false);
		textDireccion.setVisible(false);
		lblMetros.setVisible(false);
		textMetros.setVisible(false);
		lblTipoPlaza.setVisible(false);
		comboBoxPlaza.setVisible(false);
		lblTipoLocal.setVisible(false);
		comboBoxLocal.setVisible(false);
		lblNumBaos.setVisible(false);
		textBaños.setVisible(false);
		lblNHabitaciones.setVisible(false);
		textHabitaciones.setVisible(false);
		lblEdificaciones.setVisible(false);
		comboBoxEdificacion.setVisible(false);
		textEdificaciones.setVisible(false);
		textLocal.setVisible(false);
		textPlaza.setVisible(false);
		textPrecio.setVisible(false);
		textPrecioAlquiler.setVisible(false);
	}

	/**
	 * Metodo que actualiza la pantalla.
	 */
	protected void actualizar() {
		cambiarEdificacion();
		comprobarBotones(listIterator);
		if (inmobiliaria.size() == 0) {
			iniciarValores();
			btnMostrar.setEnabled(false);
		}
	}

	/**
	 * Metodo que inicia el listIteraror.
	 * 
	 * @param in
	 *            La inmobiliaria con la que se genera el listIterator.
	 */
	protected void iniciarListIterator(Inmobiliaria in) {
		listIterator = in.getListIterator();
		edificacion = listIterator.next();
	}
}
