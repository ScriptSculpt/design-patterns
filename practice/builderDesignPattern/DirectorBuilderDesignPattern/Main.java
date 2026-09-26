package practice.builderDesignPattern.DirectorBuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Builder Design Pattern with Director");

        HttpRequest request1 = HttpRequestDirector.constructGetrequest("www.google.com");
        request1.execute();

        HttpRequest request2 = HttpRequestDirector.constructPostRequest(
                                "www.google.com", 
                                "{\"car\": \"mercedes\"}"
                            );
        request2.execute();

    }
}
