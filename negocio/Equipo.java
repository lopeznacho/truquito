package negocio;

import java.util.ArrayList;

public class Equipo {

	private JugadorTruco jugador1;
	private JugadorTruco jugador2;
	
	public Equipo (JugadorTruco jugador1,JugadorTruco jugador2){
		this.jugador1=jugador1;
		this.jugador2=jugador2;
		
	}

	public JugadorTruco getJugador1() {
		return this.jugador1;
	}
	
	public JugadorTruco getJugador2() {
		return this.jugador2;
	}
}
