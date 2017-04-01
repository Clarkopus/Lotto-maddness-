

import java.awt.*;
import javax.swing.*;
public class SwingTesting extends JFrame {
	
	//Test to git
	
	Events lotto = new Events(this);
	
	//Setup row 1
	JPanel row1 = new JPanel();
	ButtonGroup option = new ButtonGroup();
	JLabel quickPickLabel = new JLabel("Quick pick", JLabel.RIGHT);
	JCheckBox quickPick = new JCheckBox();
	JLabel personalLabel = new JLabel("Personal",JLabel.RIGHT);
	JCheckBox personal = new JCheckBox();
	
	//setup row 2
	JPanel row2 = new JPanel();
	JLabel numbersLabel1 = new JLabel("Your picks: ",JLabel.RIGHT);
	JTextField[] numbers = new JTextField[6];
	JLabel winnerLabel1 = new JLabel("Winning numbers: ", JLabel.RIGHT);
	JTextField[] winners = new JTextField[6];
	
	//Setup row 3
	JPanel row3 = new JPanel();
	JButton stop = new JButton("stop");
	JButton play = new JButton("play");
	JButton reset = new JButton("reset");
	
	//Setup row 4
	JPanel row4 = new JPanel();
	JLabel got3Label = new JLabel("3 of 6", JLabel.RIGHT);
	JTextField got3 = new JTextField();
	JLabel got4Label = new JLabel("4 of 6", JLabel.RIGHT);
	JTextField got4 = new JTextField();
	JLabel got5Label = new JLabel("5 of 6", JLabel.RIGHT);
	JTextField got5 = new JTextField();
	JLabel got6Label = new JLabel("6 of 6", JLabel.RIGHT);
	JTextField got6 = new JTextField();
	JLabel drawingsLabel = new JLabel("Drawings",JLabel.RIGHT);
	JTextField drawings = new JTextField();
	JLabel yearsLabel = new JLabel("Years: ",JLabel.RIGHT);
	JTextField years = new JTextField();
	
	//Class constructor
	public SwingTesting(){
		//Generic init
		super("Lotto sim V0.4.2");
		setLookAndFeel();
		setSize(500,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout layout = new GridLayout(5,1,10,10);
		setLayout(layout);
		
		//init event listeners
		reset.addActionListener(lotto);
		play.addActionListener(lotto);
		
		//FlowLayout used for row 1
		FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER,10,10);
		//adding check boxes to the button group
		option.add(quickPick);
		option.add(personal);
		//Set the layout manager for the JPanel "row1"
		row1.setLayout(layout1);
		//Add the buttons to the JPanel
		row1.add(quickPick);
		row1.add(quickPickLabel);
		row1.add(personal);
		row1.add(personalLabel);
		//Add the JPanel
		add(row1);
		
		//Row 2 uses a grid layout to map each component
		GridLayout layout2 = new GridLayout(2,7,10,10); //2 columns, 7 rows
		row2.setLayout(layout2);
		row2.add(numbersLabel1);
		/* Since the numbers JTextFields are in an array we loop through that array and create a new JTextField object every itteration
		 * and then add that component to the JPanel */
		for(int x = 0; x<6;x++){
			numbers[x] = new JTextField();
			row2.add(numbers[x]);
		}
		row2.add(winnerLabel1);
		/* Winner JTextFields are created using the same method above*/
		for(int x = 0; x< 6; x++){
			winners[x] = new JTextField();
			row2.add(winners[x]);
		}
		add(row2);
		
		//Row 3 uses flow layout
		FlowLayout layout3 = new FlowLayout(FlowLayout.CENTER);
		row3.setLayout(layout3);
		//Set the stop button to be disabled by default
		stop.setEnabled(false);
		row3.add(play);
		row3.add(stop);
		row3.add(reset);
		add(row3);
		
		//Row 4 uses grid layout
		GridLayout layout4 = new GridLayout(2,3,20,10);
		row4.setLayout(layout4);
		row4.add(got3Label);
		row4.add(got3);
		got3.setEditable(false);
		row4.add(got4Label);
		row4.add(got4);
		got4.setEditable(false);
		row4.add(got5Label);
		row4.add(got5);
		got5.setEditable(false);
		row4.add(got6Label);
		row4.add(got6);
		got6.setEditable(false);
		row4.add(drawingsLabel);
		row4.add(drawings);
		drawings.setEditable(false);
		row4.add(yearsLabel);
		row4.add(years);
		years.setEditable(false);
		add(row4);
		
		//Need to set the frame to be visible
		setVisible(true);
		
	}
	
	private void setLookAndFeel(){
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NiumbusLookAndFeel");
		}
		catch(Exception exc){
			//Ignore execption when error happens
		}
	}
	
	public static void main(String[] arguments){
		
		SwingTesting frame = new SwingTesting();
	}
}
