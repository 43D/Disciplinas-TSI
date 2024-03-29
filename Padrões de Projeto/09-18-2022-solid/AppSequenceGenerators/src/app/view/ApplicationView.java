package app.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import app.control.IControl;
import app.model.IModel;
import app.view.components.scrollableOptionList.ScrollableOptionListBuilder;
import app.view.components.validatedTextField.ValidatedTextField;
import app.view.components.validators.IntegerRangeValidator;

public class ApplicationView {
	private JFrame frame = null;
	private JTextArea sequenceTextArea = null;
	private ValidatedTextField sequenceLimitTextField = null;
	private JTextField sequenceSizeTextField = null;
	private JLabel sequenceNameLabel = null;
	private JButton generateSequenceButton = null;
	String sequenceName = null;

	private ApplicationView() {
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	public void setSequence(List<Integer> sequence) {
		sequenceTextArea.setText("");

		for (Integer value : sequence)
			sequenceTextArea.append(String.format("%d, ", value));

		sequenceTextArea.append(" ...");
	}

	public void setControl(IControl control) {
		generateSequenceButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				int max = 0;
				try {
					max = Integer.parseInt(sequenceLimitTextField.getText());
					control.generateSequence(sequenceName, max);
				} catch (NumberFormatException nfe) {
					final String msg = "Erro" + nfe.getMessage();
					final String title = "ERRO AO DETERMINAR MAX SEQUENCIA";
					JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	public void setModel(IModel model) {
		if(model == null)
			throw new IllegalArgumentException("Parâmentro 'model' não pode ser nulo");
		
		model.getObserverManager().addObserver((observable, state) ->{
				sequenceNameLabel.setText(state.sequenceName);
				setSequence(state.sequence);
		});
	}
	

	static JScrollPane createSequenceOptionList(ApplicationView appView,
			List<Map.Entry<String, String>> sequenceOptionsList) {
		if (sequenceOptionsList == null)
			throw new NullPointerException("Parâmento 'sequenceOptionsList' não pode ser nulo");

		ScrollableOptionListBuilder builder = new ScrollableOptionListBuilder().optionList(sequenceOptionsList)
				.actionListener((actionEvent) -> appView.sequenceName = actionEvent.getActionCommand());

		return builder.build();
	}

	static public ApplicationView create(List<Entry<String, String>> optionslist) {
		final ApplicationView appView = new ApplicationView();

		appView.sequenceTextArea = createSequenceTextArea();
		appView.sequenceLimitTextField = createSequenceLimitField();
		appView.sequenceNameLabel = createSequenceNameLabel();
		appView.sequenceSizeTextField = createSequenceSizeTextField();
		appView.generateSequenceButton = new JButton("Gerar a sequ�ncia");

		appView.frame = createFrame(appView);

		JScrollPane pane = createSequenceOptionList(appView, optionslist);
		appView.frame.getContentPane().add(pane, BorderLayout.WEST);

		return appView;
	}

	static JTextArea createSequenceTextArea() {
		JTextArea textArea = new JTextArea();
		textArea.enableInputMethods(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Arial", Font.PLAIN, 20));

		return textArea;
	}

	static ValidatedTextField createSequenceLimitField() {
		ValidatedTextField textField = new ValidatedTextField();
		textField.setValidator(new IntegerRangeValidator(1, 1_000_000));

		return textField;
	}

	static JLabel createSequenceNameLabel() {
		JLabel label = new JLabel();
		Font font = new Font("Serif", Font.BOLD + Font.ITALIC, 15);
		label.setFont(font);

		return label;
	}

	static JTextField createSequenceSizeTextField() {
		JTextField textField = new JTextField();
		textField.setEditable(false);

		return textField;
	}

	static JFrame createFrame(final ApplicationView appView) {
		JFrame frame = new JFrame("Gerador de Sequ�ncias Num�ricas");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 600));
		frame.getContentPane().setLayout(new BorderLayout());

		JScrollPane scrollPane = createVerticalScrollPaneFor(appView.sequenceTextArea);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

		frame.getContentPane().add(createSouthPanel(appView), BorderLayout.SOUTH);

		frame.pack();

		return frame;
	}

	static JScrollPane createVerticalScrollPaneFor(JTextArea textArea) {
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		return scrollPane;
	}

	static JPanel createSouthPanel(final ApplicationView appView) {
		JPanel bagPane = new JPanel(new GridBagLayout());
		// GridBagConstraints(int gridx, int gridy, int gridwidth, int gridheight,
		// double weightx, double weighty, int anchor, int fill,
		// Insets insets, int ipadx, int ipady)
		GridBagConstraints gbc;
		JPanel pane;

		JLabel label = new JLabel("Gerar sequ�ncia at�: ? (<1.000.000)");
		pane = createPanelFor(label, appView.sequenceLimitTextField);
		gbc = new GridBagConstraints(0, 0, 1, 1, 0.4, 1, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
				new Insets(2, 2, 2, 2), 2, 2);
		bagPane.add(pane, gbc);

		pane = createPanelFor(appView.sequenceNameLabel, appView.sequenceSizeTextField);
		gbc = new GridBagConstraints(1, 0, 1, 1, 0.4, 1, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
				new Insets(2, 2, 2, 2), 2, 2);
		bagPane.add(pane, gbc);

		gbc = new GridBagConstraints(2, 0, 1, 1, 0.2, 1, GridBagConstraints.LINE_START, GridBagConstraints.BOTH,
				new Insets(2, 2, 2, 2), 2, 2);
		bagPane.add(appView.generateSequenceButton);

		return bagPane;
	}

	static JPanel createPanelFor(JLabel label, JTextField textField) {
		label.setLabelFor(textField);

		JPanel pane = new JPanel(new GridLayout(2, 1, 2, 2));
		pane.add(label);
		pane.add(textField);

		return pane;
	}
}
