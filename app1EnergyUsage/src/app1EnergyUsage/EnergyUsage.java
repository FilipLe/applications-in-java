package app1EnergyUsage;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class EnergyUsage {
	private JFrame frmDailyEnergyUsage;
	//Declare the placeholder for age, weight, height
	private JTextField inputAge;
	private JTextField inputWeight;
	private JTextField inputHeight;
	
	//Declare the input texts as global variables so can be accessed within different methods
	public int userAge;
	public int userHeight;
	public int userWeight;
	
	//declare the BMR as a global variable
	public double BMR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnergyUsage window = new EnergyUsage();
					window.frmDailyEnergyUsage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EnergyUsage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDailyEnergyUsage = new JFrame();
		frmDailyEnergyUsage.setTitle("Energy Usage Calculator");
		frmDailyEnergyUsage.setBounds(100, 100, 734, 404);
		frmDailyEnergyUsage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDailyEnergyUsage.getContentPane().setLayout(null);
		
		//Tick button for choosing 'Male'
		JRadioButton maleRadioButton = new JRadioButton("Male");
		maleRadioButton.setBounds(93, 22, 141, 23);
		frmDailyEnergyUsage.getContentPane().add(maleRadioButton);
		
		//Tick button for choosing 'Female'
		JRadioButton femaleRadioButton = new JRadioButton("Female");
		femaleRadioButton.setBounds(93, 48, 141, 23);
		frmDailyEnergyUsage.getContentPane().add(femaleRadioButton);
		
		
		//Indicates to Java that the 2 buttons cannot be selected at the same time 
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(maleRadioButton);
		buttonGroup.add(femaleRadioButton);
		
		//Label 'Gender'
		JLabel lblNewLabel = new JLabel("Gender");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(6, 26, 75, 42);
		frmDailyEnergyUsage.getContentPane().add(lblNewLabel);
		
		//Create slider
		JSlider slider = new JSlider();
		slider.setBounds(86, 261, 581, 29);
		frmDailyEnergyUsage.getContentPane().add(slider);
		
		//Label 'Exercise'
		JLabel lblExercise = new JLabel("Exercise");
		lblExercise.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExercise.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblExercise.setBounds(6, 261, 75, 29);
		frmDailyEnergyUsage.getContentPane().add(lblExercise);
		
		JLabel lblNewLabel_1 = new JLabel("Sedentary");
		lblNewLabel_1.setBounds(96, 291, 61, 16);
		frmDailyEnergyUsage.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Slightly Active");
		lblNewLabel_1_1.setBounds(206, 291, 98, 16);
		frmDailyEnergyUsage.getContentPane().add(lblNewLabel_1_1);
		
		JLabel answerLabel = new JLabel("Answer will appear here");
		answerLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		answerLabel.setBounds(122, 339, 164, 29);
		frmDailyEnergyUsage.getContentPane().add(answerLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Moderately Active");
		lblNewLabel_1_1_1.setBounds(346, 291, 127, 16);
		frmDailyEnergyUsage.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Very Active");
		lblNewLabel_1_1_2.setBounds(572, 291, 98, 16);
		frmDailyEnergyUsage.getContentPane().add(lblNewLabel_1_1_2);
		
		
		/*
		 * Placeholders for user input: Age, Weight, Height
		 */
		JLabel ageText = new JLabel("Age");
		ageText.setHorizontalAlignment(SwingConstants.RIGHT);
		ageText.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		ageText.setBounds(6, 93, 54, 42);
		frmDailyEnergyUsage.getContentPane().add(ageText);
		
		JLabel weightText = new JLabel("Weight (kg)");
		weightText.setHorizontalAlignment(SwingConstants.RIGHT);
		weightText.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		weightText.setBounds(6, 140, 88, 42);
		frmDailyEnergyUsage.getContentPane().add(weightText);
		
		JLabel heightText = new JLabel("Height (cm)");
		heightText.setHorizontalAlignment(SwingConstants.RIGHT);
		heightText.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		heightText.setBounds(6, 196, 88, 42);
		frmDailyEnergyUsage.getContentPane().add(heightText);
		
		inputAge = new JTextField();
		inputAge.setText("Ages(in years) goes here");
		inputAge.setBounds(104, 102, 310, 26);
		frmDailyEnergyUsage.getContentPane().add(inputAge);
		inputAge.setColumns(10);
		inputAge.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				if(inputAge.getText().trim().equals("Ages(in years) goes here")) {
					inputAge.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(inputAge.getText().trim().equals("")) {
					//If user did not type anything, when user clicks on different label, text appears again
					inputAge.setText("Ages(in years) goes here"); 
				}
			}
		});
		
		inputWeight = new JTextField();	
		inputWeight.setText("Weight(in kg) goes here");
		inputWeight.setColumns(10);
		inputWeight.setBounds(104, 149, 310, 26);
		frmDailyEnergyUsage.getContentPane().add(inputWeight);
		inputWeight.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				if(inputWeight.getText().trim().equals("Weight(in kg) goes here")) {
					inputWeight.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				//If user did not type anything, when user clicks on different label, text appears again
				if(inputWeight.getText().trim().equals("")) {
					inputWeight.setText("Weight(in kg) goes here"); 
				}
			}
		});
		
		inputHeight = new JTextField();
		inputHeight.setText("Height(in cm) goes here");
		inputHeight.setColumns(10);
		inputHeight.setBounds(104, 205, 310, 26);
		frmDailyEnergyUsage.getContentPane().add(inputHeight);
		inputHeight.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				//When user clicks on the placeholder, the text shown below disappears
				if(inputHeight.getText().trim().equals("Height(in cm) goes here")) {
					inputHeight.setText(""); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				//If user did not type anything, when user clicks on different label, text appears again
				if(inputHeight.getText().trim().equals("")) {
					inputHeight.setText("Height(in cm) goes here"); 
				}
			}
		});
		
		/*
		 * End of Placeholders for user input: Age, Weight, Height
		 */
		
		
		/*
		 * Calculation function
		 */
		JButton calculateButton = new JButton("Calculate!");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Getting the user input from the placeholder
				String age = inputAge.getText();
				String weight = inputWeight.getText();
				String height = inputHeight.getText();
				//If placeholder are empty, ask for user to input something in
				if(age==null||weight==null||height==null) 
				{
					answerLabel.setText("Please input age, weight, and height.");
				}
				else 
				{
					//Since placeholder input are texts, convert them to integers
					userAge = Integer.parseInt(age);
					userWeight = Integer.parseInt(weight);
					userHeight = Integer.parseInt(height);
				}
				if(maleRadioButton.isSelected()) 
				{
					//Calculating Male's BMR
					BMR = 10*userWeight + 6.25*userHeight - 5*userAge + 5;
					answerLabel.setText(BMR + " calories");
				}
				else if(femaleRadioButton.isSelected()) 
				{
					//Calculating Female's BMR
					BMR = 10*userWeight + 6.25*userHeight - 5*userAge - 161;
					answerLabel.setText(BMR + " calories");
				}
				else {
					answerLabel.setText("Please choose male or female");
				}
			}
		});
		calculateButton.setBounds(6, 341, 117, 29);
		frmDailyEnergyUsage.getContentPane().add(calculateButton);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("Active");
		lblNewLabel_1_1_2_1.setBounds(498, 291, 98, 16);
		frmDailyEnergyUsage.getContentPane().add(lblNewLabel_1_1_2_1);

	}
}
