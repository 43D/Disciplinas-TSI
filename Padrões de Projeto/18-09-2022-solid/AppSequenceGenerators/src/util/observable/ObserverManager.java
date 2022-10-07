package util.observable;

public interface ObserverManager<TState>{
	public void addObserver(Observer<TState> observer);
	public void removeObserver(Observer<TState> observer);
	public void removeAllObservers();
	public void notifyObservers(TState newState);
}
