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
			//If it comes badk as play run the play function
			else if(command.equals("play")){
				
				startLotto();
			}
		}
		/* Function to reset all JTextField fields to a blank empty String */
		void resetFields(){
			
			for(int x =0; x<6;x++){
				gui.numbers[x].setText("");
				gui.winners[x].setText("");
			}
		}
		/* Function to start the initial lotto draw.
		 * Works by looping through each JTextField and giving that field a
		 * random number. If that number matches another field's value then
		 * it is assigned a new random value. */
		void startLotto(){
			
			Random rng = new Random();
			int min = 1;
			int max = 99;
			int lastPick = 0;
			for(int x=0;x<gui.winners.length;x++){
				int pick = rng.nextInt((max - min) + 1)+ min;
				while(true){
					if(pick == lastPick){pick = rng.nextInt((max - min) + 1)+ min;}
					else break;
				}
				gui.winners[x].setText(Integer.toString(rng.nextInt((max - min) + 1)+ min));
				lastPick = pick;
			}
			
			gui.drawings.setText(Integer.toString(drawCount ++));
			checkResults();
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
			gui.years.setText(Integer.toString(matches));
			matches = 0;
			
		}
		
	

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}