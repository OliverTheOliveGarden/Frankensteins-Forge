import file.JsonFile;
import file.savingConstants;

public class Main {
    public static void main(String[] args) {
        JsonFile file = new JsonFile(savingConstants.atksSavePath, "test");
        file.put("sfjhdk", "balls");
        file.put("cokc", "hhdhdh");
    } 
}
