package practice.googleDocs.src;

import javax.print.Doc;

public class Main {
    public static void main(String[] args) {

        // DocumentEditor editor = new DocumentEditor();
        // editor.addText("Welcome to Google Docs!");
        // editor.addImage("Image.png");
        // editor.addText("This is a simple document editor.");

        // System.out.println(editor.renderDocument());
        // editor.saveToFile();

        DocumentContent documentContent = new DocumentContent();
        Persistence storage = new SaveToFile();

        SafeDocumentEditor safeEditor = new SafeDocumentEditor(documentContent, storage);

        safeEditor.addText("Welcome to Google Docs!");
        safeEditor.addImage("Image.png");
        safeEditor.addText("This is a safe simple document editor.");

        System.out.println(safeEditor.renderDocument());
        safeEditor.save();
    }
}
