public class mazo {
    
    /** Crea una instancia de mazo */
    private CartaTruco[] mazo = new CartaTruco[40];
    int cursor;
    public mazo() {
        cursor =0;
        createmazo();
    }
    private void createmazo(){
        int j=0; //indice auxiliar
        for (int i=1; i<=12; i++){
            if (i<8 || i>9){
                mazo[j++] = new CartaTruco(Card.ESPADA,i);
                mazo[j++] = new CartaTruco(Card.COPA,i);
                mazo[j++] = new CartaTruco(Card.BASTO,i);
                mazo[j++] = new CartaTruco(Card.ORO,i);
            }
        }
    }
    public void mezclar(){
        int posori, posdes;
        CartaTruco CartaTrucoauxiliar;
        for (int i=0; i<200; i++){
            posori = (int)(Math.random()*40); //dos posiciones aleatorias e intercambiar
            posdes = (int)(Math.random()*40);
            CartaTrucoauxiliar = mazo[posori];
            mazo[posori] = mazo[posdes];
            mazo[posdes] = CartaTrucoauxiliar;
        }
        cursor =0;
    }
    public CartaTruco getCartaTruco(){
        return (mazo[cursor++]);
    }
    public CartaTruco getCarta(byte myKind, byte myValue){
    	for (int i=0; i<40; i++){
    		if (mazo[i].getKind() == myKind && mazo[i].getValue() == myValue)
    			return mazo[i];	
    	}
    	return null;
    
    }
}
