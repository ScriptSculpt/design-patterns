package practice.proxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        User regularUser = new User("Alice", false);
        User premiumUser = new User("Bob", true);

        PdfConverter regularUserProxy = new PdfConverterProxy(regularUser);
        regularUserProxy.convertToPdf("document.txt");
        regularUserProxy.readPdf("document.pdf");
        regularUserProxy.editPdf("document.pdf"); // Should not allow editing

        System.out.println(" ---------------------------------------------------- ");

        PdfConverter premiumUserProxy = new PdfConverterProxy(premiumUser);
        premiumUserProxy.convertToPdf("document.txt");
        premiumUserProxy.readPdf("document.pdf");
        premiumUserProxy.editPdf("document.pdf"); // Should allow editing
    }
}
