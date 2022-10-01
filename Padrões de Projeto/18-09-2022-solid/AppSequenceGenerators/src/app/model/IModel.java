package app.model;

import app.util.Observable;

public interface IModel extends Observable<ModelState>{
	public ModelState getState();
	public void setState(final ModelState state);
}
