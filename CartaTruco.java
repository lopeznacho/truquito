/* Representa las carta del truco. Con los valores correspondientes en el juego
<B> Pesos de las Cartas <B>
 * 1  de espada 35
 * 1  de bastos 30
 * 7  de espada 27
 * 7  de oro 25
 * Todos los 3 20
 * Todos los 2 18
 * El resto de los 1 15
 * El resto de las cartas tienen el mismo peso que el nro que le corresponde
 */
package py.edu.uca.fcyt.toluca.game;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import py.edu.uca.fcyt.game.Carta;

public class TrucoCarta extends Carta {
	private byte ValueInGame = 0;	//Guarda el valor de la carta
	
	public TrucoCarta()
	{
		super();
	}

	public byte getValueInGame(){
		return ValueInGame;
	}
        /**
         * Calcula y guarda el peso de la carta
         * Kind: el palo de la carta
         * Value: el valor del numero de la misma
         */
	private void agregarValor(byte kind,byte value)
	{
		if(kind==super.ESPADA && value==1)
			ValueInGame=35;
		else if (kind==super.BASTO && value==1)
			ValueInGame=30;
		else if (kind==super.ESPADA && value==7)
			ValueInGame=27;
		else if (kind==super.ORO && value==7)
			ValueInGame=25;
		else if (value==3)
			ValueInGame=20;
		else if (value==2)
			ValueInGame=18;
		else if (value==1)
			ValueInGame=15;
		else
			ValueInGame=value;
			
	}
        /**
        * Constructor de TrucoCarta
        * Calcula tambien el peso de la carta
        * Kind: el palo de la carta
        * Value: el valor del numero de la misma
        */
        
	public TrucoCarta(int kind, int value) {
		super(kind, value);
		agregarValor((byte) kind,(byte) value);
	}
	
	public boolean equals(TrucoCarta tc) {
            if (tc == null){
                System.out.println("truco Carta error tc == null");
            }
            if (getKind() == tc.getKind() && getValue() == tc.getValue())
			return true;
	    else 
	    	return false;
	}
	public static void main(String[] args) {
		TrucoCarta Carta=new TrucoCarta(Carta.BASTO,7);
		Carta a=new Carta(Carta.COPA,2);
		XMLEncoder e=new XMLEncoder(new BufferedOutputStream(System.out));
		e.writeObject(Carta);
		e.close();
	}
	/**
	 * @param valueInGame The valueInGame to set.
	 */
	public void setValueInGame(byte valueInGame) {
		ValueInGame = valueInGame;
	}
}
