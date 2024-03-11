import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import utils.ANSI;
import utils.DiceRoller;

public class CharSheet { 
    //#region Golbal Vars
    private static final DiceRoller DiceRoller = new DiceRoller();
    private static final Scanner in = new Scanner(System.in);
    
    static int level = 1;

    static int str = 0;
    static int dex = 0;
    static int con = 0;
    static int inl = 0;
    static int wis = 0;
    static int cha = 0;
 
    static int strModifer = 0;
    static int dexModifer = 0;
    static int conModifer = 0;
    static int inlModifer = 0;
    static int wisModifer = 0;
    static int chaModifer = 0;
 
    static String charName;
 
    static String Class;
    static String subClass;
 
    static boolean inspration = false;
    static int proficiancy = 0;
 
    static int AC;
    static int initiative;
    static int speed;
 
    static String hitDice;
    static int numOfHitDice;
 
    static ArrayList<String> atksNames = new ArrayList<String>();
    static ArrayList<Attack> Attacks = new ArrayList<Attack>();
    static HashMap<String, Attack> atks = new HashMap<String, Attack>();
    //#endregion
    //#region Sheet Functions
    CharSheet(){

    }

    private static void creatCharSheet () {
        charName = askString("What is your charcters name: ");
        
        Class = askChoices("Pick a Class", DnDConstants.classes);

        str = askInt("what is charters str: ");
        dex = askInt("what is charters dex: ");
        con = askInt("what is charters con: ");
        inl = askInt("what is charters int: ");
        wis = askInt("what is charters wis: ");
        cha = askInt("what is charters cha: ");

        updateSkillModifers();

        System.out.println("Your str modifer is: " + strModifer);
        System.out.println("Your dex modifer is: " + dexModifer);
        System.out.println("Your con modifer is: " + conModifer);
        System.out.println("Your inl modifer is: " + inlModifer);
        System.out.println("Your wis modifer is: " + wisModifer);
        System.out.println("Your cha modifer is: " + chaModifer);
    }
    //#endregion
    //#region Print Function
    private static String askChoices(String queston, String[] choices) {
        System.out.println(queston);
        for(int i = 0; i < choices.length; i++) {
            System.out.print(i + 1 + ": " + choices[i] + ", ");
        }

        System.out.println("");

        try {
            return choices[Integer.parseInt(in.next()) - 1];
        } catch (Exception e) {
            System.out.println(ANSI.RED + ANSI.HIGH_INTENSITY + "ERROR: Ivaild Choice" + ANSI.SANE);
            return askChoices(queston, choices);
        }
    }

    private static int askInt(String queston) {
        System.out.print(queston);
        try {
            return Integer.parseInt(in.next()); 
        } catch (Exception e) {
            System.out.println(ANSI.RED + ANSI.HIGH_INTENSITY + "ERROR: Ivaild Input" + ANSI.SANE);
            return askInt(queston);
        }
    }

    private static String askString(String queston) {
        System.out.print(queston);
        try {
            return in.next();
        } catch (Exception e) {
            System.out.println(ANSI.RED + ANSI.HIGH_INTENSITY + "ERROR: Ivaild Input" + ANSI.SANE);
            return askString(queston);
        }
    }
    //#endregion
    //#region Atk Functions
    public void addAtk() {
        String name = askString("Attack name: ");
        String atkDice = askChoices("Pick Attack String Type", DnDConstants.dice);
        int numOfAtkDice = askInt("Number of Dice: ");
        int atkBonus = askInt("Attack Bonus: ");
        String damgeType = askChoices("Pick Damge Type", DnDConstants.damgeTypes);
        
        atksNames.add(name);
        Attacks.add(new Attack(name, atkDice, numOfAtkDice, damgeType, atkBonus));
        atks.put(name,new Attack(name, atkDice, numOfAtkDice, damgeType, atkBonus));
    }

    public void addAtk(String name,String atkDice,int numOfAtkDice,int atkBonus, String damgeType) {
        atksNames.add(name);
        Attacks.add(new Attack(name, atkDice, numOfAtkDice, damgeType, atkBonus));
        atks.put(name,new Attack(name, atkDice, numOfAtkDice, damgeType, atkBonus));
    }
    //#endregion
    //#region Skill Functions

    public int strRoll() {
        return DiceRoller.D20() + strModifer;
    }

    public int dexRoll() {
        return DiceRoller.D20() + dexModifer;
    }

    public int conRoll() {
        return DiceRoller.D20() + conModifer;
    }

    public int intRoll() {
        return DiceRoller.D20() + inlModifer;
    }

    public int wisRoll() {
        return DiceRoller.D20() + wisModifer;
    }

    public int chaRoll() {
        return DiceRoller.D20() + chaModifer;
    }

    private static int getSkillModifer (int skill) {
        return (skill - 10)/2;
    }

    private static void updateSkillModifers () {
        strModifer = getSkillModifer(str);
        dexModifer = getSkillModifer(dex);
        conModifer = getSkillModifer(con);
        inlModifer = getSkillModifer(inl);
        wisModifer = getSkillModifer(wis);
        chaModifer = getSkillModifer(cha);
    }
    //#endregion
}
