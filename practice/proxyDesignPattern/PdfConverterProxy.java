package practice.proxyDesignPattern;

public class PdfConverterProxy implements PdfConverter {

    private AbcConverter abcConvertor;
    private User user;

    public PdfConverterProxy(User user) {
        this.user = user;
        System.out.println("Proxy initialized...");
    }

    @Override
    public void convertToPdf(String filePath) {
        abcConvertor = new AbcConverter();
        abcConvertor.convertToPdf(filePath);
    }

    @Override
    public void readPdf(String filePath) {
        abcConvertor = new AbcConverter();
        abcConvertor.readPdf(filePath);
    }

    @Override
    public void editPdf(String filePath) {
        if(user.isPremium()) {
            abcConvertor = new AbcConverter();
            abcConvertor.editPdf(filePath);
        } else {
            System.out.println("Editing PDF is available only to premium users.");
        }
    }
    
}
