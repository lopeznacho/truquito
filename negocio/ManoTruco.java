package negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import javax.naming.ldap.Rdn;

public class ManoTruco {
	
	private Mazo mazo;
	//private EstadoJugador[] estados;
	
	private EstadoMano estadoMano;
	
	private ArrayList<JugadorTruco>jugadores;
	private int nroBaza;
	private int turno;
	private int nroMano;
	//private int posicionJugadorMano;
	private int[] pies;

	public ManoTruco(ArrayList<JugadorTruco>jugadores){
		this.jugadores= jugadores;
		//this.posicionJugadorMano=0;
	}


	public void iniciarMano(int nroMano) {
		//this.turno=0;
		
		System.out.println();
		System.out.println("Iniciando mano "+nroMano);
		System.out.println();
		
		this.nroMano=nroMano;
		this.nroBaza=0;
		this.estadoMano = new EstadoMano();
	//	this.estados = new EstadoJugador[4];
		this.inicializarEstados();
		
		this.mazo = new Mazo();
		this.mazo.mezclar();
		this.repartirCartas();
		
		this.asignarJugadorMano();
		this.pies= this.getPies();
		
		System.out.println();
		System.out.println("Jugador Mano "+jugadores.get(this.estadoMano.getPosicionJugadorMano()).getApodo());
		System.out.println();
		System.out.println();
		System.out.println("Jugadores Pie "+jugadores.get(this.pies[0]).getApodo());
		System.out.println("Jugadores Pie "+jugadores.get(this.pies[1]).getApodo());
		System.out.println();
		
		
		while(!this.terminoMano()){
			
			this.asignarTurno();
			
			for(int i=0;i<4;i++){
				System.out.print("Cartas jugador "+jugadores.get(i).getApodo()+": ");
				//this.estados[i].mostrarCartasDisponibles();
				this.estadoMano.mostrarCartasDisponiblesJugador(i);
				
			}
			
			System.out.println();
			
			System.out.println("Inicio baza "+this.nroBaza);
			for(int i=0;i<4;i++){
				this.comienzaTurno();
				
				this.siguienteTurnoBaza();
				
			}
			System.out.println();
			
			
			this.estadoMano.setEquipoGanadorBaza(nroBaza);
			
			//TODO: revisar esto
			this.nroBaza++;
			this.estadoMano.siguienteBaza();
			
			
		}
			
		
	}
	private void comienzaTurno() {
		System.out.println("Comienza turno de "+jugadores.get(turno).getApodo());
		//this.estados[turno].mostrarCartasDisponibles();
		this.estadoMano.mostrarCartasDisponiblesJugador(turno);
		
		
		int posicion=-1;
		do{
			System.out.println("Seleccione (1/2/3)");
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			String s="";
			try {
				s = bufferRead.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			posicion = Integer.parseInt(s)-1;
			
		}
		//while(!this.estados[turno].puedeJugarCarta(posicion));
		while(!this.estadoMano.puedeJugarCarta(turno,posicion));
		
		//Carta c = this.estados[turno].getCartaPorPosicion(posicion);
		Carta c = this.estadoMano.getCartaPorPosicion(turno, posicion);
		
		//this.estados[turno].jugarCarta(c);
		this.estadoMano.jugarCarta(turno,c);
		
        
		
	}

	private void asignarJugadorMano() {
		if(this.nroBaza==0){
			if(this.nroMano == 0){
				this.estadoMano.setPosicionJugadorMano(0);
				//this.posicionJugadorMano = 0;
			}
			else if(this.nroMano>0){
				this.estadoMano.setPosicionJugadorMano(nroMano%4);
				//this.posicionJugadorMano = nroMano%4;
			}
		}
		
		
	}

	private void siguienteTurnoBaza() {
		this.turno++;
		if(this.turno==4)
			this.turno=0;
		
	}

	private void asignarTurno() {
		if(this.nroBaza==0){
			this.turno=this.estadoMano.getPosicionJugadorMano();
		}
		else{
			int t = this.getPosicionGanadorBazaAnterior();
			if(t!=-1){ //Devuelve -1 si es parda
				this.turno = t;
			}
			else{
				this.turno = this.estadoMano.getPosicionJugadorMano();
			}
			
		}
		
	}
	
	public int[] getPuntos() {
		int puntos[] = new int[2];
		
		puntos[0]=0;
		puntos[1]=0;
		
		puntos[this.estadoMano.getEquipoGanadorMano()]=2;
		
		return puntos;
	}

	private int getPosicionGanadorBazaAnterior() {
		return this.estadoMano.getGanadorBaza(this.nroBaza-1);
		
	}

	private boolean terminoMano() {
		return !this.quedanBazas() || this.hayGanador();
	}
	
	private boolean hayGanador() {
		return this.estadoMano.hayGanadorMano();
	}

	private boolean quedanBazas(){
		return this.nroBaza<3;
	}

	private void inicializarEstados() {
		/*for(int i=0;i<4;i++){
			this.estados[i] = new EstadoJugador();
		}*/
		this.estadoMano.inicializarEstados();
		
	}

	public int[] getPies(){
		int[] pies = new int[2];
		//switch (this.turno) {
		switch (this.estadoMano.getPosicionJugadorMano()) {
		case 0:
			pies[0]=2;
			pies[1]=3;
			break;
		case 1:
			pies[0]=3;
			pies[1]=0;
			break;
		case 2:
			pies[0]=0;
			pies[1]=1;
			break;
		case 3:
			pies[0]=1;
			pies[1]=2;
			break;

		}
		return pies;
	}
	
	public void repartirCartas(){
		for(int i=0;i<3;i++){
			for(int j=0;j<4;j++){
				this.estadoMano.agregarCarta(j, this.mazo.getCarta());
				//this.estados[j].agregarCarta(this.mazo.getCarta());
			}
			
		}
	}
	
/*	public JugadorTruco turnoJugador(){
		//TODO: implementar
		return this.jugadores.get((int)(Math.random()*4));
	}*/
	public void proximoTurno(){
		
	}
	
	
	public void registrarPuntos() {
		
	}

}
