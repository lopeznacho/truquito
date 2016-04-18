package negocio;

import java.util.ArrayList;

public class EstadoJugador {

	private int cantidadCartas;
	
	private ArrayList<Carta> cartas;
	
	public EstadoJugador(){
		this.cantidadCartas = 0;
		this.cartas = new ArrayList<Carta>();
	}
	
	public void jugarCarta(Carta carta){
		if(this.puedeJugarCarta(this.cartas.indexOf(carta))){
			this.obtenerCarta(carta).setUsada(true);
			System.out.println(carta.getString());
		}
		else{
			
			//TODO: tirar excepcion
		}
		
	}
	
	public Carta getCartaPorPosicion(int posicion){
		if(posicion<3)
			return this.cartas.get(posicion);
		else
			//TODO: devolver excepcion
			return null;
	}
	
	private Carta obtenerCarta(Carta carta){
		return this.cartas.get(this.cartas.indexOf(carta));
	}
	
	public boolean puedeJugarCarta(int posicion) {
		boolean puede = false;
		if(posicion>=0 && posicion <3){
			puede = !getCartaPorPosicion(posicion).estaUsada();
			if(!puede){
				System.out.println("No pued jugar esa carta: ya esta jugada");
			}
		}
		else{
			System.out.println("Seleccione posicion correcta");
		}
		return puede;
	}

	public void agregarCarta(Carta carta){
		if(this.cantidadCartas<3){
			this.cartas.add(carta);
			this.cantidadCartas++;
		}
		else{
			//TODO : tirar excepcion
		}
		
	}

	public void mostrarCartas() {
		for( int i = 0 ; i < cartas.size() ; i++ ){
			  System.out.print( cartas.get(i).getString() + " - " );
			}
		System.out.println();
	}
	
	public void mostrarCartasDisponibles() {
		for( int i = 0 ; i < cartas.size() ; i++ ){
			if(!cartas.get(i).estaUsada()){
				System.out.print("Carta "+(i+1)+" : ");
				System.out.print( cartas.get(i).getString() + " - " );
			}
		}
		System.out.println();
	}

	public boolean puedeJugarCarta(Carta c) {
		return this.puedeJugarCarta(cartas.indexOf(c));
	}
}
