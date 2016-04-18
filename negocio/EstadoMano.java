package negocio;

import java.util.ArrayList;

public class EstadoMano {
	
	private EstadoJugador[] estados;
	private Carta[][] cartasJugadas;//bazas,jugadores
	private int nroBaza;
	private int[] ganadoresBaza;
	
	private int posicionJugadorMano;
	
	public EstadoMano(){
		this.cartasJugadas = new Carta[3][4];
		this.nroBaza=0;
		this.posicionJugadorMano=0;
		this.ganadoresBaza = new int[2];
	}

	public void inicializarEstados() {
		this.estados = new EstadoJugador[4];
		for(int i=0;i<4;i++){
			this.estados[i] = new EstadoJugador();
		}
		
	}

	public void agregarCarta(int j, Carta carta) {
		this.estados[j].agregarCarta(carta);
		
	}

	public void mostrarCartasDisponiblesJugador(int posicionJugador) {
		this.estados[posicionJugador].mostrarCartasDisponibles();
		
	}

	public boolean puedeJugarCarta(int posicionJugador, int posicionCarta) {
		if(posicionCarta>=0 && posicionCarta <3){
			return this.estados[posicionJugador].puedeJugarCarta(posicionCarta);
		}
		return false;
	}

	public Carta getCartaPorPosicion(int posicionJugador, int posicionCarta) {
		return this.estados[posicionJugador].getCartaPorPosicion(posicionCarta);
	}

	public void jugarCarta(int posicionJugador, Carta c) {
		
		if(this.estados[posicionJugador].puedeJugarCarta(c) && this.cartasJugadas[this.nroBaza][posicionJugador]==null){
			this.cartasJugadas[this.nroBaza][posicionJugador] = c;
			this.estados[posicionJugador].jugarCarta(c);
		}
		
		
	}

	public void siguienteBaza() {
		this.nroBaza++;
		
	}
	
	private int hallarMayorCarta(int equipo,int nroBaza)
	{
		//System.out.println("hallarMayorCarta - sm - equipo " + equipo + "ronda " + Ronda);
		int valor=0,i,quien=0;
		for(i=equipo; i<4; i+=2)
		{
			if(cartasJugadas[nroBaza][i]!=null && valor<=cartasJugadas[nroBaza][i].getValorEnJuego())
			{
				valor=cartasJugadas[nroBaza][i].getValorEnJuego();
				quien=i;
			}
		}
		return quien;//retorna el lugar donde esta la carta mayor
	}
	

	public int getGanadorBaza(int nroBaza) {
		
		int i=0,eq1=0,eq2=0,v1,v2;
		eq1=hallarMayorCarta(0,nroBaza);//el jugador con la carta mas alta
		eq2=hallarMayorCarta(1,nroBaza);
		
		v1=cartasJugadas[nroBaza][eq1].getValorEnJuego();//el valor de su carta mas alta
		v2=cartasJugadas[nroBaza][eq2].getValorEnJuego();
		
		if(v1>v2)
			return eq1;
		else if (v2>v1)
			return eq2;
		else//si empate
			return -1;
		
	}
public int getEquipoGanadorBaza(int nroBaza) {
		
		int i=0,eq1=0,eq2=0,v1,v2;
		eq1=hallarMayorCarta(0,nroBaza);//el jugador con la carta mas alta
		eq2=hallarMayorCarta(1,nroBaza);
		
		v1=cartasJugadas[nroBaza][eq1].getValorEnJuego();//el valor de su carta mas alta
		v2=cartasJugadas[nroBaza][eq2].getValorEnJuego();
		
		if(v1>v2)
			return 0;
		else if (v2>v1)
			return 1;
		else//si empate
			return -1;
		
	}

	public int getPosicionJugadorMano() {
		return posicionJugadorMano;
	}

	public void setPosicionJugadorMano(int posicionJugador) {
		this.posicionJugadorMano = posicionJugador;
		
	}

	public void setEquipoGanadorBaza(int nroBaza) {
		int ganador = this.getEquipoGanadorBaza(nroBaza);
		if(ganador!=-1){
			this.ganadoresBaza[ganador]++;
			System.out.println("Gano baza equipo: "+ganador);
		}
		
	}

	public boolean hayGanadorMano() {
		return this.ganadoresBaza[0]==2 || this.ganadoresBaza[1]==2;
	}

	public int getEquipoGanadorMano() {
		if(this.ganadoresBaza[0]==2){
			return 0;
		}
		else if(this.ganadoresBaza[1]==2){
			return 1;
		}
		return -1; // TODO : revisar
	}
	
	

}
