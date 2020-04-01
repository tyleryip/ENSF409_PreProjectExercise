package com.KerrYip.PreProjectExercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Helper class for the FrontEnd to read input from files
 *  @author tyleryip
 *  @author kerrmwill
 */
public class FileManager{

    /**
     * Reads class list from a text file and returns the classes in a String array
     * @param filename name of the file being read from for the class list
     * @return Returns the class list in a String array with each class being String being a class
     */
    public String[] readFromFile(String filename){
        String line = "";
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line += scanner.nextLine().trim() + " \0"; //adds each class to a single string separated by \0
            }
            scanner.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return line.split("\0"); //returns a string array separating at all the \0 added in the while loop above
    }

}
