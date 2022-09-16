package app.view.components.validatedTextField;

import java.awt.Color;

import javax.swing.JTextField;

public class ValidatedTextField extends JTextField{

	private final static long serialVersionUID = 1L;
	private IValidator validator;
	
	public ValidatedTextField() {
		super.addKeyListener(this.keyListener);
		super.setOpaque(true);
	}
	
	private void decorate() {
		if(isContentValid()) 
			super.setBackground(Color.WHITE);
		else
			super.setBackground(Color.YELLOW);
	}
	
	public void setValidator(IValidator validator) {
		this.validator = validator;
	}
	
	public boolean isContentValid() {
		if(validator == null)
			return true;
		
		return validator.isValid(super.getText());
	}
	
	@Override
	public void setText(String text) {
		super.setText(text);
		decorate();
	}
}
