package practice.googleDocs.src;

public class Main {
    public static void main(String[] args) {

        DocumentEditor editor = new DocumentEditor();
        editor.addText("Welcome to Google Docs!");
        editor.addImage("Image.png");
        editor.addText("This is a simple document editor.");

        System.out.println(editor.renderDocument());
        editor.saveToFile();
    }
}
