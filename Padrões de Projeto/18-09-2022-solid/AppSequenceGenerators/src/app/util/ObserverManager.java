package app.util;

public interface ObserverManager<Tstate> {
	public void addObserver(Observer<Tstate> observer);
	public void removeObserver(Observer<Tstate> observer);
	public void removeAllObserver();
	public void notifyObserver(Tstate state);
}
