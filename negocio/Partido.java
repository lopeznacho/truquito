package negocio;

public class Partido {

	private String modalidad;
	private Equipo[] equipos;
	private int ganados[];
	private int nroPartida;
	private PartidaTruco partida;
	
	public Partido(Equipo equipo1, Equipo equipo2, String modalidad){
		this.equipos= new Equipo[2];
		this.ganados = new int[2];
		this.modalidad = modalidad;
		this.setEquipos(equipo1,equipo2);
		this.iniciarPartido();
	}

	private void iniciarPartido() {

		while(this.nadieGano()){
			System.out.println();
			System.out.println("Iniciando partida "+ this.nroPartida);
			this.partida = new PartidaTruco(this.equipos[0],this.equipos[1]);
			this.registrarGanador();
			nroPartida++;
		}
		System.out.println("");
		
	}

	private void registrarGanador() {
		this.ganados[this.partida.getGanador()]++;
		
	}

	private boolean nadieGano() {
		return (this.ganados[0]<2 && this.ganados[1]<2);
	}

	private void setEquipos(Equipo equipo1, Equipo equipo2) {
		this.equipos[0]=equipo1;
		this.equipos[1]=equipo2;
		
	}
	
	public String getModalidad(){
		return this.modalidad;
	}
	
}
