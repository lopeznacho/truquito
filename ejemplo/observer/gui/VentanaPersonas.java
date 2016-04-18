package ejemplo.observer.gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ejemplo.observer.observer.Observer;

public class VentanaPersonas extends JFrame implements Observer, ActionListener{

	private static final long serialVersionUID = 1L;

	private JTable table;
	private DefaultTableModel listaDeAcciones;
	private JButton btnSalir;
	private Vector<String> cabecera = new Vector<String>();
	
	public VentanaPersonas(String nombre)
	{
		setTitle("Pantalla de " + nombre);
		cabecera.add("Acciones");
		listaDeAcciones = new DefaultTableModel();
		listaDeAcciones.setColumnCount(1);
		listaDeAcciones.setColumnIdentifiers(cabecera);
		initUI();
		//this.setLocation(0 + (50 * (i-1)), 0+ (100 * (i - 1)));
		setVisible(true);
		this.pack();
	}

	private void initUI()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(5, 5));
		table = new JTable(listaDeAcciones);
		JScrollPane tableScrollPane = new JScrollPane(table);
		getContentPane().add(tableScrollPane, BorderLayout.CENTER);
		JPanel pnlSur = new JPanel(new GridLayout(1,3));
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		pnlSur.add(new JLabel());
		pnlSur.add(btnSalir);
		getContentPane().add(pnlSur, BorderLayout.SOUTH);
	}
		

	@Override
	public void update(String mensaje) {
		Vector<String> aux;
		aux = new Vector<String>();
		aux.add(mensaje);

		listaDeAcciones.addRow(aux);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnSalir))
		{
			System.exit(0);
		}
	} 
}
