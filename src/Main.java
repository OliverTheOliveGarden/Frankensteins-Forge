import file.JsonFile;
import file.savingConstants;

public class Main {
    public static void main(String[] args) {
        JsonFile file = new JsonFile(savingConstants.atksSavePath, "test");
        System.out.println(savingConstants.userHome);
        System.out.println(file);
    } 
}
