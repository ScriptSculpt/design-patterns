package practice.adapterDesignPattern;

public class NewCode {
    private Adapter adapter;

    public NewCode(Adapter adapter) {
        this.adapter = adapter;
    }

    public String getJsonData() {
        return adapter.getJsonData();
    }
}
