package ejemplo.observer.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Ventana extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNombre, lblApellido, lblTelefono;
	private JTextField txtNombre, txtApellido, txtTelefono;
	private JButton btnAgregar, btnBorrar;
	
	public Ventana()
	{
		initVentana();
		eventos();
	}

	private void eventos()
	{
		btnAgregar.addActionListener(this);
		btnBorrar.addActionListener(this);
		this.setVisible(true);
		this.pack();
	}
	
	private void initVentana() {
		Container c = this.getContentPane();
		c.setLayout(new BorderLayout());
		
		lblNombre = new JLabel("Nombre");
		lblApellido = new JLabel("Apellido");
		lblTelefono = new JLabel("Telefono");
		txtApellido = new JTextField();
		txtNombre = new JTextField();
		txtTelefono = new JTextField();
		btnAgregar = new JButton("Agregar");
		btnBorrar = new JButton("Borrar");
		
		JPanel pnlCentro = new JPanel(new GridLayout(4,2));
		pnlCentro.add(lblNombre);
		pnlCentro.add(txtNombre);
		pnlCentro.add(lblApellido);
		pnlCentro.add(txtApellido);
		pnlCentro.add(lblTelefono);
		pnlCentro.add(txtTelefono);
		pnlCentro.add(btnAgregar);
		pnlCentro.add(btnBorrar);
		
		c.add(pnlCentro,BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent btn) {
		if(btn.getSource().equals(btnBorrar))
		{
			txtApellido.setText("");
			txtNombre.setText("");
			txtTelefono.setText("");
		}

	}
}
