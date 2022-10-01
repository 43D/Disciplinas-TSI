package app.util;

@FunctionalInterface
public interface Observer<Tstate> {
	public void stateChange(Observable<Tstate> src, Tstate newState);
}
