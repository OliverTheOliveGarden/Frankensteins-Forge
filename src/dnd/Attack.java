package dnd;

import file.JsonFile;
import file.savingConstants;

public class Attack {
    String name;
    String atkDice;
    int numOfAtkDice;
    String damgeType;
    int atkBonus;
    
    /** 
     * Instilzes all varibles
     * 
     * @param name The Attack's name
     * @param atkDice The Attack's Dice Type
     * @param numOfAtkDice The Number of the Attack's Dice
     * @param atkBonus The Attack's Bonus Damge
     * @param damgeType The Attack's Damge Type
     */
    public Attack(String name,String atkDice,int numOfAtkDice,String damgeType,int atkBonus) {
        this.name = name;
        this.atkDice = atkDice;
        this.numOfAtkDice = numOfAtkDice;
        this.damgeType = damgeType;
        this.atkBonus = atkBonus;
        creatJson();
    }

    /**
     * Upadates all of the objects varibles
     * 
     * @param name The Attack's name
     * @param atkDice The Attack's Dice Type
     * @param numOfAtkDice The Number of the Attack's Dice
     * @param atkBonus The Attack's Bonus Damge
     * @param damgeType The Attack's Damge Type
     */
    public void UpdateVars(String name,String atkDice,int numOfAtkDice,String damgeType,int atkBonus) {
        this.name = name;
        this.atkDice = atkDice;
        this.numOfAtkDice = numOfAtkDice;
        this.damgeType = damgeType;
        this.atkBonus = atkBonus;
    }

    @Override
    /**
     * Overrides Java's toString method
     * 
     * @return The attack in D&D notaion 
     */
    public String toString() {
        if (atkBonus == 0) {
            return "Name: " + name + ", Damage: " + numOfAtkDice + atkDice + ", Damge Type: " + damgeType;
        } else if (atkBonus > 0) {
            return "Name: " + name + ", Damage: " + numOfAtkDice + atkDice + "+" + atkBonus + ", Damge Type: " + damgeType;
        } else {
            return "Name: " + name + ", Damage: " + numOfAtkDice + atkDice + atkBonus + ", Damge Type: " + damgeType;
        } 
    }

    /**
     * Creats a json file for the attack
     * 
     * @return the file's path
     */
    public String creatJson () {
        JsonFile file = new JsonFile(savingConstants.atksSavePath, name);
        file.put("name", name);
        file.put("atkDice", atkDice);
        file.put("numOfAtkDice", numOfAtkDice);
        file.put("damgeType", damgeType);
        file.put("atkBonus", atkBonus);
        return file.getPath();
    }

    /**
     * Gets an Attack object form a json file
     * 
     * @param path the path to the json file
     * @return the new Attack created form the json
     */
    public static Attack getAttackFormJson(String path) {
        JsonFile file = new JsonFile(path);
        String name = file.getString("name");
        String atkDice = file.getString("atkDice");
        int numOfAtkDice = file.getInt("numOfAtkDice");
        String damgeType = file.getString("damgeType");
        int atkBonus = file.getInt("atkBonus");
        return new Attack(name, atkDice, numOfAtkDice, damgeType, atkBonus);
    }
}
