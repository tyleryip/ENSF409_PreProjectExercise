package com.KerrYip.PreProjectExercise;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
/**
 * This class is for the GUI when the user presses the 
 * @author Tyler Yip
 *
 */
@SuppressWarnings("serial")
public class InsertView extends JFrame{

	//Two buttons for insert and return to main window
	private JButton b1, b2;
	
	//Four labels for student ID, faculty, major, and year
	private JLabel titleLabel, studentIDLabel, facultyLabel, majorLabel, yearLabel;
	
	//Four editable text boxes for student ID, faculty, major, and year
	private JTextArea studentIDText, facultyText, majorText, yearText;
	
	//Constructor for the InsertView JFrame
	public InsertView(String s) {
		super(s);
		this.setSize(600, 600);
		
		//Button labels and initialization
		b1 = new JButton("Insert");
		b2 = new JButton("Return to Main Window");
		
		//Button functionality
		b1.addActionListener((ActionEvent e) -> {
			System.out.println("Insert");
		});
		
		b2.addActionListener((ActionEvent e) -> {
			System.out.println("Return to Main Window");
		});
		
		//Title label
		titleLabel = new JLabel();
		titleLabel.setText("Insert a New Node");
		
		//Initialize labels for the text areas
		studentIDLabel = new JLabel();
		studentIDLabel.setText("Enter the Student ID");
		
		facultyLabel = new JLabel();
		facultyLabel.setText("Enter Faculty");
		
		majorLabel = new JLabel();
		majorLabel.setText("Enter Student's Major");
		
		yearLabel = new JLabel();
		yearLabel.setText("Enter year");
		
		
		studentIDText = new JTextArea();
		studentIDText.setLineWrap(true);
		
		facultyText = new JTextArea();
		facultyText.setLineWrap(true);
		
		majorText = new JTextArea();
		majorText.setLineWrap(true);
		
		yearText = new JTextArea();
		yearText.setLineWrap(true);
		
		
	}
	
}
