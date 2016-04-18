package negocio;

import java.util.ArrayList;

public class PartidaTruco {
	
	private int puntos[] = new int[2];
	private int id;
	private Equipo[] equipos= new Equipo[2];
	private ManoTruco mano;
	private int nroMano;
	private int repartidor;
	private int ganador;
	
	
	
	public PartidaTruco(Equipo equipo1, Equipo equipo2) {
		this.setEquipos(equipo1,equipo2);
		this.mano = new ManoTruco(this.getJugadores());
		this.nroMano=0;
		this.nuevoJuego();
		this.iniciarPartida();
	}



	private ArrayList<JugadorTruco> getJugadores() {
		ArrayList<JugadorTruco> jugadores = new ArrayList<JugadorTruco>();
		
		jugadores.add(this.getEquipo(0).getJugador1());
		jugadores.add(this.getEquipo(1).getJugador1());
		jugadores.add(this.getEquipo(0).getJugador2());
		jugadores.add(this.getEquipo(1).getJugador2());
		
		return jugadores;
		
	}



	private void iniciarPartida() {

		while(this.nadieGano()){

			this.mano.iniciarMano(this.nroMano);
			//Termino la mano, registro los puntos
			this.registrarPuntos();
			nroMano++;
		}
		this.setGanador();
		
	}



	private void setGanador() {
		if(this.getPuntosEquipo(0)>=30)
			this.ganador=0;
		else
			this.ganador=1;
		
	}



	private int getPuntosEquipo(int i) {
		return this.puntos[i];
	}



	private void registrarPuntos() {
		int[] puntos = this.mano.getPuntos();
		this.puntos[0]+=puntos[0];
		this.puntos[1]+=puntos[1];
		System.out.println();
		System.out.println("Puntos equipo1 :" + this.puntos[0]+"  -   Puntos equipo2: " + this.puntos[1]);
		System.out.println();
	}



	private boolean nadieGano() {
		return (this.puntos[0]<30 && this.puntos[1]<30);
	}



	private void nuevoJuego() {
		this.puntos[0]=0;
		this.puntos[1]=0;
		
	}



	private void setEquipos(Equipo equipo1, Equipo equipo2) {
		this.equipos[0]=equipo1;
		this.equipos[1]=equipo2;
		
	}
	
	public Equipo getEquipo(int i)
	{ //retorna el team numero i
		if (i == 0 || i == 1)
			return equipos[i];
		return null;
	}



	public int getGanador() {
		return this.ganador;
	}

}
