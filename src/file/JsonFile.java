package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import utils.Printer;

// I swear to god your going to see a version of this in every thing i make with json becuse this was a pain in my ass
public class JsonFile {
    String dirc;
    File file;

    /**
     * Inlizes a Json File object
     * 
     * @param dirc the absolute path of a the file
     */
    public JsonFile(String dirc) {
        this.dirc = dirc;
        file = new File(dirc);
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
     * Inlizes a Json File object
     * 
     * Overloads JsonFile
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
    public ArrayList<String> toArraylist() {
        ArrayList<String> x = new ArrayList<String>();
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                x.add(reader.nextLine());
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
     * Truns a String Array in to a string with new line Charcters
     * 
     * @param x The String[] that will be turned into a string 
     * @return The final string
     */
    public static String arrayToString (String[] x) {
        String y = "";
        for (int i = 0; i < x.length; i++){
            y+= x[i] + "\n";
        }
        return y;
    }

    /**
     * Gets an int value form the json file
     * 
     * @param key The name of the value
     * @return The value
     */
    public int getInt (String key) {
        for (int i = 0; i < toArraylist().size(); i++) {
            String x = toArraylist().get(i);
            if (x.contains(key)) {
                x = x.substring(x.lastIndexOf(":") + 1);
                x = (x.substring(x.length() - 1, x.length()).equals(",")) ? x.substring(0, x.length() - 1)  : x;
                x = x.trim();
                return Integer.parseInt(x);
            }   
        }
        Printer.errorMessage();
        Printer.errorMessage("Varible not found");
        return -1111111111;
    }

     /**
     * Gets an double value form the json file
     * 
     * @param key The name of the value
     * @return The value
     */
    public double getDouble (String key) {
        for (int i = 0; i < toArraylist().size(); i++) {
            String x = toArraylist().get(i);
            if (x.contains(key)) {
                x = x.substring(x.lastIndexOf(":") + 1);
                x = (x.substring(x.length() - 1, x.length()).equals(",")) ? x.substring(0, x.length() - 1)  : x;
                x = x.trim();
                return Double.parseDouble(x);
            }   
        }
        Printer.errorMessage();
        Printer.errorMessage("Varible not found");
        return -1111111111;
    }

    /**
     * Gets an boolen value form the json file
     * 
     * @param key The name of the value
     * @return The value
     */
    public boolean getBoolen (String key) {
        for (int i = 0; i < toArraylist().size(); i++) {
            String x = toArraylist().get(i);
            if (x.contains(key)) {
                x = x.substring(x.lastIndexOf(":") + 1);
                x = (x.substring(x.length() - 1, x.length()).equals(",")) ? x.substring(0, x.length() - 1)  : x;
                x = x.trim();
                return Boolean.parseBoolean(x);
            }   
        }
        Printer.errorMessage();
        Printer.errorMessage("Varible not found");
        return false;
    }

    /**
     * Gets an string value form the json file
     * 
     * @param key The name of the value
     * @return The value
     */
    public String getString (String key) {
        for (int i = 0; i < toArraylist().size(); i++) {
            String x = toArraylist().get(i);
            if (x.contains(key)) {
                x = x.substring(x.lastIndexOf(":") + 1);
                x = x.trim();
                x = (x.substring(x.length() - 1, x.length()).equals(",")) ? x.substring(1, x.length() - 2)  : x.substring(1, x.length() - 1);
                
                return x;
            }   
        }
        Printer.errorMessage();
        Printer.errorMessage("Varible not found");
        return null;
    }
}