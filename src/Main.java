public class Main {
    @SuppressWarnings("static-access")
    public static void main(String[] args) {
        CharSheet mysheet = new CharSheet();

        mysheet.addAtk();
        System.out.println(mysheet.atks.get(mysheet.atksNames.get(0)));
    }
}
