package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Printer;

public class JsonFile {
    String dirc;
    File file;

    /**
     * Inlizes a Json File object
     * 
     * @param dirc Directory (The Folder)
     * @param fileName The file's name without file exstenion
     */
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
            Printer.errorMessage("IOException");
            e.printStackTrace();
        }
    }

    /**
     * Sets up a new file for jsoning
     */
    void creatJsonFile () {
        try {
            FileWriter writer = new FileWriter(dirc);
            writer.write("{\n\"Tehehhe\": 1\n}");
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
    @Override
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
    /**
     * Coverts the Json file into an String Array
     * 
     * @return String[]
     */
    public String[] toArray() {
        ArrayList<String> x = new ArrayList<String>();
        String[] y;
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                x.add(reader.nextLine());
            }
            reader.close();
            y = new String[x.size()];
            for (int i = 0; i < x.size(); i++) {
                y[i] = x.get(i);
            }
            return y;
        } catch (FileNotFoundException e) {
            Printer.errorMessage();
            Printer.errorMessage("File not found");
            e.printStackTrace();
            return null;
        }
    }
}