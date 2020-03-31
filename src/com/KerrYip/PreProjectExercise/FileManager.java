package com.KerrYip.PreProjectExercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileManager{

    public String getFilename(){
        Scanner filenameScanner = new Scanner(System.in);
        System.out.println("Enter the input filename: ");
        String filename = filenameScanner.nextLine();
        return filename;
    }

    public String[] readFromScanner(String filename){
        String line = "";
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                line += scanner.nextLine().trim() + " ";
                line += "\0";
            }
            scanner.close();

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return line.split("\0");
    }

}
