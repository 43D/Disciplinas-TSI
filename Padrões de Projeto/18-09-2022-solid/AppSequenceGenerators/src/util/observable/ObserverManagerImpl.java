package util.observable;

import java.util.ArrayList;
import java.util.List;

public class ObserverManagerImpl<TState> implements ObserverManager<TState> {

	private List<Observer<TState>> observerList = new ArrayList<>();
	private Observable<TState> observable;

	public ObserverManagerImpl(Observable<TState> observable) {
		this.observable=observable;
	}

	@Override
	public void addObserver(Observer<TState> observer) {
		observerList.add(observer);
	}

	@Override
	public void removeObserver(Observer<TState> observer) {
		observerList.remove(observer);
	}

	@Override
	public void removeAllObservers() {
		observerList.clear();
	}

	@Override
	public void notifyObservers(TState newState) {
		for(Observer<TState> observer: observerList) 
			observer.stateChanged(observable, newState);
	}
}
