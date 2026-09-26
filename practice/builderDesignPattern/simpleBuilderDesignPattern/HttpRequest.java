package practice.builderDesignPattern.simpleBuilderDesignPattern;

public class HttpRequest {
    private String method;
    private String url;
    private String body;

    private HttpRequest() {};

    public static class HttpRequestBuilder {

        private String method;
        private String url;
        private String body;

        public HttpRequestBuilder withMethod(String method) {
            this.method = method;
            return this;
        }

        public HttpRequestBuilder withUrl(String url) {
            this.url = url;
            return this;
        }

        public HttpRequestBuilder withBody(String body) {
            this.body = body;
            return this;
        }

        public HttpRequest build() {
            HttpRequest request = new HttpRequest();
            request.method = this.method;
            request.url = this.url;
            request.body = this.body;
            return request;
        }
    }

    public void execute() {
        // Simulate executing the HTTP request
        System.out.println("Executing " + method + " request to " + url + " with body: " + body);
    }
}
