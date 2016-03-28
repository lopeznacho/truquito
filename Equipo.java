// Agregar administrador, 

public class Equipo {
    

    /** Numero de jugadores que tiene el Equipo.
     */    
    protected int numberOfPlayers=0;
    /** Nombre del Equipo.
     */    
    protected String name;
    /** Lista de los jugadores que tiene el Equipo.
     */    
    protected ArrayList playersList = new ArrayList();
    /** Contructor del Equipo.
     */    
    public Equipo() { //constructor
        numberOfPlayers = 2;
    }
    /*definir un nombre al Equipo*/
    /** Contructor del Equipo, con un nombre identificador.
     * @param name Nombre del Equipo.
     */    
    public Equipo(String name){
        this.name = name; 
    }
    /*insertar players*/
    /** Adherirse un nuevo jugador al Equipo.
     * @param pl Jugador que se adhiere.
     */    
    public void addPlayer(TrucoPlayer pl){
        numberOfPlayers++;
        playersList.add(pl);
    }
    /*obtener el player numero x*/
    /** Retorna el Player  numero int, del Equipo.
     * @param numberOfPlayer Numero del Player que será Retornado.
     * @return El Player del Equipo.
     */    
    public TrucoPlayer getPlayerNumber (int numberOfPlayer){
        return (TrucoPlayer)playersList.get(numberOfPlayer);
    }
    /*retorna la cantidad de jugadores que tiene el Equipo*/
    /** Retorna la cantidad de jugadores que tiene el Equipo.
     * @return el valor de su numero de integrantes.
     */    
    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }
    /*puntos del Equipo*/
    /** Retorna el puntaje del Equipo.
     * @return El valor de su puntaje.
     */    
   
    public boolean isPlayerEquipo(TrucoPlayer pl){
    	for (int i=0; i<playersList.size(); i++){
    		if ((TrucoPlayer)(playersList.get(i))==pl)
    			return true;
    	}
    	return false;
    }
    /** Retorna el Nombre del Equipo.
     * @return String que identifica al Equipo.
     */    
    public String getName(){
    	return name;
    }
    /** Configura el nombre del Equipo.
     * @param newname String a ser asignado como nombre identificador del Equipo.
     */    
    public void setName(String newname){
        name = newname;
    }
    /** Configura el Puntaje del Equipo.
     * @param pts puntaje a ser asignado al Equipo.
     */    
    
    public ArrayList getPlayers() {
    	return playersList;
    }
}
