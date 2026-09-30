package practice.flyweightDesignPattern;


public class Flyweight {
    private int length;
    private int width;
    private int height;
    private String shape;

    public Flyweight(int length, int width, int height, String shape) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.shape = shape;
    }

    public void draw(int positionX, int positionY, String color) {
        System.out.println("Drawing " + shape + " of size (" + length + ", " + width + ", " + height + ") at position (" + positionX + ", " + positionY + ") with color " + color);
    }
}
