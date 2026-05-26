package practice.googleDocs.src;

public class TextDocument implements DocumentElement{

    private String content;

    public TextDocument(String content) {
        this.content = content;
    }

    @Override
    public String render() {
        return content + "\n";
    }
    
}
