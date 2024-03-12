public class Main {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        CharSheet mysheet = new CharSheet();
        CharSheet myshett2 = new CharSheet();

        mysheet.addAtk();
        myshett2.addAtk();
        System.out.println(mysheet.atks.get(mysheet.atksNames.get(0)));
        System.out.println(myshett2.atks.get(myshett2.atksNames.get(0)));
    }
}
