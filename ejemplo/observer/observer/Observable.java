package ejemplo.observer.observer;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Observable {

	private ArrayList<Observer> observers = new ArrayList<Observer>();
	
	public void registrarObserver(Observer observer)
	{
		observers.add(observer);
	}
	
	public void eliminarObserver(Observer observer)
	{
		observers.remove(observer);
	}
	
	public void notificarObservers(String mensaje)
	{
		for(Iterator<Observer> i = observers.iterator();i.hasNext();)
			i.next().update(mensaje);	
	}
	public void notificarObserver(int i, String mensaje){
		observers.get(i).update(mensaje);
	}
}
