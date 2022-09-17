package test.app.view.components.validatedTextField;

import java.awt.Dimension;

import javax.swing.JFrame;

import app.view.components.validatedTextField.IValidator;
import app.view.components.validatedTextField.ValidatedTextField;
import app.view.components.validators.IntegerRangeValidator;

public class ValidatedTextFieldTest {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Testing ValidatedTextFieldTest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ValidatedTextField field = new ValidatedTextField();
		IValidator validator = new IntegerRangeValidator(-100,100);
		field.setValidator(validator);
		field.setPreferredSize(new Dimension(350,20));
		
		frame.getContentPane().add(field);
		frame.pack();
		frame.setLocation(200,200);
		frame.setVisible(true);
	}

}
