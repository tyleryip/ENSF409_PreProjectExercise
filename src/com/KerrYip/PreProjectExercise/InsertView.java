package com.KerrYip.PreProjectExercise;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * This class is for the GUI when the user presses the 
 * @author Tyler Yip
 *
 */
@SuppressWarnings("serial")
public class InsertView extends JPanel{
	
	BinSearchTree classTree;

	//Two buttons for insert and return to main window
	private JButton b1, b2;
	
	//Four labels for student ID, faculty, major, and year
	private JLabel titleLabel, studentIDLabel, facultyLabel, majorLabel, yearLabel;
	
	//Four editable text boxes for student ID, faculty, major, and year
	private JTextArea studentIDText, facultyText, majorText, yearText;
	
	//Constructor for the InsertView JFrame
	public InsertView(int width, int height, BinSearchTree classTree) {
		this.setSize(width, height);
		this.classTree = classTree;
		
		//Button labels and initialization
		b1 = new JButton("Insert");
		b2 = new JButton("Return to Main Window");
		
		//Button functionality
		b1.addActionListener((ActionEvent e) -> {
			if(studentIDText.getText() != null && facultyText.getText() != null && majorText.getText() != null && yearText.getText() != null) {
				classTree.insert(studentIDText.getText(), facultyText.getText(), majorText.getText(), yearText.getText());
				System.out.println("Insert completed");
			}
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
		
		//Set up the JTextAreas for inputting data
		studentIDText = new JTextArea();
		studentIDText.setLineWrap(true);
		
		facultyText = new JTextArea();
		facultyText.setLineWrap(true);	
		
		majorText = new JTextArea();
		majorText.setLineWrap(true);
		
		yearText = new JTextArea();
		yearText.setLineWrap(true);
		
		//Set up the panels to hold the components in certain areas of the frame
		JPanel titlePanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		
		titlePanel.add(titleLabel);
		
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		
		inputPanel.setLayout(new FlowLayout());
		
		inputPanel.add(studentIDLabel);
		inputPanel.add(studentIDText);
		inputPanel.add(facultyLabel);
		inputPanel.add(facultyText);
		
		inputPanel.add(majorLabel);
		inputPanel.add(majorText);
		inputPanel.add(yearLabel);
		inputPanel.add(yearText);
		
		
		setLayout(new BorderLayout());
		add("North", titlePanel);
		add("Center", inputPanel);
		add("South", buttonPanel);
		
		setVisible(true);
	}
	
	public static void main(String [] args) {
		//InsertView test = new InsertView(600, 600);
	}
	
}
