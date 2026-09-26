package practice.builderDesignPattern.DirectorBuilderDesignPattern;

public class HttpRequestDirector {
    public static HttpRequest constructGetrequest(String url) {
        return new HttpRequest.HttpRequestBuilder()
                .withMethod("GET")
                .withUrl(url)
                .build();
    }

    public static HttpRequest constructPostRequest(String url, String body) {
        return new HttpRequest.HttpRequestBuilder()
                .withMethod("POST")
                .withUrl(url)
                .withBody(body)
                .build();
    }
}
