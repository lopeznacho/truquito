package test;

import ejemplo.observer.gui.VentanaPersonas;
import negocio.Carta;
import negocio.Equipo;
import negocio.JugadorTruco;
import negocio.Mazo;
import negocio.PartidaTruco;
import negocio.Partido;

public class Main {

	public static void main(String[] args) {

		JugadorTruco jugador1 = new JugadorTruco("Tuta","ferraa@hotmail.com","12345",3,1000);
		JugadorTruco jugador2 = new JugadorTruco("Ivi","ivi@hotmail.com","12345",4,1001);
		JugadorTruco jugador3 = new JugadorTruco("Ari","ari@hotmail.com","12345",3,1002);
		JugadorTruco jugador4 = new JugadorTruco("Marian","marian@hotmail.com","12345",3,1003);
		
		Equipo equipo1 = new Equipo(jugador1, jugador2);
		Equipo equipo2 = new Equipo(jugador3, jugador4);
		
		//new VentanaPersonas(1);
		
	//	Partido partido = new Partido(equipo1, equipo2,"Modalidad 1");
		(new Partido(equipo1,equipo2,"Modalidad 1")).start();
		
		(new Partido(equipo1,equipo2,"Modalidad 1")).start();

	}

}
