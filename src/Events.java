import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
public class Events implements ActionListener, 

	Runnable{
		SwingTesting gui;
		Thread playing;
		
		public Events(SwingTesting in){
			gui = in;
		}
		
		public void actionPerformed(ActionEvent event){
			
			String command = event.getActionCommand();
			if(command.equals("reset")){
				
				resetFields();
			}
			
			else if(command.equals("play")){
				
				startLotto();
			}
		}
		
		void resetFields(){
			
			for(int x =0; x<6;x++){
				gui.numbers[x].setText("");
				gui.winners[x].setText("");
			}
		}
		
		void startLotto(){
			
			Random rng = new Random();
			int min = 1;
			int max = 99;
			int lastPick = 0;
			
			for(int x=0;x<gui.winners.length;x++){
				int pick = rng.nextInt((max - min) + 1)+ min;
				while(true){
					
					if(pick == lastPick){
						
						pick = rng.nextInt((max - min) + 1)+ min;
					}
					
					else break;
				}
				gui.winners[x].setText(Integer.toString(rng.nextInt((max - min) + 1)+ min));
				lastPick = pick;
				System.out.println(Integer.toString(pick));
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}