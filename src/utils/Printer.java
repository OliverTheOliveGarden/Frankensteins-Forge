package utils;

import java.security.PublicKey;
import java.util.Scanner;

public class Printer {
    private static final Scanner in = new Scanner(System.in);

    /**
     * Lets the user pick a choice form a list of strings.
     * 
     * @param queston The part that gets printed out.
     * @param choices The choices the user can pick from.
     * @return The user's pick.
    */
    public static String askChoices(String queston, String[] choices) {
        in.reset();
        System.out.println(queston);
        for(int i = 0; i < choices.length - 1; i++) {
            System.out.print(i + 1 + ": " + choices[i] + ", ");
        }
        System.out.print(choices.length + ": " + choices[choices.length - 1]);

        System.out.println("");

        try {
            return choices[Integer.parseInt(in.next()) - 1];
        } catch (Exception e) {
            System.out.println(ANSI.RED + ANSI.HIGH_INTENSITY + "ERROR: Ivaild Choice" + ANSI.SANE);
            return askChoices(queston, choices);
        }
    }
    
    /**
     * Ask the user a qustion and gets there response as an int
     * 
     * @param queston Gets printed out
     * @return User's response
     */
    public static int askInt(String queston) {
        in.reset();
        System.out.print(queston);
        try {
            return Integer.parseInt(in.next()); 
        } catch (Exception e) {
            System.out.println(ANSI.RED + ANSI.HIGH_INTENSITY + "ERROR: Ivaild Input" + ANSI.SANE);
            return askInt(queston);
        }
    }
    
    /**
     * Ask the user a qustion and gets there response as an string
     * 
     * @param queston Gets printed out
     * @return User's response
     */
    public static String askString(String queston) {
        in.reset();
        System.out.print(queston);
        try {
            return in.nextLine();
        } catch (Exception e) {
            System.out.println(ANSI.RED + ANSI.HIGH_INTENSITY + "ERROR: Ivaild Input" + ANSI.SANE);
            return askString(queston);
        }
    }
    /**
     * Prints out the standard error message
     */
    public static void errorMessage () {
        System.out.println(ANSI.RED + ANSI.HIGH_INTENSITY + ":#%+                                                                            =+*#+-:      ");
        System.out.println(":@*.-+#*=:                                                                        **: .-#*-    ");
        System.out.println("#@=...=++#*.       :+=-:                                                          =*+==:.+#=   ");
        System.out.println(" :--.....-+*:    .+#***%+.                                                         .++::::=*-  ");
        System.out.println(" -+@%-.:.=++##===#*.. .**.                                               =*@@#-     -=.::::..: ");
        System.out.println("   -=-:--....::--:.:-=**.                 *@@=%@*#@@@@==:                =+=.:*#-  :#+::::::#+ ");
        System.out.println("   :+==---:::::::::::--.              +@@@@-  :.     *@%%%%+-:           *+-.:.--  =+-:::::.*= ");
        System.out.println("    =+=::--=-:::::-:-.              *@@%-    .::::.....   .=+*#=.        :=*.:.+@@@+=.:::::.*= ");
        System.out.println("    .-+=::-=::::::-:-.          .:+++-..-*@%*-.:..-***==++==--+***=        =+=:---....::::. ++ ");
        System.out.println("     :+==:--::::::-=-.        .+**+##*=--:.           .-======---%@.       =+-::...::-==---=+= ");
        System.out.println("      +*=-=-:::::..:-:.       =*=+---.  .    =+*+-+=:    .:::--:::=*+.     =+::=::-=---::-+@%= ");
        System.out.println("      .++=-:::::.=+*:       :#*-::::::...-@@@@@@@@@@@@@*-  ::----::=++.    +#+=-::.-:::-+++    ");
        System.out.println("        -**+=:..-++=:       =+=:---:.  *@@@@@@@@@@@@@@@@@#: .:----::=#*-   .-**- .:=+**#-::    ");
        System.out.println("         .-=*##*##=.      -*+==:---..+@@@@@@@@@@@@@@@@@@@@@+  :----::-+-      -%%%%#===-       ");
        System.out.println("            ::::..        ++-::---. +@@@@@@@@@@@@@@@@@@@@@@@+:.:----:---..          .          ");
        System.out.println("                          =+.=---. -@@@@@@@@%%%%%%%%%%@@@@@@@*. ----:--%@                      ");
        System.out.println("                          =+.---: =@@@@@@@@%%@@@@@@@@%@@@@@@@@- .:--==:*@                      ");
        System.out.println("                          =*..-: -*@@@@@@@@%@@@@@@@@@@%@@@@@@@@=:.:::..*@                      ");
        System.out.println("                          -*:+-  =@@@@@@@@@@@@@@@@@@@@@@@@@@@@@#-.-:==:#@                      ");
        System.out.println("                          =*.:-:-@@@@@@@@@@#        =%@@@@@@@@@@* :---=%#.                     ");
        System.out.println("                          =*:.-.#@@@@@@@@=    .:...    **@@@@@@@@---:::-.                      ");
        System.out.println("                           +=-:.#@@@@@#+   ..:::-::...  .*@@@@@@@=:++##=                       ");
        System.out.println("                           -*#==#@@@@%- .:-===------==::. =%@@@@@=.-=+=:                       ");
        System.out.println("                            -=-#@@@@:...:--------------:.: .:#@@@#==%=                         ");
        System.out.println("                            :=: .. .. ::-----------::::==-:::-==*=:*@#                         ");
        System.out.println("                            .=*=:::....:::-:::-:--::==--::::--:++:=%*=                         ");
        System.out.println("                              -*###@@@+=:-::=----===--:*++++**#*#@%--                          ");
        System.out.println("                                    -=***%-::...::..:::++*%%#---...                            ");
        System.out.println("                                        =*@@@@@@@@@@@@@@%*-.                                   " + ANSI.SANE);
    }

