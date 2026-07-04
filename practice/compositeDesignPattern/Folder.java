package practice.compositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FilesystemItem {
    private String name;
    private List<FilesystemItem> items;

    public Folder(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    public void add(FilesystemItem item) {
        items.add(item);
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for(FilesystemItem item : items) {
            totalSize += item.getSize();
        }
        return totalSize;
    }

    @Override
    public void ls() {
        System.out.println(this.name + "/");
        for(FilesystemItem item : items) {
            if(item.isDirectory()) {
                System.out.println("+ " + item.getName() + "/");
            } else {
                System.out.println("- " + item.getName());
            }
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public FilesystemItem cd(String name) {
        for(FilesystemItem item : items) {
            if(item.getName().equals(name) && item.isDirectory()) {
                return item;
            }
        }
        return null;
    }

    @Override
    public Boolean isDirectory() {
        return true;
    }

    @Override
    public void showHeierarchy(int indentLevel) {
        for(FilesystemItem item : items) {
            if(item.isDirectory()) {
                System.out.println(" ".repeat(indentLevel) + "+ " + item.getName() + "/");
                ((Folder)item).showHeierarchy(indentLevel + 2);
            } else {
                System.out.println(" ".repeat(indentLevel) + "- " + item.getName());
            }
        }
    }
}
