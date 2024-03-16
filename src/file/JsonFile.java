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
    String path;
    File file;

    /**
     * Inlizes a Json File object
     * 
     * @param path the absolute path of a the file
     */
    public JsonFile(String path) {
        this.path = path;
        file = new File(path);
        try {
            if (file.exists()) {
                return;
            } 
            if (file.createNewFile()) {
                write("{\n}");
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
     * @param path Directory (The Folder)
     * @param fileName The file's name without file exstenion
     */
    public JsonFile(String path, String fileName) {
        this.path = path + "\\" + fileName + ".json";
        file = new File(this.path);
        try {
            if (file.exists()) {
                return;
            } 
            if (file.createNewFile()) {
                write("{\n}");
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
     * Re writes the file
     * 
     * @param x the data that gets writen
     */
    void write (String x) {
        try {
            FileWriter writer = new FileWriter(path);
            writer.write(x);
            writer.close();
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
     * Coverts the Json file into an String ArrayList
     * 
     * @return Arraylist<String>
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
    public static String arrayListToString (ArrayList<String> x) {
        String y = "";
        for (int i = 0; i < x.size(); i++){
            y+= x.get(i) + "\n";
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

    /**
     * Removes a value form the json file
     * 
     * @param key
     */
    public void deleteValue (String key) {
        ArrayList<String> y = toArraylist();
        for (int i = 0; i < toArraylist().size(); i++) {
            String x = toArraylist().get(i);
            if (x.contains(key)) {
                y.remove(i);
                write(arrayListToString(y));
                return;
            }   
        }
        Printer.errorMessage();
        Printer.errorMessage("Value not found");
    }

    /**
     * Adds a string value to the json file
     * 
     * @param key the value's name
     * @param value the value
     */
    public void put (String key, String value) {
        ArrayList<String> y = toArraylist();
        if (y.size() == 2) {
            y.add(y.size() - 1, "   \"" + key + "\": " + "\"" + value + "\"");
        } else if (y.size() > 2) {
            y.set(y.size() - 2, y.get(y.size() - 2) + ",");
            y.add(y.size() - 1, "   \"" + key + "\": " + "\"" + value + "\"");
        }
        write(arrayListToString(y));
    }

    /**
     * Adds a int value to the json file
     * 
     * @param key the value's name
     * @param value the value
     */
    public void put (String key, int value) {
        ArrayList<String> y = toArraylist(); 
        if (y.size() == 2) {
            y.add(y.size() - 1, "   \"" + key + "\": " + value);
        } else if (y.size() > 2) {
            y.set(y.size() - 2, y.get(y.size() - 2) + ",");
            y.add(y.size() - 1, "   \"" + key + "\": " + value);
        }
        write(arrayListToString(y));
    }

    /**
     * Adds a boolen value to the json file
     * 
     * @param key the value's name
     * @param value the value
     */
    public void put (String key, boolean value) {
        ArrayList<String> y = toArraylist();
        if (y.size() == 2) {
            y.add(y.size() - 1, "   \"" + key + "\": " + value);
        } else if (y.size() > 2) {
            y.set(y.size() - 2, y.get(y.size() - 2) + ",");
            y.add(y.size() - 1, "   \"" + key + "\": " + value);
        }
        write(arrayListToString(y));
    }

    /**
     * Adds a double value to the json file
     * 
     * @param key the value's name
     * @param value the value
     */
    public void put (String key, double value) {
        ArrayList<String> y = toArraylist();
        if (y.size() == 2) {
            y.add(y.size() - 1, "   \"" + key + "\": " + value);
        } else if (y.size() > 2) {
            y.set(y.size() - 2, y.get(y.size() - 2) + ",");
            y.add(y.size() - 1, "   \"" + key + "\": " + value);
        }
        write(arrayListToString(y));
    }

    /**
     * Canges a value in the json file
     * 
     * @param key The name of the value
     * @param value The new value
     */
    public void change (String key, double value) {
        ArrayList<String> y = toArraylist();
        if (y.size() == 3) {
            y.set(1, "  \"" + key + "\": " + value);
        } else if (y.size() > 3) {
            for (int i = 0; i < y.size(); i++) {
                String x = y.get(i);
                if (x.contains(key)) {
                    x = (y.get(i + 1).trim().equals("}")) ? "" : ",";  
                    y.set(i, "  \"" + key + "\": " + value + x);
                }   
            }
        }
        write(arrayListToString(y));
    }

    /**
     * Canges a value in the json file
     * 
     * @param key The name of the value
     * @param value The new value
     */
    public void change (String key, int value) {
        ArrayList<String> y = toArraylist();
        if (y.size() == 3) {
            y.set(1, "  \"" + key + "\": " + value);
        } else if (y.size() > 3) {
            for (int i = 0; i < y.size(); i++) {
                String x = y.get(i);
                if (x.contains(key)) {
                    x = (y.get(i + 1).trim().equals("}")) ? "" : ",";  
                    y.set(i, "  \"" + key + "\": " + value + x);
                }   
            }
        }
        write(arrayListToString(y));
    }

    /**
     * Canges a value in the json file
     * 
     * @param key The name of the value
     * @param value The new value
     */
    public void change (String key, boolean value) {
        ArrayList<String> y = toArraylist();
        if (y.size() == 3) {
            y.set(1, "  \"" + key + "\": " + value);
        } else if (y.size() > 3) {
            for (int i = 0; i < y.size(); i++) {
                String x = y.get(i);
                if (x.contains(key)) {
                    x = (y.get(i + 1).trim().equals("}")) ? "" : ",";  
                    y.set(i, "  \"" + key + "\": " + value + x);
                }   
            }
        }
        write(arrayListToString(y));
    }

    /**
     * Canges a value in the json file
     * 
     * @param key The name of the value
     * @param value The new value
     */
    public void change (String key, String value) {
        ArrayList<String> y = toArraylist();
        if (y.size() == 3) {
            y.set(1, "  \"" + key + "\": \"" + value + "\"");
        } else if (y.size() > 3) {
            for (int i = 0; i < y.size(); i++) {
                String x = y.get(i);
                if (x.contains(key)) {
                    x = (y.get(i + 1).trim().equals("}")) ? "" : ",";  
                    y.set(i, "  \"" + key + "\": \"" + value + "\"" + x);
                }   
            }
        }
        write(arrayListToString(y));
    }   

    /**
     * @return the path varible
     */
    public String getPath () {
        return path;
    }
}