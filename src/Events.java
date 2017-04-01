/*Events.java
 * Created by Guy H Clark
 * Used to store the actions when an event happens for Lotto Madness! */
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
// Implement the action listener interface
public class Events implements ActionListener, 

	Runnable{
	// Create instance of the application main window
		SwingTesting gui;
		Thread playing;
		ErrorBox error = new ErrorBox();
		int drawCount = 0;
		int matches;
		int threeOfSix;
		int fourOfSix;
		int fiveOfSix;
		int sixOfSix;
		
		
		public Events(SwingTesting in){
			gui = in;
		}
		
		/* This function is used to react to button push events
		 * all interactions and outcomes for button presses go here */
		public void actionPerformed(ActionEvent event){
			
			// Get the action listener String
			String command = event.getActionCommand();
			//If it comes back as reset then run the reset fields function
			if(command.equals("reset")){
				
				resetFields();
			}
			//If it comes back as play run the play function
			else if(command.equals("play")){
				
				try {
					startLotto();
				} catch (emptyFieldException | IdenticalNumberFieldsException e) {
					// TODO Auto-generated catch block
					ErrorBox error = new ErrorBox();
					error.errorText.setText(e.toString());
					error.setVisible(true);
					
				}
			}
		}
		/* Function to reset all JTextField fields to a blank empty String */
		void resetFields(){
			
			for(int x =0; x<6;x++){
				gui.numbers[x].setText("");
				gui.winners[x].setText("");
			}
		}
		
		
		/* Improved version of startLotto
		 * Instead of checking if the last number was the same
		 * it checks all the fields to see if any are the same
		 * if it comes back as an identical value a new value
		 * is generated. 
		 * Also supports exception if the fields aren't filled
		 * in.*/
		void startLotto() throws IdenticalNumberFieldsException, emptyFieldException{
			
			Random rng = new Random();
			int min = 1;
			int max = 99;
			int i =0;
			String[] currentFields = new String[5];
			int[] currentDraws = new int[6];
			
			currentFields =checkFields(currentFields);
				
			for(int x=0; x<gui.winners.length;x++){
				
				int pick = rng.nextInt((max - min) + 1) + min;
				while(true){
					if(pick==currentDraws[i]){
						pick = rng.nextInt((max - min) +1) + min;
					}
					i++;
					if(i ==6){
						i=0;
						break;
					}
				}
				
				gui.winners[x].setText(Integer.toString(pick));
				checkResults();
			}
		}
		
		
		
		/* Function to check the results of the draw */
		void checkResults(){
			
			String[] winnerNumbers = new String[6];
			String[] personalNumbers = new String[6];
			
			
			for(int x=0; x < 6; x++){
				
				personalNumbers[x] = gui.numbers[x].getText();
				winnerNumbers[x] = gui.winners[x].getText();
			}
			int currentField =0;
			while(true){
				if (currentField ==6)break;
				for(int x=0;x<5;x++){
					
					if(personalNumbers[currentField].equals(winnerNumbers[x])){
						matches ++;
					}
				}
				currentField++;
				
			}
			
			if(matches == 3)threeOfSix++;
			else if (matches ==4)fourOfSix++;
			else if (matches ==5)fiveOfSix++;
			else if (matches ==6)sixOfSix++;
			gui.got3.setText(Integer.toString(threeOfSix));
			gui.got4.setText(Integer.toString(fourOfSix));
			gui.got5.setText(Integer.toString(fiveOfSix));
			gui.got6.setText(Integer.toString(sixOfSix));
			gui.matches.setText(Integer.toString(matches));
			matches = 0;
			
		}
		
	

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
		String[] checkFields(String[] currentFields) throws IdenticalNumberFieldsException, emptyFieldException {
			for(int x=0; x<6;x++){
				if(gui.numbers[x].getText().equals("")){
					throw new emptyFieldException("Empty field Dectected!!");	
				}
			}
			int i =0;
			for(int y=0; y<currentFields.length;y++){
				currentFields[y] = gui.numbers[y].getText();
			}
			for(int x=0; x<gui.winners.length;x++){
				while(true){
					if(currentFields[x].equals(currentFields[x])){
						throw new IdenticalNumberFieldsException("Identical number fields found!");
					}
					i++;
					if(i ==6){
						i=0;
						break;
					}
				}
			
		}
			return currentFields;
	}

class emptyFieldException extends Exception{
	
	emptyFieldException(String s){
		super(s);
	}
	
	
}

class IdenticalNumberFieldsException extends Exception{
	
	IdenticalNumberFieldsException(String s){
		super(s);
	}
}
}