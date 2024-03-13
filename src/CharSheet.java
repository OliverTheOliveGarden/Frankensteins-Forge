import java.util.HashMap;

import utils.DiceRoller;
import utils.Printer;

import dnd.Attack;
import dnd.DnDConstants;

public class CharSheet { 
    //#region Golbal Vars
    private  final DiceRoller DiceRoller = new DiceRoller();

    int level = 1;
    
    int str = 0;
    int dex = 0;
    int con = 0;
    int inl = 0;
    int wis = 0;
    int cha = 0;

    int strModifer = 0;
    int dexModifer = 0;
    int conModifer = 0;
    int inlModifer = 0;
    int wisModifer = 0;
    int chaModifer = 0;

    String charName;

    String Class;
    String subClass;
 
    boolean inspration = false;
    int proficiancy = 0;
 
    int AC = 10;
    int initiative;
    int speed = 30;

    String hitDice = DnDConstants.dice[3];
    int numOfHitDice = 1;
 
    HashMap<String, Attack> atks = new HashMap<String, Attack>();

    //#endregion
    //#region Sheet Functions

    /**
     * @see CharSheet.creatCharSheet
     */
    CharSheet(){
       creatCharSheet();
    }

    /**
     * Creates a D&D Charcter Sheet
     */
    private void creatCharSheet () {
        charName = Printer.askString("What is your charcters name: ");
        
        Class = Printer.askChoices("Pick a Class", DnDConstants.classes);
        subClass = Printer.askChoices("Pick a SubClass", DnDConstants.getSubClassDic().get(Class));

        str = Printer.askInt("what is charters str: ");
        dex = Printer.askInt("what is charters dex: ");
        con = Printer.askInt("what is charters con: ");
        inl = Printer.askInt("what is charters int: ");
        wis = Printer.askInt("what is charters wis: ");
        cha = Printer.askInt("what is charters cha: ");

        updateSkillModifers();

        initiative = dexModifer;

        System.out.println("Your str modifer is: " + strModifer);
        System.out.println("Your dex modifer is: " + dexModifer);
        System.out.println("Your con modifer is: " + conModifer);
        System.out.println("Your inl modifer is: " + inlModifer);
        System.out.println("Your wis modifer is: " + wisModifer);
        System.out.println("Your cha modifer is: " + chaModifer);
    }
    //#endregion
    //#region Atk Functions

    /**
     * Adds a new Attack to the attks Hashmap and uses 
     */
    public void addAtk() {
        String name = Printer.askString("Attack name: ");
        String atkDice = Printer.askChoices("Pick Attack String Type", DnDConstants.dice);
        int numOfAtkDice = Printer.askInt("Number of Dice: ");
        int atkBonus = Printer.askInt("Attack Bonus: ");
        String damgeType = Printer.askChoices("Pick Damge Type", DnDConstants.damgeTypes);
        
        atks.put(name,new Attack(name, atkDice, numOfAtkDice, damgeType, atkBonus));
    }

    /**
     * Adds a new Attack to the attks HashMap
     * 
     * Overloads Charsheet.addatk
     * 
     * @param name The Attack's name
     * @param atkDice The Attack's Dice Type
     * @param numOfAtkDice The Number of the Attack's Dice
     * @param atkBonus The Attack's Bonus Damge
     * @param damgeType The Attack's Damge Type
     */
    public void addAtk(String name,String atkDice,int numOfAtkDice,int atkBonus, String damgeType) {
        atks.put(name,new Attack(name, atkDice, numOfAtkDice, damgeType, atkBonus));
    }
    //#endregion
    //#region Skill Functions

    /**
     * Rolls a d20 and adds strModifer
     * 
     * @return the Rolls + strModifer Results
     */
    public int strRoll() {
        return DiceRoller.D20() + strModifer;
    }

    /**
     * Rolls a d20 and adds dexModifer
     * 
     * @return the Rolls + dexModifer Results
     */
    public int dexRoll() {
        return DiceRoller.D20() + dexModifer;
    }

    /**
     * Rolls a d20 and adds conModifer
     * 
     * @return the Rolls + conModifer Results
     */
    public int conRoll() {
        return DiceRoller.D20() + conModifer;
    }

    /**
     * Rolls a d20 and adds inlModifer
     * 
     * @return the Rolls + inlModifer Results
     */
    public int intRoll() {
        return DiceRoller.D20() + inlModifer;
    }

    /**
     * Rolls a d20 and adds wisModifer
     * 
     * @return the Rolls + wisModifer Results
     */
    public int wisRoll() {
        return DiceRoller.D20() + wisModifer;
    }

    /**
     * Rolls a d20 and adds chaModifer
     * 
     * @return the Rolls + chaModifer Results
     */
    public int chaRoll() {
        return DiceRoller.D20() + chaModifer;
    }

    /**
     * Updates all Skill Modifers
     */
    private void updateSkillModifers () {
        strModifer = (str - 10)/2;
        dexModifer = (dex - 10)/2;
        conModifer = (con - 10)/2;
        inlModifer = (inl - 10)/2;
        wisModifer = (wis - 10)/2;
        chaModifer = (cha - 10)/2;
    }
    //#endregion
}
