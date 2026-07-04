package practice.compositeDesignPattern;

public class Files implements FilesystemItem {

    private String name;
    private int size;
    private int indentLevel;

    public Files(String name, int size) {
        this.name = name;
        this.size = size;
        this.indentLevel = 0;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void ls() {
        System.out.println(" ".repeat(indentLevel) + this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public FilesystemItem cd(String name) {
        return null; // Files cannot contain other items, so return null
    }

    @Override
    public Boolean isDirectory() {
        return false; // Files are not directories
    }

    @Override
    public void showHeierarchy(int indentLevel) {
        System.out.println(" ".repeat(indentLevel) + "- " + this.name);
    }
    
}
