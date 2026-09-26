package practice.builderDesignPattern.StepBuilderDesignPattern;

public class HttpRequest {
    private String method;
    private String url;
    private String body;

    private HttpRequest() {};

    interface MethodStep {
        UrlStep withMethod(String method);
    }

    interface UrlStep {
        BodyStep withUrl(String url);
    }

    interface BodyStep {
        BuildStep withBody(String body);
    }

    interface BuildStep {
        HttpRequest build();
    }

    private static class HttpRequestBuilder implements MethodStep, UrlStep, BodyStep, BuildStep {

        private String method;
        private String url;
        private String body;

        @Override
        public BuildStep withBody(String body) {
            this.body = body;
            return this;
        }
        @Override
        public BodyStep withUrl(String url) {
            this.url = url;
            return this;
        }
        @Override
        public UrlStep withMethod(String method) {
            this.method = method;
            return this;
        }
        @Override
        public HttpRequest build() {
            HttpRequest request = new HttpRequest();
            request.method = this.method;
            request.url = this.url;
            request.body = this.body;
            return request;
        }
        
    }

    public static MethodStep newBuilder() {
        return new HttpRequestBuilder();
    }

    public void execute() {
        // Simulate executing the HTTP request
        System.out.println("Executing " + method + " request to " + url + " with body: " + body);
    }
}

