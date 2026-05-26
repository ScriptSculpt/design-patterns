package practice.googleDocs.src;

public class SaveToDB implements Persistence{

    @Override
    public void save(String renderDocument) {
        System.out.println("Saving to DB: " + renderDocument);
    }
    
}
