package app.view.components.scrollableOptionList;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class ScrollableOptionListBuilder {
	private List<Entry<String,String>> optionList = null;
	private ActionListener actionListener = null;
	
	public ScrollableOptionListBuilder() {};

	public ScrollableOptionListBuilder optionList(List<Entry<String,String>> list) {
		optionList = list;
		return this;
	}
	
	public ScrollableOptionListBuilder actionListener(ActionListener listener) {
		actionListener = listener;
		return this;
	}
	
	public JScrollPane build() {
		JPanel panel = new JPanel(new GridLayout(optionList.size(), 1));
		ButtonGroup group = new ButtonGroup();
		
		for(Entry<String,String> entry: optionList) {
			JRadioButton radioButton = new JRadioButton(entry.getValue());
			radioButton.setActionCommand(entry.getKey());
			radioButton.addActionListener(actionListener);
			
			group.add(radioButton);
			panel.add(radioButton);
		}
		
		if(group.getElements().hasMoreElements())
			group.getElements().nextElement().setSelected(true);
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		return scrollPane;
	}
}
