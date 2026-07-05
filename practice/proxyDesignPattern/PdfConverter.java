package practice.proxyDesignPattern;

public interface PdfConverter {
    public void convertToPdf(String filePath);
    public void readPdf(String filePath);
    public void editPdf(String filePath);
}
