import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.awt.event.*;

class BusquedaSecuencial extends JFrame implements ActionListener{

	JPanel panel;
	
	JLabel jlTitulo_1;
	ImageIcon iTitulo_1;
	JLabel jlNotificacion;

	ImageIcon iBuscar;
	JButton btnBuscar;

	JTextField txfNumero;

	JTextArea txaLista;
	int lista[];
	JScrollPane scbar;

	public BusquedaSecuencial()
	{
		this.setTitle("BUSQUEDA SECUENCIAL");
		this.setBounds(150,100,480, 545);

		componentes();

		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false); //Evitar que se puede hacer mas pequena la ventana
		this.setVisible(true);

		//Escuchar los botones
		btnBuscar.addActionListener(this);
	}

	private void componentes(){

		colocarFondo();
		colocarEtiquetas();
		colocarBotones();
		colocarAreas();
		
	}

	private void colocarFondo(){

		panel = new JPanel();
		panel.setLayout(null);
		this.getContentPane().add(panel);
	}

 	private void colocarEtiquetas(){

 		//Titulo de la ventana
 		try{
			iTitulo_1 = new ImageIcon ("./imagenes/titulo.png");
			jlTitulo_1 = new JLabel();
			jlTitulo_1.setBounds(50, 10, 380, 80); //(x, y, w, h)
			jlTitulo_1.setIcon(new ImageIcon(iTitulo_1.getImage().getScaledInstance(jlTitulo_1.getWidth(),jlTitulo_1.getHeight(),Image.SCALE_SMOOTH)));
			jlTitulo_1.setHorizontalAlignment(SwingConstants.CENTER);
		}catch(Exception e){
			System.out.println("Error al cargar imagen.");
		} 

		//Notificacion
		jlNotificacion = new JLabel();
		jlNotificacion.setBounds(50,450,220,40);

		//Agregar al panel
		panel.add(jlTitulo_1);
		panel.add(jlNotificacion);
 	}

 	private void colocarBotones(){

 		//Boton para guardar
 		try{
			iBuscar = new ImageIcon("./imagenes/buscar.png");
			btnBuscar = new JButton();
			btnBuscar.setBounds(325, 400, 85, 40); //(x, y, w, h)
			btnBuscar.setOpaque(true);
			btnBuscar.setBackground(Color.GRAY);
			btnBuscar.setIcon(new ImageIcon(iBuscar.getImage().getScaledInstance(btnBuscar.getWidth(),btnBuscar.getHeight(),Image.SCALE_SMOOTH)));
		}catch(Exception e){
			System.out.println("Error al cargar imgaen de boton.");
		}
		
		//Agregar botones al panel
		panel.add(btnBuscar);
 	}

 	private void colocarAreas(){

 		//Mostras la lista
 		txaLista = new JTextArea();
		txaLista.setBounds(50,90,380,300);
		txaLista.setFont(new Font("Arial",2,18));
		txaLista.setBackground(Color.WHITE);
		crearNumero();
		txaLista.setEditable(false);

		//Numero a buscar
		txfNumero = new JTextField();
		txfNumero.setBounds(50,400,220,40);
		txfNumero.setFont(new Font("Arial",2,18));

		//Scrollbar
		scbar = new JScrollPane();
		scbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scbar.setBounds(50,90,380,300);
		scbar.getViewport().add(txaLista);

		//Agregar al panel
		panel.add(txfNumero);
		panel.add(scbar);
 	}

	public void actionPerformed(ActionEvent event){

		if(event.getSource() == this.btnBuscar){
			
			try{
				String numS = txfNumero.getText();
				int numI = Integer.parseInt(numS);

				boolean encontrar = false;
				int i = 0;

				while((i<13) && !encontrar){
					if(lista[i++] == numI){
						encontrar = true;
					}
				}

				if(encontrar){
					jlNotificacion.setText("Se ha encontrado en la lista");
				}else{
					jlNotificacion.setText("No se ha encontrado en la lista");
				}

			}catch(Exception e){
				jlNotificacion.setText("Error al buscar");
			}
		}
	}

	public void crearNumero(){
		lista = new int[13];
 		String escribir = "";

 		for (int i=0;i<13;i++) {
 			lista[i] = (int)(Math.random()*50+1);
 			escribir = escribir + Integer.toString(lista[i]) + "\n";
 			//escribir = escribir + lista.get(i) + "\n";
 		}

 		txaLista.setText(escribir);
		txaLista.setEditable(false);
	}

	public static void main(String[] args) {
		
		BusquedaSecuencial bS = new BusquedaSecuencial();

	}
}