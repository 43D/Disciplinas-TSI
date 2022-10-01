package app.util;

public interface Observable<Tstate> {
	public ObserverManager<Tstate> getObserverManager();
	public Tstate getState();	
}
