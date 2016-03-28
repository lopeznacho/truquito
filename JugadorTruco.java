// implementar metodos que faltan y constructores .... (marian)


public class JugadorTruco {

    private int id; //falta auto asignar id
    protected String apodo = ""; 
    private String pass = ""; 
    private String email = ""; 
    protected int Puntos = -1;
    private int partidas;//implementar metodo 
    protected int oldPuntos;//implementar metodo 
	
	/**
	 * retorna Puntos viejo
	 */
	public int getOldPuntos() {
		return oldPuntos;
	}

	public void setOldPuntos(int oldPuntos) {
		this.oldPuntos = oldPuntos;
	}

    public String getapodo() { return apodo; } // end getapodo        
    public void setapodo(String _apodo) {        
        apodo = _apodo;
    } // end setapodo        
   

    public String getPass() {        
        return pass;
    } // end getPass        

    public void setPass(String _pass) {        
        pass = _pass;
    } // end setPass        

    public String getEmail() {        
        return email;
    } // end getEmail        

    public void setEmail(String _email) {        
        email = _email;
    } // end setEmail        
    
    public int getPuntos() { return Puntos; }
    
    public void setPuntos(int Puntos) 
    { 
    	this.Puntos = Puntos;
    }
    /** Constructor de un JugadorTruco con su apodo identificador.
     * @param apodo String que se asignar� como apodo identificador del JugadorTruco.
     */
    /*public JugadorTruco(){
    }*/
    public JugadorTruco (String apodo) {
        this();
        this.apodo = apodo;
    }
    /** Constructor de un JugadorTruco.
     */    

    public JugadorTruco (String apodo, int Puntos) {
        this(apodo);
        setPuntos(Puntos);
    }
    public JugadorTruco()
    {
        }
    public String toString()
    {
    	return new String(getapodo()+ "("+getPuntos()+")");
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equalsO(Object obj) {
		boolean ret = false;		
		if(obj instanceof JugadorTruco)
		{
			String este = getapodo() + " - " + getPuntos();
			JugadorTruco tp = (JugadorTruco) obj;
			String elOtro = tp.getapodo() + " - " + tp.getPuntos();
			ret = este.equals(elOtro);
		} ret = super.equals(obj);
		
		return ret;
	}
}
