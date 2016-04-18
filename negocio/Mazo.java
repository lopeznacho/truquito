package negocio;

public class Mazo {

	/** Crea una instancia de mazo */
    private Carta[] mazo = new Carta[40];
    int cursor;
    public Mazo() {
        cursor =0;
        createMazo();
    }
    private void createMazo(){
        int j=0; //indice auxiliar
        for (int i=1; i<=12; i++){
            if (i<8 || i>9){
                mazo[j++] = new Carta(Carta.ESPADA,i);
                mazo[j++] = new Carta(Carta.COPA,i);
                mazo[j++] = new Carta(Carta.BASTO,i);
                mazo[j++] = new Carta(Carta.ORO,i);
            }
        }
    }
    public void mezclar(){
        int posori, posdes;
        Carta Cartaauxiliar;
        for (int i=0; i<200; i++){
            posori = (int)(Math.random()*40); //dos posiciones aleatorias e intercambiar
            posdes = (int)(Math.random()*40);
            Cartaauxiliar = mazo[posori];
            mazo[posori] = mazo[posdes];
            mazo[posdes] = Cartaauxiliar;
        }
        cursor =0;
    }
    public Carta getCarta(){
        return (mazo[cursor++]);
    }
 
    /*public Carta getCarta(int miPalo, int miValor){
    	for (int i=0; i<40; i++){
    		if (mazo[i].getPalo() == miPalo && mazo[i].getValor() == miValor)
    			return mazo[i];	
    	}
    	return null;
    
    }*/
}
