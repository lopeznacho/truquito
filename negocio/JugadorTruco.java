package negocio;

public class JugadorTruco {
	private int id;
	private String apodo;
	private String email;
	private String password;
	private int partidas;
	private int puntos;
	
	private static int auto_id = 0;
	
	public JugadorTruco(String apodo, String email, String password,
			int partidas, int puntos) {
		super();
		this.id = generarID();
		this.apodo = apodo;
		this.email = email;
		this.password = password;
		this.partidas = partidas;
		this.puntos = puntos;
	}
	

	private static int generarID() {
		return auto_id++;
	}


	public int getId() {
		return id;
	}

	public String getApodo() {
		return apodo;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getPartidas() {
		return partidas;
	}

	public int getPuntos() {
		return puntos;
	}

	
	

}
