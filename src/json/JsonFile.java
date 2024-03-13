package json;
import java.io.File;

public class JsonFile {
    String dirc;
    String fileName;
    File file;
    
        

    JsonFile(String dirc, String fileName) {
        this.dirc = dirc;
        this.fileName = fileName;
        file = new File(dirc);
        
    }
}