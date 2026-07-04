package practice.compositeDesignPattern;

public interface FilesystemItem {
    public int getSize();
    public void ls();
    public String getName();
    public FilesystemItem cd(String name);
    public Boolean isDirectory();
    public void showHeierarchy(int indentLevel);
}
