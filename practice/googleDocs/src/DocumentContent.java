package practice.googleDocs.src;

import java.util.ArrayList;

public class DocumentContent {
    private ArrayList<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element) {
        documentElements.add(element);
    }

    public String renderDocument() {
        String result = "";
        for(DocumentElement element: documentElements) {
            result += element.render();
        }
        return result;
    }


}
