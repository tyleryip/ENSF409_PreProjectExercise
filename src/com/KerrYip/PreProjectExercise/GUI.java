package com.KerrYip.PreProjectExercise;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame{

	private JButton b1, b2, b3, b4;
	
	public GUI(String s) {
		super(s);
		
		setLayout(new BorderLayout());
		b1 = new JButton("Insert");
		b2 = new JButton("Find");
		b3 = new JButton("Browse");
		b4 = new JButton("Create Tree From File");
		
		this.add("South", b1);
		this.add("South", b2);
		this.add("South", b3);
		this.add("South", b4);
		
		
		setVisible(true);
	}
	
}
