package test.app.view.components.scrolableOptionList;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JScrollPane;


import app.view.components.scrollableOptionList.ScrollableOptionListBuilder;

public class ScrollableOptionListBuilderTest {
	
	public static void main(String[] args) {
		List<Entry<String,String>> optionslist = new ArrayList<>();
		optionslist.add(new AbstractMap.SimpleEntry<>("ZERO", "Gerador de zeros"));
		optionslist.add(new AbstractMap.SimpleEntry<>("UM", "Gerador de uns"));
		optionslist.add(new AbstractMap.SimpleEntry<>("DOIS", "Gerador de dois"));
		optionslist.add(new AbstractMap.SimpleEntry<>("TRES", "Gerador de tres"));
		optionslist.add(new AbstractMap.SimpleEntry<>("QUATRO", "Gerador de quatros"));
		
		ScrollableOptionListBuilder builder = new ScrollableOptionListBuilder();
		JScrollPane scrollableOptionList = builder
				.optionList(optionslist)
				.actionListener((actionEvent)->System.out.println(actionEvent.getActionCommand()))
				.build();
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(scrollableOptionList);
		frame.pack();
		frame.setVisible(true);
	}

}
