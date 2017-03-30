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
		}
		
		/* Function to check the results of the draw */
		void checkResults(){
			
			/* TODO
			 * - check results of each JTextField 
			 * - Loop through winners[] and numbers[]
			 * - check if either number equals to that field */
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}