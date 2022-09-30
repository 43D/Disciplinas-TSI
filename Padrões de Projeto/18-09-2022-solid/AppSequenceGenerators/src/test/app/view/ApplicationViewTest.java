package test.app.view;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import app.view.ApplicationView;

public class ApplicationViewTest {

	public static void main(String[] args) {
		List<Entry<String, String>> optionslist = new ArrayList<>();
		optionslist.add(new AbstractMap.SimpleEntry<>("ZERO", "Gerador 1"));
		optionslist.add(new AbstractMap.SimpleEntry<>("UM", "Gerador 2"));
		optionslist.add(new AbstractMap.SimpleEntry<>("DOIS", "Gerador 3"));
		optionslist.add(new AbstractMap.SimpleEntry<>("TRES", "Gerador 4"));
		optionslist.add(new AbstractMap.SimpleEntry<>("QUATRO", "Gerador 5"));

		ApplicationView appView = ApplicationView.create(optionslist);
		appView.setControl((sequenceId, max) -> System.out.println("controlMock invocado"));
		appView.setVisible(true);

	}

}
