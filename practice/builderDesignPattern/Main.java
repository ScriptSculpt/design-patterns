package practice.builderDesignPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Builder Design Pattern");

        HttpRequest request = new HttpRequest.HttpRequestBuilder()
                .withUrl("https://example.com/api")
                .withMethod("POST")
                .withBody("{\"key\": \"value\"}")
                .build();

        request.execute();
    }
}
