package com.KerrYip.PreProjectExercise;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * This code represents the main view of the Application
 * 
 * @author tyleryip
 * @author kerrmwill
 *
 */
@SuppressWarnings("serial")
public class MainView extends JFrame {
	
	private BinSearchTree classTree;
	private JButton insertButton, findButton, browseButton, createButton;
	private JLabel titleLabel;
	private JTextArea dataText;

	public MainView(String s, int width, int height) {
		super(s);
		this.setSize(width, height);

		//Sets up a blank binary search tree to store the data
		classTree = new BinSearchTree();

		//Buttons for the main window
		insertButton = new JButton("Insert");
		findButton = new JButton("Find");
		browseButton = new JButton("Browse");
		createButton = new JButton("Create Tree From File");

		//Button functionality for insert button
		insertButton.addActionListener((ActionEvent e) -> {
			JPanel insertPanel = new JPanel();
			insertPanel.setLayout(new BoxLayout(insertPanel, BoxLayout.PAGE_AXIS));
			JPanel titlePanel = new JPanel();
			titlePanel.add(new JLabel("Insert a new Node"));
			insertPanel.add(titlePanel);

			JPanel inputPanel1 = new JPanel();
			inputPanel1.add(new JLabel("Enter the Student ID"));
			JTextField studentIDTextField = new JTextField(5);
			inputPanel1.add(studentIDTextField);
			inputPanel1.add(new JLabel("Enter Faculty"));
			JTextField facultyTextField = new JTextField(10);
			inputPanel1.add(facultyTextField);
			insertPanel.add(inputPanel1);

			JPanel inputPanel2 = new JPanel();
			inputPanel2.add(new JLabel("Enter Student's Major"));
			JTextField majorTextField = new JTextField(15);
			inputPanel2.add(majorTextField);
			inputPanel2.add("South", new JLabel("Enter year"));
			JTextField yearTextField = new JTextField(5);
			inputPanel2.add("South", yearTextField);
			insertPanel.add(inputPanel2);

			//This array stores the button options for out JOptionPane
			Object[] options = { "Insert", "Return to Main Window" };

			int result = JOptionPane.showOptionDialog(null, insertPanel, "Insert a new Node",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);

			//The functionality of the Insert button
			if (result == JOptionPane.OK_OPTION) {
				if(studentIDTextField.getText() != null && facultyTextField.getText() != null && majorTextField.getText() != null && yearTextField.getText() != null)
				classTree.insert(studentIDTextField.getText(), facultyTextField.getText(), majorTextField.getText(),
						yearTextField.getText());
			}
		});

		//Button functionality for the find button
		findButton.addActionListener((ActionEvent e) -> {
			String studentID = JOptionPane.showInputDialog("Please enter the student's id");
			Node result = classTree.find(classTree.root, studentID);
			if (result == null) {
				JOptionPane.showMessageDialog(null, "Target record was not found");
			} else {
				JOptionPane.showMessageDialog(null, result.toString());
			}
		});

		//Button functionality for the browse button
		browseButton.addActionListener((ActionEvent e) -> {
			if (classTree.root != null) {
				dataText.setText(classTree.toString());
			}
		});

		//Button functionality for the create button
		createButton.addActionListener((ActionEvent e) -> {
			String filename = JOptionPane.showInputDialog("Enter the file name:");
			if (filename != null) {
				try {
					FileManager fm = new FileManager();
					classTree.insertList(fm.readFromFile(filename));
				} catch (FileNotFoundException ex) {
					JOptionPane.showMessageDialog(null, "File not found.");
				}
			}
		});

		//This is the title label
		titleLabel = new JLabel();
		titleLabel.setText("An Application to Maintain Student Records");

		//This is the data field that displays 
		dataText = new JTextArea(height / 25, width / 15);
		dataText.setLineWrap(true); // Allows text to wrap if it reaches the end of the line
		dataText.setWrapStyleWord(true); // text should wrap at word boundaries rather than character boundaries
		dataText.setEditable(false);  // This ensure that the user cannot edit the data field
		dataText.setText(""); // This displays empty text in the field

		//Make the data field scroll-able if enough data fills the panel
		JScrollPane dataTextScrollPane = new JScrollPane(dataText);
		dataTextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		// The following code sets up the panels and layout
		JPanel buttonPanel = new JPanel();
		JPanel titlePanel = new JPanel();
		JPanel dataPanel = new JPanel();

		//Set up the layout of the main window
		setLayout(new BorderLayout());

		//Add all the buttons into the button sub panel
		buttonPanel.add(insertButton);
		buttonPanel.add(findButton);
		buttonPanel.add(browseButton);
		buttonPanel.add(createButton);

		//Add the title to the sub panel
		titlePanel.add(titleLabel);
		dataPanel.add(dataTextScrollPane);

		//Add the sub panels to the frame
		add("North", titlePanel);
		add("Center", dataPanel);
		add("South", buttonPanel);

		//Set the border of the scroll-able data field so that it extends to fill the container
		dataTextScrollPane.setBorder(dataPanel.getBorder());

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
