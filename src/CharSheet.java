import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import utils.ANSI;
import utils.DiceRoller;

import dnd.Attack;
import dnd.DnDConstants;

public class CharSheet { 
    //#region Golbal Vars
    private  final DiceRoller DiceRoller = new DiceRoller();
    private  final Scanner in = new Scanner(System.in);
    
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
 
     int AC;
     int initiative;
     int speed;
 
     String hitDice;
     int numOfHitDice;
 
     ArrayList<String> atksNames = new ArrayList<String>();
     ArrayList<Attack> Attacks = new ArrayList<Attack>();
     HashMap<String, Attack> atks = new HashMap<String, Attack>();
    //#endregion
    //#region Sheet Functions
    CharSheet(){
       
    }

    private void creatCharSheet () {
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
    private  String askChoices(String queston, String[] choices) {
        System.out.println(queston);
        for(int i = 0; i < choices.length - 1; i++) {
            System.out.print(i + 1 + ": " + choices[i] + ", ");
        }
        System.out.println(choices.length + ": " + choices[choices.length - 1]);

        System.out.println("");

        try {
            return choices[Integer.parseInt(in.next()) - 1];
        } catch (Exception e) {
            System.out.println(ANSI.RED + ANSI.HIGH_INTENSITY + "ERROR: Ivaild Choice" + ANSI.SANE);
            return askChoices(queston, choices);
        }
    }

    private  int askInt(String queston) {
        System.out.print(queston);
        try {
            return Integer.parseInt(in.next()); 
        } catch (Exception e) {
            System.out.println(ANSI.RED + ANSI.HIGH_INTENSITY + "ERROR: Ivaild Input" + ANSI.SANE);
            return askInt(queston);
        }
    }

    private  String askString(String queston) {
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

    private  int getSkillModifer (int skill) {
        return (skill - 10)/2;
    }

    private  void updateSkillModifers () {
        strModifer = getSkillModifer(str);
        dexModifer = getSkillModifer(dex);
        conModifer = getSkillModifer(con);
        inlModifer = getSkillModifer(inl);
        wisModifer = getSkillModifer(wis);
        chaModifer = getSkillModifer(cha);
    }
    //#endregion
}
