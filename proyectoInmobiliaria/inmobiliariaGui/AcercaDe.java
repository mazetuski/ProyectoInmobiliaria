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
 * JDialog AcercaDe, que muestra informacion del proyecto.
 * 
 * @author Miguel &Aacute;ngel Zamrora Blanco
 * @version 1.0
 *
 */
public class AcercaDe extends JDialog {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setTitle("Acerca De..");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 273, 160);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblProyectoInmobiliaria = new JLabel("Proyecto Inmobiliaria 2016");
			lblProyectoInmobiliaria.setBounds(10, 11, 268, 14);
			contentPanel.add(lblProyectoInmobiliaria);
		}
		{
			JLabel lblAutorMiguelngel = new JLabel("Autor: Miguel \u00C1ngel Zamora Blanco");
			lblAutorMiguelngel.setBounds(10, 36, 252, 14);
			contentPanel.add(lblAutorMiguelngel);
		}
		{
			JLabel lblVersion = new JLabel("Version 1.0");
			lblVersion.setBounds(10, 61, 145, 14);
			contentPanel.add(lblVersion);
		}

		JLabel lblNewLabel = new JLabel((String) null);
		lblNewLabel.setBounds(10, 86, 46, 14);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
