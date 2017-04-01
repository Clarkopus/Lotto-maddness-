import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;


public class ErrorBox extends JFrame{
	
	JPanel pane = new JPanel();
	JPanel pane2 = new JPanel();
	JLabel errorMessage = new JLabel("Error dectected!");
	JLabel errorLabel = new JLabel("Error code:");
	JTextField errorText = new JTextField();

	
	public ErrorBox(){
		
		super("Error!");
		setLookAndFeel();
		setSize(400,300);
		setDefaultCloseOperation(ErrorBox.DISPOSE_ON_CLOSE);
		GridLayout layout = new GridLayout(2,1,10,10);
		FlowLayout layout2 = new FlowLayout(FlowLayout.CENTER,10,10);
		FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER,10,10);
		setLayout(layout);
		
		
		
		pane.add(errorMessage);
		pane2.add(errorLabel);
		pane2.add(errorText);
	
		add(pane);
		add(pane2);
		
		pane.setLayout(layout2);
		pane.setLayout(layout3);
		
		setVisible(false);
	}
	
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NiumbusLookAndFeel");
		}
		catch(Exception exc){
			//Ignore execption when error happens
		}
	}
}