package proyectoInmobiliaria.inmobiliariaGui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * JDialog Ayuda, que muestra el funcionamiento de las ventanas.
 * 
 * @author Miguel &Aacute;ngel Zamora Blanco
 * @version 1.0
 */
public class Ayuda extends JDialog {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setTitle("Ayuda");
		setResizable(false);
		setBounds(100, 100, 504, 505);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblAsd = new JLabel(
				"<html>\r\nMenu Ficheros\r\n<ul<\r\n\t<li>Nuevo: Crea una nueva inmobiliaria.</li>\r\n\t<li>Abrir: Abre una inmobiliaria.</li>\r\n\t<li>Guardar: Guarda una inmobiliaria.</li>\r\n\t<li>Guardar Como: Guarda la inobiliaria especificando la ruta.</li>\r\n\t<li>Salir: Se sale de la aplicacion.</li>\r\n</ul>\r\nMenu Edificaciones\r\n<ul>\r\n\t<li>A\u00F1adir: A\u00F1ade una edificacion a la inmobiliaria.</li>\r\n\t<li>Eliminar: Elimina una edificacion de la inmobiliaria.</li>\r\n\t<li>Mostrar: Muestra todas las edificaciones.</li>\r\n\t<li>Numero de Edifiiaciones: Muestra el numero de edificaciones</li>\r\n</ul>\r\nMenu Acciones\r\n<ul>\r\n\t<li>Comprar: Compra una edificacion.</li>\r\n\t<li>Alquilar: Alquila una edificacion</li>\r\n\t<li>Calcular: Calcula el precio de una edificacion.</li>\r\n</ul>\r\n</html>");
		lblAsd.setBounds(10, 0, 493, 359);
		contentPanel.add(lblAsd);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
