package proyectoInmobiliaria.inmobiliariaGui;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import proyectoInmobiliaria.excepciones.EdificacionYaExisteException;
import proyectoInmobiliaria.inmobiliaria.Edificaciones;
import proyectoInmobiliaria.inmobiliaria.Inmobiliaria;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

/**
 * JFrame Principal.
 * 
 * @author Miguel &Aacute;ngel ZAmora Blanco
 * @version 1.0
 */
public class Principal extends JFrame {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Ayuda ayuda = new Ayuda();
	private static Principal frame;
	private static final String TITULO = "Inmobiliaria";

	/**
	 * Launch application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Sin titulo : "+getTitulo());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 519, 342);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFicheros = new JMenu("Ficheros");
		mnFicheros.setMnemonic('f');
		menuBar.add(mnFicheros);
		Icon imgFicheros = new ImageIcon(this.getClass().getResource("icon-fichero3.png"));
		mnFicheros.setIcon(imgFicheros);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestion.nuevo(frame);
			}
		});
		mnFicheros.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gestion.abrir(frame);
			}
		});
		mnFicheros.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.guardar(frame);
			}
		});
		mnFicheros.add(mntmGuardar);

		JSeparator separator_1 = new JSeparator();
		mnFicheros.add(separator_1);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar Como");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.guardarComo(frame);
			}
		});
		mnFicheros.add(mntmGuardarComo);

		JSeparator separator = new JSeparator();
		mnFicheros.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gestion.salir(frame);
			}
		});
		mnFicheros.add(mntmSalir);

		JMenu mnInmobiliaria = new JMenu("Edificaciones");
		mnInmobiliaria.setMnemonic('e');
		menuBar.add(mnInmobiliaria);
		Icon iconoEdificios = new ImageIcon(this.getClass().getResource("icon-casa2.png"));
		mnInmobiliaria.setIcon(iconoEdificios);

		JMenuItem mntmAadir = new JMenuItem("A\u00F1adir...");
		mntmAadir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirEdificacion();
			}
		});

		mnInmobiliaria.add(mntmAadir);

		JMenuItem mntmEliminar = new JMenuItem("Eliminar...");
		mntmEliminar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eliminar();
			}
		});
		mnInmobiliaria.add(mntmEliminar);

		JMenuItem mntmMostrar = new JMenuItem("Mostrar...");
		mntmMostrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mntmMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar();
			}
		});
		mnInmobiliaria.add(mntmMostrar);

		JMenuItem mntmNEdificios = new JMenuItem("N\u00BA Edificios");
		mntmNEdificios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(contentPane, "Hay " + Gestion.getInmobiliaria().size() + " edificios.");
			}
		});

		JMenuItem mntmModificar = new JMenuItem("Modificar...");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificar();
			}
		});
		mnInmobiliaria.add(mntmModificar);
		mnInmobiliaria.add(mntmNEdificios);

		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		Icon iconoClientes = new ImageIcon(this.getClass().getResource("icon-clientes.png"));
		mnClientes.setIcon(iconoClientes);

		JMenuItem mntmAadirCliente = new JMenuItem("A\u00F1adir Cliente");
		mntmAadirCliente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnClientes.add(mntmAadirCliente);

		JMenuItem mntmMostrarClientes = new JMenuItem("Mostrar Clientes...");
		mntmMostrarClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_MASK));
		mnClientes.add(mntmMostrarClientes);
		mntmMostrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarCliente();
			}
		});
		mntmAadirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AñadirCliente añadirCliente = new AñadirCliente();
				añadirCliente.setVisible(true);
			}
		});

		JMenu mnAcciones = new JMenu("Acciones");
		mnAcciones.setMnemonic('a');
		menuBar.add(mnAcciones);
		Icon iconoAcciones = new ImageIcon(this.getClass().getResource("icon-acciones.png"));
		mnAcciones.setIcon(iconoAcciones);

		JMenuItem mntmComprar = new JMenuItem("Comprar");
		mnAcciones.add(mntmComprar);
		mntmComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprar();
			}
		});

		JMenuItem mntmAlquilar = new JMenuItem("Alquilar");
		mntmAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alquilar();
			}
		});
		mnAcciones.add(mntmAlquilar);

		JMenuItem mntmCalcularPrecio = new JMenuItem("Calcular Precio");
		mntmCalcularPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CalcularPrecio calcular = new CalcularPrecio();
				calcular.setVisible(true);
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				Gestion.salir(frame);
			}
		});
		mnAcciones.add(mntmCalcularPrecio);

		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('y');
		menuBar.add(mnAyuda);
		Icon imgAyuda = new ImageIcon(this.getClass().getResource("icon-ayuda.png"));
		mnAyuda.setIcon(imgAyuda);

		JMenuItem mntmAyuda = new JMenuItem("Ayuda");
		mntmAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayuda.setVisible(true);
			}
		});
		mnAyuda.add(mntmAyuda);

		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AcercaDe acerca = new AcercaDe();
				acerca.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelPrincipal = new JLabel("");
		labelPrincipal.setBounds(0, 0, 513, 282);
		contentPane.add(labelPrincipal);
		Icon principal = new ImageIcon(this.getClass().getResource("principal2.jpg"));
		labelPrincipal.setIcon(principal);
	}

	/**
	 * Metodo que abre la ventana añadir del menu edificaciones.
	 */
	private void añadirEdificacion() {
		if (Gestion.getClientes().getSize() == 0)
			JOptionPane.showMessageDialog(contentPane, "No hay clientes en la inmobiliaria.");
		else {
			Añadir añadir = new Añadir();
			añadir.setVisible(true);
		}
	}

