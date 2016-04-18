package negocio;

import java.util.Hashtable;

public class Carta {
	
	public static final int ORO = 1;
	public static final int ESPADA = 2;
	public static final int COPA = 3;
	public static final int BASTO = 4;
	
	private int valor;
	private boolean usada;
	private int palo;
	private int valorEnJuego;
	public static final Hashtable nombresPalos = getNombresPalos();

	public Carta(int palo, int valor)
	{
		setPalo(palo);
		setValor(valor);
		agregarValor(palo, valor);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		if (valor < 1 || valor > 12) throw new RuntimeException("Valor invalido");
		this.valor = valor;
	}

	public boolean estaUsada() {
		return usada;
	}

	public void setUsada(boolean usada) {
		this.usada = usada;
	}
	

	public int getPalo() {
		return palo;
	}

	public void setPalo(int palo) {
		if (palo < 1 || palo > 4) throw new RuntimeException("Palo invalido");
		this.palo = palo;
	}

	public int getValorEnJuego() {
		return valorEnJuego;
	}

	public void setValorEnJuego(int valorEnJuego) {
		
		this.valorEnJuego = valorEnJuego;
	}
	
	private static Hashtable getNombresPalos()
	{
		Hashtable ret;
    	
		ret = new Hashtable();
		ret.put(new Integer(COPA), "Copa");
		ret.put(new Integer(ORO), "Oro");
		ret.put(new Integer(BASTO), "Basto");
		ret.put(new Integer(ESPADA), "Espada");
		return ret;
	}
	
	public String getNombrePalo()
	{
		return (String) nombresPalos.get(this.getPalo());
	}
	
	private void agregarValor(int palo,int valor)
	{
		if(palo==ESPADA && valor==1)
			setValorEnJuego(35);
		else if (palo==BASTO && valor==1)
			setValorEnJuego(30);
		else if (palo==ESPADA && valor==7)
			setValorEnJuego(27);
		else if (palo==ORO && valor==7)
			setValorEnJuego(25);
		else if (valor==3)
			setValorEnJuego(20);
		else if (valor==2)
			setValorEnJuego(18);
		else if (valor==1)
			setValorEnJuego(15);
		else
			setValorEnJuego(valor);
			
	}
	
	public void imprimirCarta(){
		System.out.println(this.getString());
	}

	public String getString() {
		// TODO Auto-generated method stub
		return Integer.toString(this.getValor())+" de "+this.getNombrePalo();
	}
	
}
