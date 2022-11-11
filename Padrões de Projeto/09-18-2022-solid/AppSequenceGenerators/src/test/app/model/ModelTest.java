package test.app.model;

import java.util.Arrays;
import java.util.List;

import app.model.ApplicationModel;
import app.model.ModelState;

public class ModelTest {

	public static void main(String[] args) {
		String format = "\nErro: Expect %s actual %s";
		
		ApplicationModel model = new ApplicationModel();
		
		model.observerManager.addObserver((observable,state)->{
			if(ApplicationModel.class != observable.getClass())
				System.out.printf(format, ApplicationModel.class, observable.getClass());
			
			if(!"".equals(state.sequenceName))
				System.out.printf(format, "", state.sequenceName);
			
			if(state.sequence.size()>0)
				System.out.printf(format, "size=0", "size="+state.sequence.size());
		});
		
		String name = "Fibonacci";
		List<Integer> lst = Arrays.asList(1,1,2,3,5,8);
		
		model.observerManager.removeAllObservers();
		model.observerManager.addObserver((observable,state)->{
			if(!name.equals(state.sequenceName))
				System.out.printf(format, name, state.sequenceName);
			
			if(state.sequence.size()!=6)
				System.out.printf(format, "size=6", "size="+state.sequence.size());
			
			if(!lst.containsAll(state.sequence))
				System.out.printf(format, lst.toString(), state.sequence.toString());
		});
		
		model.setState(new ModelState(name, lst));
	}

}
