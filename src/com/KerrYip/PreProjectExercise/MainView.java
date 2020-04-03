package com.KerrYip.PreProjectExercise;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

/**
 * This code represents the main view of the Application
 * @author tyleryip
 * @author kerrmwill
 *
 */
@SuppressWarnings("serial")
public class MainView extends JFrame{

	private BinSearchTree classTree;
	private JButton b1, b2, b3, b4;
	private JLabel titleLabel;
	private JTextArea dataText;

	public MainView(String s, int width, int height) {
		super(s);
		this.setSize(width, height);
		
		classTree = new BinSearchTree();
	
		b1 = new JButton("Insert");
		b2 = new JButton("Find");
		b3 = new JButton("Browse");
		b4 = new JButton("Create Tree From File");
		
		b1.addActionListener((ActionEvent e) -> {
			JPanel insertPanel = new JPanel();
			insertPanel.setLayout(new BoxLayout(insertPanel, BoxLayout.PAGE_AXIS));
			JPanel titlePanel = new JPanel();
			titlePanel.add(new JLabel("Insert a new Node"));
			insertPanel.add(titlePanel);

			JPanel inputPanel1 = new JPanel();
			inputPanel1.add(new JLabel("Enter the Student ID"));
			JTextField studentIDLabel = new JTextField(5);
			inputPanel1.add(studentIDLabel);
			inputPanel1.add(new JLabel("Enter Faculty"));
			JTextField facultyLabel = new JTextField(10);
			inputPanel1.add(facultyLabel);
			insertPanel.add(inputPanel1);

			JPanel inputPanel2 = new JPanel();
			inputPanel2.add(new JLabel("Enter Student's Major"));
			JTextField majorLabel = new JTextField(15);
			inputPanel2.add(majorLabel);
			inputPanel2.add("South",new JLabel("Enter year"));
			JTextField yearLabel = new JTextField(5);
			inputPanel2.add("South",yearLabel);
			insertPanel.add(inputPanel2);

			Object[] options = {"Insert", "Return to Main Window"};

			int result =  JOptionPane.showOptionDialog(null, insertPanel, "Insert a new Node",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

			if(result == JOptionPane.OK_OPTION){
				classTree.insert(studentIDLabel.getText(), facultyLabel.getText(), majorLabel.getText(), yearLabel.getText());
			}
		});
		
		b2.addActionListener((ActionEvent e) -> {
			String studentID = JOptionPane.showInputDialog("Please enter the student's id");
			Node result = classTree.find(classTree.root,studentID);
			if(result == null){
				JOptionPane.showMessageDialog(null,"Target record was not found");
			}else{
				JOptionPane.showMessageDialog(null,result.toString());
			}
		});
		
		b3.addActionListener((ActionEvent e) -> {
			if(!classTree.toString().contentEquals(null)) {
				dataText.setText(classTree.toString());
			}
		});
		
		b4.addActionListener((ActionEvent e) -> {
			String filename = JOptionPane.showInputDialog("Enter the file name:");
			FileManager fm = new FileManager();
			classTree = new BinSearchTree(fm.readFromFile(filename));
		});
		
		titleLabel = new JLabel();
		titleLabel.setText("An Application to Maintain Student Records");
		
		dataText = new JTextArea(height/25,width/15);
		dataText.setLineWrap(true); //Allows text to wrap if it reaches the end of the line
		dataText.setWrapStyleWord(true); //text should wrap at word boundaries rather than character boundaries
		dataText.setEditable(false);
		dataText.setText(""); //This displays empty text in the field
		dataText.setEditable(false);
		
		JScrollPane dataTextScrollPane = new JScrollPane(dataText);
		dataTextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//The following code sets up the panels and layout
		JPanel buttonPanel = new JPanel();
		JPanel titlePanel = new JPanel();
		JPanel dataPanel = new JPanel();

		setLayout(new BorderLayout());
		
		buttonPanel.add(b1);
		buttonPanel.add(b2);
		buttonPanel.add(b3);
		buttonPanel.add(b4);
		
		titlePanel.add(titleLabel);
		dataPanel.add(dataTextScrollPane);
		
		add("North", titlePanel);
		add("Center", dataPanel);
		add("South", buttonPanel);
		
		dataTextScrollPane.setBorder(dataPanel.getBorder());
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//pack();
		setVisible(true);
	}
	
}
