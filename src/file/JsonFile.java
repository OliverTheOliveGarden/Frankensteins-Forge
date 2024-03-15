package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import utils.Printer;

public class JsonFile {
    String dirc;
    File file;

    public JsonFile(String dirc, String fileName) {
        this.dirc = dirc + "\\" + fileName + ".json";
        file = new File(this.dirc);
        try {
            if (file.exists()) {
                return;
            } 
            if (file.createNewFile()) {
                creatJsonFile();
            } else {
                Printer.errorMessage();
            } 
            
        } catch (IOException e) {
            Printer.errorMessage();
            e.printStackTrace();
        }
    }

    /**
     * Sets up a new file for jsoning
     */
    void creatJsonFile () {
        try {
            FileWriter writer = new FileWriter(dirc);
            writer.write("{\n\n}");
            writer.close();
            if (file.length() > 0) {
                Printer.sucssesMessage();
            } else {
                Printer.errorMessage();
            }
        } catch (IOException e) {
            Printer.errorMessage();
            Printer.errorMessage("IOExecpetion");
            e.printStackTrace();
        }
    }

    /**
     * @return the file's contents in sting form
    */
    public String toString () {
        try {
            Scanner reader = new Scanner(file);
            String x = "";
        
            while (reader.hasNextLine()) {
                x+= reader.nextLine() + "\n";
            }
            reader.close();
            return x;
        } catch (FileNotFoundException e) {
            Printer.errorMessage();
            Printer.errorMessage("File not found");
            e.printStackTrace();
            return null;
        }
        
    }
}