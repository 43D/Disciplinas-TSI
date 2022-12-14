package test.app.view;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import app.model.IModel;
import app.model.ModelState;
import app.view.ApplicationView;
import util.observable.Observable;
import util.observable.Observer;
import util.observable.ObserverManager;

public class ApplicationViewTest {
	
		static class ModelMock implements IModel, Observable<ModelState>, ObserverManager<ModelState> {
		private ModelState modelState = new ModelState("", new ArrayList<>());

		@Override
		public void setState(ModelState state) {
			this.modelState = state;
			this.notifyObservers(state);
		}

		@Override
		public ModelState getState() {
			return modelState;
		}

		@Override
		public ObserverManager<ModelState> getObserverManager() {
			return this;
		}

		private List<Observer<ModelState>> observers = new ArrayList<>();

		@Override
		public void addObserver(Observer<ModelState> observer) {
			observers.add(observer);
		}

		@Override
		public void notifyObservers(ModelState newState) {
			for (Observer<ModelState> observer : observers)
				observer.stateChanged((Observable<ModelState>) this, newState);
		}

		@Override
		public void removeObserver(Observer<ModelState> observer) {
		}

		@Override
		public void removeAllObservers() {
		}
	}

	public static void main(String[] args) {
		
		
		List<Entry<String, String>> optionslist = new ArrayList<>();
		optionslist.add(new AbstractMap.SimpleEntry<>("ZERO", "Gerador 1"));
		optionslist.add(new AbstractMap.SimpleEntry<>("UM", "Gerador 2"));
		optionslist.add(new AbstractMap.SimpleEntry<>("DOIS", "Gerador 3"));
		optionslist.add(new AbstractMap.SimpleEntry<>("TRES", "Gerador 4"));
		optionslist.add(new AbstractMap.SimpleEntry<>("QUATRO", "Gerador 5"));

		ApplicationView appView = ApplicationView.create(optionslist);
		ModelMock modelMock = new ModelMock();
		appView.setModel(modelMock);
		appView.setControl((sequenceId, max) -> System.out.println("controlMock invocado"));
		appView.setVisible(true);

		modelMock.setState(new ModelState("Fibonacci", Arrays.asList(1, 1, 2, 3, 5, 8)));

	}

}
