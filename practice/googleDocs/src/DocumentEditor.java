package practice.googleDocs.src;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DocumentEditor {
    private ArrayList<String> documentContents = new ArrayList<>();
    private String document = new String();

    public void addText(String text) {
        documentContents.add(text);
    }

    public void addImage(String imagePath) {
        documentContents.add("[Image: " + imagePath + "]");
    }

    public String renderDocument() {

        if(document.isEmpty()) {
            for(String content: documentContents) {
                document += content + "\n";
            }
        }
        return document;
    }

    public void saveToFile() {
        try {
            // FileWriter writer = new FileWriter("document.txt");
            // writer.write(renderDocument());
            // writer.close();
            Files.writeString(Path.of("practice/googleDocs/src/document.txt"), renderDocument());
            System.out.println("Document saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving document: " + e.getMessage());
        }
    }

}
