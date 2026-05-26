package practice.googleDocs.src;

public class SafeDocumentEditor {
    private DocumentContent documentContent = new DocumentContent();
    private Persistence storage;
    private String document;

    public SafeDocumentEditor(DocumentContent documentContent, Persistence storage) {
        this.documentContent = documentContent;
        this.storage = storage;
        this.document = "";
    }

    public void addText(String text) {
        documentContent.addElement(new TextDocument(text));
    }

    public void addImage(String imagePath) {
        documentContent.addElement(new ImageDocument(imagePath));
    }

    public String renderDocument() {
        if(document.isEmpty()) {
            document = documentContent.renderDocument();
        }
        return document;
    }

    public void save() {
        storage.save(renderDocument());
    }
}
