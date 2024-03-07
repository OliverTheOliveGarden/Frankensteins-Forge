import java.util.Scanner;

import utils.ANSI;
import utils.DiceRoller;

public class CharSheet {
    static final DiceRoller DiceRoller = new DiceRoller();
    static final Scanner in = new Scanner(System.in);

    public static int level = 1;

    public static int str = 0;
    public static int dex = 0;
    public static int con = 0;
    public static int inl = 0;
    public static int wis = 0;
    public static int cha = 0;

    public static int strModifer = 0;
    public static int dexModifer = 0;
    public static int conModifer = 0;
    public static int inlModifer = 0;
    public static int wisModifer = 0;
    public static int chaModifer = 0;
    
    public static String charName;

    public static String Class;
    public static String subClass;

    public static boolean inspration = false;

    public static int Proficiancy = 0;



    CharSheet(){
        creatCharSheet();
    }

    private static void creatCharSheet () {
        charName = askString("What is your charcters name: ");

        str = askInt("what is charters str: ");
        dex = askInt("what is charters dex: ");
        con = askInt("what is charters con: ");
        inl = askInt("what is charters int: ");
        wis = askInt("what is charters wis: ");
        cha = askInt("what is charters cha: ");

        strModifer = getSkillModifer(str);
        dexModifer = getSkillModifer(dex);
        conModifer = getSkillModifer(con);
        inlModifer = getSkillModifer(inl);
        wisModifer = getSkillModifer(wis);
        chaModifer = getSkillModifer(cha);

        System.out.println("Your strModifer is: " + strModifer);
        System.out.println("Your dexModifer is: " + dexModifer);
        System.out.println("Your conModifer is: " + conModifer);
        System.out.println("Your inlModifer is: " + inlModifer);
        System.out.println("Your wisModifer is: " + wisModifer);
        System.out.println("Your chaModifer is: " + chaModifer);
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

    //#region skills
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
    //#endregion
}
