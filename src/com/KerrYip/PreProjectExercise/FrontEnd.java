package com.KerrYip.PreProjectExercise;

public class FrontEnd {

	
	public static void main(String [] args) {
		FileManager fm = new FileManager();
		String[] classList = fm.readFromScanner();
		int i = 0;
		while(i < classList.length){
			System.out.println(classList[i]);
			i++;
		}
	}
	
	
}
