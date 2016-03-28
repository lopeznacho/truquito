public class JugadaTruco
{
	
//    public CartaTruco getCardAux() {
//        return cardAux;
//    }
//    public void setCardAux(CartaTruco cardAux) {
//        this.cardAux = cardAux;
//    }
//    public int getTableIdAux() {
//        return tableIdAux;
//    }
//    public void setTableIdAux(int tableIdAux) {
//        this.tableIdAux = tableIdAux;
//    }
//    public int getTypeAux() {
//        return typeAux;
//    }
//    public void setTypeAux(int typeAux) {
//        this.typeAux = typeAux;
//    }
//    public String getUserAux() {
//        return userAux;
//    }
//    public void setUserAux(String userAux) {
//        this.userAux = userAux;
//    }
//    public int getValueAux() {
//        return valueAux;
//    }
//    public void setValueAux(int valueAux) {
//        this.valueAux = valueAux;
//    }
	//tipos de jugadas
	/** Juego de tipo cantar <I>"Envido"</I>.
	 */
	public static final byte ENVIDO=1;//ok
	/** Juego de tipo cantar <I>"Real Envido"</I>.
	 */
	public static final byte REAL_ENVIDO=2;//ok
	/** Juego de tipo cantar <I>"Falta Envido"</I>.
	 */
	public static final byte FALTA_ENVIDO=3;//ok
	
	
	/** Juego de tipo cantar <I>"Truco"</I>.
	 */
	public static final byte TRUCO=21;//ok
	/** Juego de tipo cantar <I>"Retruco"</I>.
	 */
	public static final byte RETRUCO=22;//ok
	/** Juego de Tipo cantar <I>"Vale Cuatro"</I>.
	 */
	public static final byte VALE_CUATRO=23;//OK
	
	/** Juego de tipo cantar <I>"Quiero"</I>.
	 */
	public static final byte QUIERO=31;//
	/** Juego de tipo cantar <I>"No Quiero"</I>.
	 */
	public static final byte NO_QUIERO=32;
	/** Juego de tipo cantar <I>"Me voy al Mazo"</I>.
	 */
	public static final byte ME_VOY_AL_MAZO=33;
	
	/** Juego de tipo cantar <I>"cuanto tengo de Envido"</I>.
	 */
	public static final byte CANTO_ENVIDO=61;
	/** Juego de tipo <I>"jugar una Carta"</I>.
	 */
	public static final byte JUGAR_CARTA=62; //cuando solo tira la carta
	/** Juego de tipo  <I>"Paso el canto de cuanto tengo de Envido"</I>.
	 */
	public static final byte PASO_ENVIDO = 63; //golpear la mesa en ronda de envido

	/** Juego de tipo <I>"Me Cierro"</I>.
	 */
	public static final byte CERRARSE = 66;
	
	/*no utilizadas...*/
	public static final byte SIN_MENSAJES=100;
	public static final byte INICIO_DE_JUEGO = 101;
	public static final byte INICIO_DE_MANO = 102;
	public static final byte FIN_DE_MANO = 103;
	public static final byte FIN_DE_JUEGO = 104;
	public static final byte CARTAS_REPARTIDAS = 105;
	/*para mensajes de confirmacion de espera del player*/
	public static final byte PLAYER_CONFIRMADO = 110;
	
	
	
	private int tableNumber;
	private byte type = 0;
	private int value = -1;
	private CartaTruco card = null;
	private JugadorTruco player = null;
	
	
	/** Contructor para cantos de cuanto hay de envido, etc.
	 * @param tp JugadorTruco a hacer la Jugada.
	 * @param type Tipo de Jugada en este caso si canto el valor del Envido.
	 * @param value Valor del Envido.
	 */
	public JugadaTruco()
	{
	}
	public JugadaTruco(JugadorTruco tp, byte type, int value )
	{
		
		
		this(tp,type);
		this.value = value;
	}
	public JugadaTruco(int tableNumber, JugadorTruco tp, byte type, int value )
	{
		this(tp,type);
		this.tableNumber = tableNumber;
		this.value = value;
	}
	
	/** Constructor de jugada de tipo cantar o acto(cerrarse)algo.
	 * @param tp Player que jugara.
	 * @param type Tipo de canto o acto a realizar.
	 */
	
	public JugadaTruco(JugadorTruco tp, byte type)
	{
		this.player = tp;
		this.type = type;
	}
	public JugadaTruco(int tableNumber, JugadorTruco tp, byte type)
	{
		this.tableNumber = tableNumber;
		this.player = tp;
		this.type = type;
	}
	
	/** Contructor para jugada de tirar carta.
	 * @param type Tipo de jugada a realizar.
	 * @param tp JugadorTruco a jugar.
	 * @param card carta a ser tirada.
	 */
	public JugadaTruco(JugadorTruco tp, byte type, CartaTruco card)
	{
		this(tp,type);
		this.card = card;
	}
	public JugadaTruco(int tableNumber, JugadorTruco tp, byte type, CartaTruco card)
	{
		this(tp,type);
		this.tableNumber = tableNumber;
		this.card = card;
	}
	public JugadaTruco(int tableNumber,JugadorTruco tp,byte type,CartaTruco card,int value)
	{
		this(tableNumber,tp,type,card);
		this.value=value;
	}
	/** Configura el Tipo de Jugada o Acto.
	 * @param type Valor de la Jugada.
	 */
	public void setType(byte type)
	{
		this.type = type;
	}
	/** Retorna el tipo de Jugada.
	 * @return Retorna el byte asignado al tipo de Jugada.
	 */
	public byte getType()
	{
		return type;
	}
	/** Configurar la carta a jugar.
	 * @param card carta a Jugar.
	 */
	public void setCard(CartaTruco card)
	{
		this.card = card;
	}
	public void setTableNumber(int tableNumber)
	{
		this.tableNumber=tableNumber;
	}
	public int getTableNumber()
	{
		return this.tableNumber;
	}
	/** Retorna la carta de la jugada.
	 * @return CartaTruco asignada a la jugada.
	 */
	public CartaTruco getCard()
	{
		return card;
	}
	/** Configurar el JugadorTruco de la jugada.
	 * @param tp JugadorTruco que realiza la jugada.
	 */
	public void setPlayer(JugadorTruco tp)
	{
		this.player = tp;
	}
	/** Retorna el JugadorTruco que realiza la Jugada.
	 * @return JugadorTruco que realiza la jugada.
	 */
	public JugadorTruco getPlayer()
	{
		return player;
	}
	/** Configura el valor de la Jugada, para jugadas de tipo Cantar valor de Envido o Flor.
	 * @param value valor del Envido o Flor a jugar.
	 */
	public void setValue(int value)
	{
		this.value = value;
	}
	/** Retorna el valor del Envido o Flor.
	 * @return valor del Envido o Flor.
	 */
	public int getValue()
	{
		return value;
	}
//	public Document toXml()
//	{
//		Element ROOT;
//		if (type == JugadaTruco.PLAYER_CONFIRMADO)
//			ROOT = new Element("TrucoGameInfo");
//		else
//			ROOT = new Element("JugadaTruco");
//			
//		Element TABLE=new Element("Table");
//		TABLE.setAttribute("id",String.valueOf(getTableNumber()));
//		ROOT.addContent(TABLE);
//		
//		Element TIPO =new Element("Type");
//		TIPO.setAttribute("id",String.valueOf(type));
//		ROOT.addContent(TIPO);
//		
//		Element PLAYER =new Element("Player");
//		PLAYER.setAttribute("name",getPlayer().getName());
//		ROOT.addContent(PLAYER);
//		
//		Element CARTA=new Element("Carta");
//		if(getCard()!=null)
//		{
//			CARTA.setAttribute("kind",String.valueOf(getCard().getKind()));
//			CARTA.setAttribute("value",String.valueOf(getCard().getValue()));
//			ROOT.addContent(CARTA);
//		}
//		else
//		{
//			CARTA.setAttribute("kind",String.valueOf("2"));
//			CARTA.setAttribute("value",String.valueOf("4"));
//			ROOT.addContent(CARTA);
//		}
//		Element VALUE=new Element("Value");
//		VALUE.setAttribute("val",String.valueOf(getValue()));
//		ROOT.addContent(VALUE);
//		
//		Document doc=new Document(ROOT);
//		return doc;
//	}
//	CartaTruco cardAux;
//	int typeAux;
//	
//	int tableIdAux;
//	String userAux;
//	
//	int valueAux;
//	public void xmlReadJugadaTruco(Object o)
//	{
//		String aux;
//		if (o instanceof Element)
//		{
//			Element element = (Element) o;
//			aux=element.getName();
//			if(aux.compareTo("Type")==0)
//			{
//				typeAux=Integer.parseInt(element.getAttributeValue("id"));
//			}
//			if(aux.compareTo("Table")==0)
//			{
//				//System.out.println("MESSAGE:"+element.getText());
//				tableIdAux=Integer.parseInt(element.getAttributeValue("id"));
//			}
//			
//			if(aux.compareTo("Player")==0)
//			{
//				//System.out.println("PLAYER:"+element.getText());
//				userAux=element.getAttributeValue("name");
//			}
//			if(aux.compareTo("Carta")==0)
//			{
//				String kind=element.getAttributeValue("kind");
//				String value=element.getAttributeValue("value");
//				cardAux=new CartaTruco(Integer.parseInt(kind),Integer.parseInt(value));
//			}
//			if(aux.compareTo("Value")==0)
//			{
//				
//				valueAux=Integer.parseInt(element.getAttributeValue("val"));
//			}
//			List children = element.getContent();
//			Iterator iterator = children.iterator();
//			while (iterator.hasNext())
//			{
//				Object child = iterator.next();
//				xmlReadJugadaTruco(child);
//			}
//			if(aux.compareTo("JugadaTruco")==0)
//			{
//				JugadaTruco tp=new JugadaTruco(tableIdAux,new JugadorTruco(userAux),(byte)typeAux,cardAux,valueAux);
//				
//				System.out.println("Tabla :"+ tp.getTableNumber());
//				System.out.println("Truco Player : "+tp.getPlayer().getName());
//				System.out.println("TYPE  : "+tp.getType());
//				System.out.println("LA CARTA   PALO = "+tp.getCard().getKind()+" El valor es "+tp.getCard().getValue());
//				System.out.println("El valor es " + getValue());
//			}
//		}
//	}
//	public static void main(String[] args)
//	{
//		System.out.println("Hola CIT");
//		
//		
//		JugadorTruco p=new JugadorTruco("Dani",10);
//		
//		
//		CartaTruco cars [] = new CartaTruco[3];
//		cars[0]=new CartaTruco(2,3);
//		cars[1]=new CartaTruco(2,4);
//		cars[2]=new CartaTruco(2,5);
//		/*
//	   TrucoEvent prueba=new TrucoEvent(5,10,p,TrucoEvent.JUGAR_CARTA,cars[0]);
//		 */
//		
//		//JugadaTruco prueba=new JugadaTruco(p,(byte)5,cars[1]);
//		JugadaTruco prueba=new JugadaTruco(15,p,(byte)10,cars[2],31);
//		Document doc = prueba.toXml();
//		
//		try
//		{
//			
//			XMLOutputter serializer = new XMLOutputter("  ", true);
//			
//			serializer.output(doc, System.out);
//			
//		}
//		catch (IOException e)
//		{
//			System.out.println(e);
//		}
//		List children = doc.getContent();
//		Iterator iterator = children.iterator();
//		Object child = iterator.next();
//		Element element = (Element) child;
//		String aux=element.getName();
//		prueba.xmlReadJugadaTruco(child);
//	}
	public TrucoEvent toTrucoEvent()
	{
		TrucoEvent ev = new TrucoEvent();
		ev.setPlayer(player);
		ev.setTableNumber(tableNumber);
		byte typeevent = 0;
		CartaTruco carta = null;
		switch (type)
		{
			case 1:
				typeevent = 1;
				break;
			case 2:
				typeevent = 2;
				break;
			case 3:
				typeevent = 3;
				break;
			case 11:
				typeevent = 11;
				break;
			case 12:
				typeevent = 12;
				break;
			case 13:
				typeevent = 13;
				break;
			case 14:
				typeevent = 14;
				break;
			case 21:
				typeevent = 21;
				break;
			case 22:
				typeevent = 22;
				break;
			case 31:
				typeevent = 31;
				break;
			case 32:
				typeevent = 32;
				break;
			case 33:
				typeevent = 33;
				break;
			case 62:
				typeevent = 61;
				carta = card;
				break;
			case 61:
				typeevent = 62;
				break;
			case 65:
				typeevent = 63;
				break;
			case 63:
				typeevent = 64;
				break;
			case 64:
				typeevent = 65;
				break;
			case 66:
				typeevent = 66;
				break;
			default :
				typeevent = -1;
				break;
		}
		ev.setTypeEvent(typeevent);
		if (typeevent == 61 && carta == null)
		{
			System.out.println("errror!!!!!!!!!!!!!1111caralho");
		}
		if (carta == null)
			System.out.println("errror!!!!!!!!!!!!!222222222puta caralho");
		ev.setCard(carta);
		ev.setValue(value);
		return ev;
		
	}
} // end JugadaTruco



