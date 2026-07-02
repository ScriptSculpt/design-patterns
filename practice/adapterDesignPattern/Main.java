package practice.adapterDesignPattern;

public class Main {
    public static void main(String[] args) {
        LegacyCode legacyCode = new LegacyCode();
        Adapter adapter = new LegacyCodeAdapter(legacyCode);

        NewCode newCode = new NewCode(adapter);

        System.out.println(newCode.getJsonData());
    }
}
