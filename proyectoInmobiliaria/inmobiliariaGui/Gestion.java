package proyectoInmobiliaria.inmobiliariaGui;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import proyectoInmobiliaria.inmobiliaria.EnvoltorioClientes;
import proyectoInmobiliaria.inmobiliaria.EnvoltorioPadre;
import proyectoInmobiliaria.inmobiliaria.Inmobiliaria;
import proyectoInmobiliaria.utiles.Ficheros;

/**
 * Clase GestionFicheros,
 * 
 * Gestiona los ficheros de la inmobiliaria.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class Gestion {
	/**
	 * Filtro que se le aplica a los ficheros.
	 */
	private static FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos obj", "obj");
	/**
	 * Fichero que se usa.
	 */
	private static File file = null;
	/**
	 * JFileChooser que crea las ventanas de ficheros.
	 */
	private static JFileChooser jFile;
	/**
	 * Inmobiliaria que se usa en todo momento en la GUI.
	 */
	private static Inmobiliaria inmobiliaria = new Inmobiliaria();
	/**
	 * Clientes de la inmobiliaria.
	 */
	private static EnvoltorioClientes clientes = new EnvoltorioClientes();

	private static EnvoltorioPadre inmobiliariaYClientes = new EnvoltorioPadre(inmobiliaria, clientes);

	/**
	 * Metodo que crea la ventana guardarComo de la Inmobiliaria y guarda.
	 */
	protected static int guardarComo(Principal frame) {
		jFile = new JFileChooser();
		jFile.setFileFilter(filtro);
		int respuesta = jFile.showSaveDialog(null);
		if (respuesta == JFileChooser.APPROVE_OPTION) {
			file = jFile.getSelectedFile();
			gestionarGuardarComo(frame);
		}
		return respuesta;
	}

	/**
	 * Metodo que hace la funcion guardar de ficheros.
	 * 
	 * @param file
	 *            Fichero donde se guarda.
	 */
	protected static void guardar(Principal frame) {
		if (file == null)
			guardarComo(frame);
		else
			guardarInmobiliaria(frame);

	}

	/**
	 * Metodo que sobreescribe un archivo en caso de que el usuario quiera.
	 * 
	 * @param file
	 *            Fichero donde se guarda
	 */
	private static void gestionarGuardarComo(Principal frame) {
		file = Ficheros.annadirExtension(file);
		if (file.exists()) {
			int respuesta = JOptionPane.showConfirmDialog(null, "Desea sobreescribir el archivo?");
			if (respuesta == JOptionPane.YES_OPTION)
				guardarInmobiliaria(frame);
			else
				frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		} else
			guardarInmobiliaria(frame);

	}

	/**
	 * Metodo que guarda la inmobiliaria.
	 * 
	 * @param file
	 */
	private static void guardarInmobiliaria(Principal frame) {
		try {
			Ficheros.guardarComo(getInmobiliariaYClientes(), file);
			getInmobiliaria().setModificado(false);
			frame.setTitle(file.getName() + " : " + frame.getTitulo());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Metodo que realiza la funcion de abrir.
	 */
	static void abrir(Principal frame) {
		if (getInmobiliaria().isModificado())
			gestionarAbrir(frame);
		else
			abrirInmobiliariaYClientes(frame);
	}

	/**
	 * Metodo que abre la inmobiliaria y los clientes.
	 */
	private static void abrirInmobiliariaYClientes(Principal frame) {
		jFile = new JFileChooser();
		jFile.setFileFilter(filtro);
		int respuesta = jFile.showOpenDialog(null);
		if (respuesta == JFileChooser.APPROVE_OPTION) {
			file = jFile.getSelectedFile();
			try {
				setInmobiliariaYClientes((EnvoltorioPadre) Ficheros.abrir(file));
				setInmobiliaria(getInmobiliariaYClientes().getInmobiliaria());
				setClientes(getInmobiliariaYClientes().getClientes());
				frame.setTitle(file.getName() + " : " + frame.getTitulo());
				getInmobiliaria().setModificado(false);
			} catch (ClassNotFoundException | IOException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error al guardar", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Metodo que gestiona el guardado de archivos antes de abrir.
	 */
	private static void gestionarAbrir(Principal frame) {
		int respuesta = JOptionPane.showConfirmDialog(null, "Desea guardar el archivo?");
		if (respuesta == JOptionPane.YES_OPTION) {
			guardarComo(frame);
			abrirInmobiliariaYClientes(frame);
		} else if (respuesta == JOptionPane.NO_OPTION)
			abrirInmobiliariaYClientes(frame);
		else
			return;
	}

	/**
	 * Metodo que crea una nueva inmobiliaria.
	 */
	protected static void nuevo(Principal frame) {
		if (getInmobiliaria().isModificado()) {
			gestionarNuevo(frame);
		} else
			iniciarInmobiliariaYClientes(frame);

	}

	/**
	 * Metodo que dependiendo de la respuesta del usuario guarda el archivo y
	 * crea una nueva inmobiliaria, crea la nueva inmobiliaria o cancela.
	 */
	private static void gestionarNuevo(Principal frame) {
		int respuesta = JOptionPane.showConfirmDialog(null, "Desea guardar el archivo?");
		if (respuesta == JOptionPane.YES_OPTION) {
			int respuestaGuardar = guardarComo(frame);
			if (respuestaGuardar != JFileChooser.CANCEL_OPTION)
				iniciarInmobiliariaYClientes(frame);
		} else if (respuesta == JOptionPane.NO_OPTION) {
			iniciarInmobiliariaYClientes(frame);
		} else
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}

	/**
	 * Metodo que incia una inmobiliaria.
	 */
	private static void iniciarInmobiliariaYClientes(Principal frame) {
		setInmobiliaria(new Inmobiliaria());
		setClientes(new EnvoltorioClientes());
		frame.setTitle("Sin titulo : " + frame.getTitulo());
		file = null;
	}

	/**
	 * Metodo que sale del programa.
	 */
	protected static void salir(Principal frame) {
		if (getInmobiliaria().isModificado())
			gestionarSalir(frame);
		else
			System.exit(0);
	}

	/**
	 * Metodo que dependiendo de la respuesta del usuario guarda el archivo y
	 * sale del programa, sale del programa o cancela.
	 */
	private static void gestionarSalir(Principal frame) {
		int respuesta = JOptionPane.showConfirmDialog(null, "Desea guardar el archivo");
		if (respuesta == JOptionPane.YES_OPTION) {
			int respuestaGuardar = guardarComo(frame);
			if (respuestaGuardar != JFileChooser.CANCEL_OPTION)
				System.exit(0);
		} else if (respuesta == JOptionPane.NO_OPTION)
			System.exit(0);
		else
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	}

	public static Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	protected static void setInmobiliaria(Inmobiliaria inmobiliaria) {
		Gestion.inmobiliaria = inmobiliaria;
	}

	public static EnvoltorioClientes getClientes() {
		return clientes;
	}

	public static void setClientes(EnvoltorioClientes clientes) {
		Gestion.clientes = clientes;
	}

	public static EnvoltorioPadre getInmobiliariaYClientes() {
		return inmobiliariaYClientes;
	}

	public static void setInmobiliariaYClientes(EnvoltorioPadre inmobiliariaYClientes) {
		Gestion.inmobiliariaYClientes = inmobiliariaYClientes;
	}
}
