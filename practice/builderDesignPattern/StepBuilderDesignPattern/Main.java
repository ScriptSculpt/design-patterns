package practice.builderDesignPattern.StepBuilderDesignPattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Builder Design Pattern with Step Builder");
        
        HttpRequest request = HttpRequest.newBuilder()
                .withMethod("POST")
                .withUrl("/example/api")
                .withBody("{\"key\": \"value\"}")
                .build();

        request.execute();
    }
}
