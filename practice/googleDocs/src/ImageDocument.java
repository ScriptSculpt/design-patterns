package practice.googleDocs.src;

public class ImageDocument implements DocumentElement{

    private String content;

    public ImageDocument(String content) {
        this.content = content;
    }
    @Override
    public String render() {
        return "[Image: " + content + "]" + "\n";
    }
    
}