	/**
	 * Metodo que abre el menu mostrar.
	 */
	private void mostrar() {
		if (Gestion.getInmobiliaria().size() == 0)
			JOptionPane.showMessageDialog(contentPane, "La inmobiliaria esta vacía.");
		else {
			Mostrar mostrar = new Mostrar();
			mostrar.setVisible(true);
		}
	}

	/**
	 * Metodo que abre la ventana comprar si la inmobiliaria no esta vacia..
	 */
	private void comprar() {
		if (Gestion.getInmobiliaria().size() == 0)
			JOptionPane.showMessageDialog(contentPane, "La inmobiliaria esta vacia.");
		else {
			Comprar comprarPiso = new Comprar();
			comprarPiso.setVisible(true);
		}
	}

	/**
	 * Metodo que abre la ventana alquilar si la inmobiliaria no esta vacia.
	 */
	private void alquilar() {
		if (Gestion.getInmobiliaria().size() == 0)
			JOptionPane.showMessageDialog(contentPane, "La inmobiliaria esta vacia.");
		else {
			Alquilar alquilar = new Alquilar();
			alquilar.setVisible(true);
		}
	}

	/**
	 * Metodo que abre la ventana eliminar si la inmobiliaria no esta vacia.
	 */
	private void eliminar() {
		try {
			gestionEliminar();
		} catch (HeadlessException | EdificacionYaExisteException e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Error en ventana eliminar",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que gestiona la ventana eliminar
	 * 
	 * @throws EdificacionYaExisteException
	 *             Si la edificacion ya existe.
	 */
	private void gestionEliminar() throws EdificacionYaExisteException {
		if (Gestion.getInmobiliaria().size() == 0)
			JOptionPane.showMessageDialog(contentPane, "La inmobiliaria esta vacia.");
		else if (inmobiliariaAlquilada())
			JOptionPane.showMessageDialog(contentPane, "Todas las edificaciones estan alquiladas.");
		else {
			Eliminar eliminar = new Eliminar();
			eliminar.setVisible(true);
		}
	}

	/**
	 * Metodo que muestra los clientes.
	 */
	private void mostrarCliente() {
		if (Gestion.getClientes().getSize() != 0) {
			MostrarClientes mostrarCliente = new MostrarClientes();
			mostrarCliente.setVisible(true);
		} else
			JOptionPane.showMessageDialog(contentPane, "No hay ningun cliente");
	}

	/**
	 * Metodo que modifica edificaciones.
	 */
	private void modificar() {
		try {
			gestionModificar();
		} catch (HeadlessException | EdificacionYaExisteException e) {
			JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Error en ventana eliminar",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que gestiona la ventana modificar
	 * 
	 * @throws EdificacionYaExisteException
	 *             Si la edificacion ya existe.
	 */
	private void gestionModificar() throws EdificacionYaExisteException {
		if (Gestion.getInmobiliaria().size() == 0)
			JOptionPane.showMessageDialog(contentPane, "La inmobiliaria esta vacia.");
		else {
			Modificar modificar = new Modificar();
			modificar.setVisible(true);
		}
	}

	/**
	 * Si la inmobiliaria esta completamente alquilada.
	 * 
	 * @return Devuelve true si esta alquilada, false en caso contrario.
	 * @throws EdificacionYaExisteException
	 *             Si la edificacion ya existe.
	 */
	protected boolean inmobiliariaAlquilada() throws EdificacionYaExisteException {
		Inmobiliaria in = new Inmobiliaria();
		for (Edificaciones edificaciones : Gestion.getInmobiliaria().getArrayList()) {
			if (edificaciones.isAlquilado())
				in.annadir(edificaciones);
		}
		return in.size() == Gestion.getInmobiliaria().size();
	}

	/**
	 * Metodo que devuelve el titulo de la ventana.
	 * 
	 * @return El titulo comun de la ventana.
	 */
	public String getTitulo() {
		return TITULO;
	}

}
