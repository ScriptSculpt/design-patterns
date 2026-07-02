package practice.adapterDesignPattern;

public class LegacyCodeAdapter implements Adapter {

    private LegacyCode legacyCode;

    public LegacyCodeAdapter(LegacyCode legacyCode) {
        this.legacyCode = legacyCode;
    }

    private static String getValue(String xml, String tag) {
        String startTag = "<" + tag + ">";
        String endTag = "</" + tag + ">";

        int start = xml.indexOf(startTag);
        if (start == -1) return "";

        start += startTag.length();

        int end = xml.indexOf(endTag, start);
        if (end == -1) return "";

        return xml.substring(start, end);
    }

    @Override
    public String getJsonData() {
        String xmlData = legacyCode.getXmlData();
        System.out.println("Converting XML data to JSON: \n" + xmlData);
        
        String name = getValue(xmlData, "name");
        String age = getValue(xmlData, "age");

        String json = "{"
        + "\"name\":\"" + name + "\","
        + "\"age\":" + age
        + "}";
        
        return json;
    }
    
    
}
