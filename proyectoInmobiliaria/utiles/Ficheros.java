package proyectoInmobiliaria.utiles;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase Ficheros.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 * @param <T>
 *            Generico.
 */
public class Ficheros<T> {

	/**
	 * Metodo que guarda un objeto en un fichero.
	 * 
	 * @param o
	 *            Objeto que se guarda.
	 * @param file
	 *            Fichero donde se guarda el objeto.
	 * @throws FileNotFoundException
	 *             Si el fichero no existe,
	 * @throws IOException
	 *             Si hay un error de E/S.
	 */
	public static void guardarComo(Object o, File file) throws FileNotFoundException, IOException {
		file = annadirExtension(file);
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
			out.writeObject(o);
		}
	}

	/**
	 * Metodo que inserta una extension al archivo.
	 * 
	 * @param file
	 *            Fichero al que se le inserta la extension.
	 * @return Devuelve el fichero con la extension.
	 */
	public static File annadirExtension(File file) {
		if (!file.getName().endsWith(".obj"))
			file = new File(file + ".obj");
		return file;
	}

	/**
	 * Metodo que lee un objeto de un fichero.
	 * 
	 * @param file
	 *            Fichero donde hay un objeto guardado.
	 * @return Devuelve la lectura del objeto.
	 * @throws FileNotFoundException
	 *             Si el fichero no existe.
	 * @throws IOException
	 *             Si hay un error de E/S.
	 * @throws ClassNotFoundException
	 *             Si la clase no existe.
	 */
	public static Object abrir(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		file = annadirExtension(file);
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
			return in.readObject();
		}
	}
}