    /**
     * Prints out an error message in the standard format
     * 
     * Overloads errorMessage 
     *
     * @param message the messsage being printed out
     */
    public static void errorMessage(String message) {
        message = ANSI.HIGH_INTENSITY + ANSI.RED + "Error: " + message + ANSI.SANE;
        System.out.println(message);
    }
    
    /**
     * Prints out the standard sucsses message
     */
    public static void sucssesMessage() {
        System.out.println(ANSI.GREEN + ANSI.HIGH_INTENSITY + "                                     =@@@@@@@@@@@%=                                                ");
        System.out.println("                              @@@##+=:............:=+##%@@                                         ");
        System.out.println("                          *@#*-..........................-*#@.                                     ");
        System.out.println("                       @@#-..................................:#@                                   ");
        System.out.println("                     @#=..............................%@@@%#:...-%@                                ");
        System.out.println("                   @#-......@@@@@@@@@@@@@::.........@@@#*##%@@@%..=%*                              ");
        System.out.println("                 @#-.......:@@@@@@@@@@@@.............%@@@@@@@@@#.:::+@                             ");
        System.out.println("            :-.#@=...........@@-:....................................:%#                           ");
        System.out.println("          @    *.......................................................*@                          ");
        System.out.println("    @   @ #    @..........................................::-:..........+@                         ");
        System.out.println("   @    -@ @@@@. ............:--...........:.............................**                        ");
        System.out.println("   @ =+@@*. @*      *.......................:=.............@@@@@@:........-@@                      ");
        System.out.println("   @    +.@@   :@    @.....%@@@@@@@@@@@@@@@=.........@@@@@@%****#@@@@@@@@@@#@@                     ");
        System.out.println("   @.:=@@  * @@@@@@@@@@@@@@%#*************#@@@@@@@@@@@#******************#%@%@                     ");
        System.out.println("        .=* @-...@=  @@@%***********************************************%@-.-@                     ");
        System.out.println("   @:   .@@@#+..@@   @..@**********************************************@%...-@@                    ");
        System.out.println("  @:    -@@#   @: .  +..@*********************************************%@....:@@                    ");
        System.out.println(" =#     =@        -@*=+-@#*********************###*******************%@:...::@                     ");
        System.out.println(" @      @*       @@-::...@%*******************%@:@#*****************%@.....::@                     ");
        System.out.println(" @     +@ .:-@@@%..:::::..@@#***************%@@.::@@#*************%@@......:-@                     ");
        System.out.println("=%@@@#@@.%@+-..............+@@#***********#@@...:-..@@#*********%@@........:*@                     ");
        System.out.println("%     @@##-:.-...............:@@@%#****%@@@%.....-+-::@@@@@@@@@%%....*..:..=@*                     ");
        System.out.println("    *@@ .%=-::......::...........#@@@@@@+......................-#@@@#@@-:::+@                      ");
        System.out.println("         @=::......+@@@@@@@@%%#+.........................@@@@@@@@@.........#@        @ : .         ");
        System.out.println("         @+---..........+@@@--  .+@*@@@@@@@@@@@@@@@@@@@@-*# .@@@..........:@@        @    *        ");
        System.out.println("         +%---:.............@@@@. -     :     :     =   .@@@@:............#@         @ -*-.        ");
        System.out.println("          @*---...............-+  @+*+**@%+*++@%=-:.@=++@ @*.....:.......=@.         @    @        ");
        System.out.println("          .%=--:.................*@     :     :     * . -@@....-=:......:@@          @ -@          ");
        System.out.println("           @#=--...................=@=. :     :     @ .:-....:%+.......:@@           @    +.       ");
        System.out.println("            @#--.............--.........#@*-=#@*=-+==.......#@:.......:@@            *.@@   .:.:   ");
        System.out.println("             @%=:..............%%:........................*@:......:-*@@            @ @@         @ ");
        System.out.println("              @@*-...............%@#....................%@:......::-@@             @@ #-         @ ");
        System.out.println("               .@%+:................@@@:.............@@@-.:.....:=@@@             @.  @@@-=@@@@@@@ ");
        System.out.println("                 @@@=:................:+%@@@@@@@@@@@@-......:::=@@@               @:@@:+.        . ");
        System.out.println("                   @@@*:.:::...........:=---====:.........:.:=@@@                 @%@@           . ");
        System.out.println("                     +@@%=::::-:::......................:-*@@@@                     @+@@@@@@@@@@@* ");
        System.out.println("                        @@@@%=-::..................:-=#@@@@=                         @%        -   ");
        System.out.println("                            @@@@@@@@#+=------=+%@@@@@@@.                             :@        @   ");
        System.out.println("                                  .*@@@@@@@@@@@@=                                      =*@@@@@@    " + ANSI.SANE);
    }

    /**
     * Prints out an sucsses message in the standard format
     * 
     * Overloads sucssesMessage 
     *
     * @param message the messsage being printed out
     */
    public static void sucssesMessage (String message) {
        message = ANSI.HIGH_INTENSITY + ANSI.GREEN + message + ANSI.SANE;
        System.out.println(message);
    }
}