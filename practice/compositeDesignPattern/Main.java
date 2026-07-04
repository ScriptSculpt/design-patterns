package practice.compositeDesignPattern;

public class Main {
    public static void main(String[] args) {
        Files file1 = new Files("file1.txt", 100);
        Files file2 = new Files("file2.txt", 200);
        Folder folder1 = new Folder("folder1");
        Files file3 = new Files("file3.txt", 300);
        Files file4 = new Files("file4.txt", 400);
        folder1.add(file3);
        folder1.add(file4);
        folder1.ls();
        System.out.println("Total size of folder1: " + folder1.getSize() + " bytes");

        System.out.println(" ---------------------------------------------------- ");


        Folder folder2 = new Folder("folder2");
        folder2.add(folder1);
        folder2.add(file1);
        folder2.add(file2);
        System.out.println("Structure of folder2: ");
        folder2.showHeierarchy(0);
    }
}
