package proyectoInmobiliaria.inmobiliariaGui;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * JDialog VentanaMostrarModificar.
 * 
 * @author Miguel &Aacute;ngel ZAmora Blanco
 * @version 1.0
 */
public class VentanaMostrarModificar extends VentanaPadre {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	protected JCheckBox chckbxAlquilado;
	protected JTextField textDiasAlquiler;
	protected JLabel lblDiasAlquiler;

	/**
	 * Create the dialog.
	 */
	public VentanaMostrarModificar() {
		chckbxAlquilado = new JCheckBox("Alquilado");
		chckbxAlquilado.setEnabled(false);
		chckbxAlquilado.setBounds(223, 164, 97, 23);
		getContentPane().add(chckbxAlquilado);

		lblDiasAlquiler = new JLabel("<html>\r\nDias Alquiler<br/>\r\nRestantes\r\n</html>");
		lblDiasAlquiler.setBounds(10, 155, 103, 44);
		getContentPane().add(lblDiasAlquiler);

		textDiasAlquiler = new JTextField();
		textDiasAlquiler.setBounds(123, 165, 86, 20);
		getContentPane().add(textDiasAlquiler);
		textDiasAlquiler.setColumns(10);
		textDiasAlquiler.setEnabled(false);
	}

	/**
	 * Metodo que comprueba si una edificacion esta alquilada.
	 */
	protected void comprobarAlquilado() {
		if (edificacion.isAlquilado()) {
			chckbxAlquilado.setSelected(true);
			lblDiasAlquiler.setVisible(true);
			textDiasAlquiler.setVisible(true);
			textDiasAlquiler.setText("" + ChronoUnit.DAYS.between(LocalDate.now(), edificacion.getFecha()));
		} else {
			chckbxAlquilado.setSelected(false);
			textDiasAlquiler.setVisible(false);
			lblDiasAlquiler.setVisible(false);
		}
	}
}
