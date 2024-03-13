package dnd;

public class Attack {
    public String name;
    public String atkDice;
    public int numOfAtkDice;
    public String damgeType;
    public int atkBonus;
    
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
}
