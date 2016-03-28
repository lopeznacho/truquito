//Falta agregar todas lasmodalidades de juego (marian)

package py.edu.uca.fcyt.game;


public class Juego {
    
    /** Creates a new instance of game */
    protected int numberOfPlayers;
    protected int gameNumber;
    
    public Juego() {
    }
    
    public int getGameNumber() { //obtener el numero de juego
       return (gameNumber);
    } 
    
    public void setGameNumber(int gameNumber) { //asigna el numero de Juego
        this.gameNumber = gameNumber;
    }
    
    public int getNumberOfPlayers() {   //obtener el numero de players
        return numberOfPlayers;
    }
    
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = 4;
    }
}
