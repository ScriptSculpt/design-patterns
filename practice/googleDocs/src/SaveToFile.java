package practice.googleDocs.src;

import java.nio.file.Files;
import java.nio.file.Path;

public class SaveToFile implements Persistence {

    @Override
    public void save(String renderDocument) {
        try {
            Files.writeString(Path.of("practice/googleDocs/src/safeDocument.txt"), renderDocument);
            System.out.println("Document saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving document: " + e.getMessage());
        }
    }
    
}
