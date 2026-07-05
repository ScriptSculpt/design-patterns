package practice.proxyDesignPattern;

public class AbcConverter implements PdfConverter {


    public AbcConverter() {
        // Simulate some initialization logic
    }

    @Override
    public void convertToPdf(String filePath) {
        System.out.println("Converting " + filePath + " to PDF format.");
    }

    @Override
    public void readPdf(String filePath) {
        System.out.println("Reading PDF file: " + filePath);
    }

    @Override
    public void editPdf(String filePath) {
        System.out.println("Editing PDF file: " + filePath);
    }
}
