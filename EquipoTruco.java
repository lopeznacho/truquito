/*
 * EquipoTruco.java
 *
 * Created on 5 de marzo de 2003, 02:58 PM
 */

package py.edu.uca.fcyt.toluca.game;


/** Clase que representa a un equipo de Truco.
 * @author Julio Rey
 */
public class EquipoTruco extends Equipo{
    
    public static final int ROJO = 0;
    public static final int AZUL = 1;
    
    /** Constructor de instancia de EquipoTruco.
     * @param name String que representa el nombre identificador del EquipoTruco.
     */
    public EquipoTruco(String name) {
        super(name);
    }
    /** Constructor de Instancia del EquipoTruco.
     */    
    public EquipoTruco(){
    }
    /** Retorna el numero del JugadorTruco.
     * @return int que representa el numero de ese equipo.
     * @param pl JugadorTruco de quien se devolverá su numero.
     */    
    public int getNumberOfPlayer(JugadorTruco pl){
        for (int i=0; i<playersList.size(); i++){
    		if ((JugadorTruco)(playersList.get(i))==pl)
    			return i;
    	}
    	return -1;
    }
    /** Retorna el Player de numero i.
     * @param numberOfPlayer numero de JugadorTruco a ser retornado.
     * @return JugadorTruco que es el integrante numero i del EquipoTruco.
     */    
    public JugadorTruco getJugadorTrucoNumber (int numberOfPlayer){
        return (JugadorTruco)super.getPlayerNumber(numberOfPlayer);
    }
    /** Verifica si es integrante del EquipoTruco.
     * @return <B>true</B> si es integrante, <B>false</B> si no es integrante.
     * @param tPl JugadorTruco a ser verificado si es integrante.
     */    
    public boolean isPlayerEquipoTruco(JugadorTruco tPl){
        return super.isPlayerTeam(tPl);
    }
    /** Adherir nuevo JugadorTruco al Equipo.
     * @param tPl JugadorTruco a ser adherido a la lista de JugadorTrucos del equipo.
     */    
    
    public void addPlayer (JugadorTruco tPl){
        super.addPlayer(tPl);   
    }
    public JugadorTruco getPlayer (String aname){
		for (int i=0; i<playersList.size(); i++){
			if (((JugadorTruco)(playersList.get(i))).getName()==aname)
				return (JugadorTruco)(playersList.get(i));
				
		}
		return null;
    }
    
}
