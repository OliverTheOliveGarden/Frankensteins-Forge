package dnd;

import file.JsonFile;
import file.savingConstants;

public class Attack {
    String name;
    String atkDice;
    int numOfAtkDice;
    String damgeType;
    int atkBonus;
    
    JsonFile file = new JsonFile(savingConstants.atksSavePath, name);
    
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
        file.change("name", name);
        file.change("atkDice", atkDice);
        file.change("numOfAtkDice", numOfAtkDice);
        file.change("damgeType", damgeType);
        file.change("atkBonus", atkBonus);
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

    public void creatJson () {
        file.put("name", name);
        file.put("atkDice", atkDice);
        file.put("numOfAtkDice", numOfAtkDice);
        file.put("damgeType", damgeType);
        file.put("atkBonus", atkBonus);
    }
}
