package com.KerrYip.PreProjectExercise;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	
	public MainView(String s) {
		super(s);
		this.setSize(600, 600);
	
		b1 = new JButton("Insert");
		b2 = new JButton("Find");
		b3 = new JButton("Browse");
		b4 = new JButton("Create Tree From File");
		
		b1.addActionListener((ActionEvent e) -> {
			System.out.println("Insert");
		});
		
		b2.addActionListener((ActionEvent e) -> {
			System.out.println("Find");
		});
		
		b3.addActionListener((ActionEvent e) -> {
			dataText.setText(classTree.toString());
		});
		b4.addActionListener((ActionEvent e) -> {
			String filename = JOptionPane.showInputDialog("Enter the file name:");
			FileManager fm = new FileManager();
			classTree = new BinSearchTree(fm.readFromFile(filename));

			/*below is test
			PrintWriter pw = new PrintWriter(System.out);
			try {
				classTree.print_tree(classTree.root, pw);
			}catch(IOException eegriuui){
				eegriuui.printStackTrace();
			}
			*/
		});
		
		titleLabel = new JLabel();
		titleLabel.setText("An Application to Maintain Student Records");
		
		dataText = new JTextArea();
		dataText.setLineWrap(true); //Allows text to wrap if it reaches the end of the line
		dataText.setWrapStyleWord(true); //text should wrap at word boundaries rather than character boundaries
		dataText.setEditable(false);
		dataText.setSize(500,400);
		dataText.setText("This is where we will import the data from the input text to display the students and their majors & faculty");
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
