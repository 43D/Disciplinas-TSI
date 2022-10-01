package test.app.view;

import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import app.model.IModel;
import app.model.ModelState;
import app.util.Observable;
import app.util.Observer;
import app.util.ObserverManager;
import app.view.ApplicationView;

public class ApplicationViewTest {

	static class ModelMock implements IModel, ObserverManager<ModelState>, Observable<ModelState>{
		private ModelState modelstate = new ModelState("", new ArrayList<>());
		private List<Observer<ModelState>> observers = new ArrayList<>();
		@Override
		public ObserverManager<ModelState> getObserverManager() {
			return this;
		}

		@Override
		public ModelState getState() {
			return modelstate;
		}

		@Override
		public void setState(ModelState state) {
			this.modelstate = state;
			this.notifyObserver(state);
			
		}

		@Override
		public void addObserver(Observer<ModelState> observer) {
			observers.add(observer);
			
		}

		@Override
		public void removeObserver(Observer<ModelState> observer) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeAllObserver() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void notifyObserver(ModelState state) {
			for(Observer<ModelState> observer: observers)
				observer.stateChange((Observable<ModelState>)this, state);
			
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
		
		modelMock.setState(new ModelState("Fibonacci", Arrays.asList(1,1,2,3,5,8)));

	}

}
