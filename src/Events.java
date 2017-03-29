import javax.swing.*;
import java.awt.event.*;
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
		}
		
		void resetFields(){
			
			for(int x =0; x<6;x++){
				gui.numbers[x].setText("");
				gui.winners[x].setText("");
			}
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}