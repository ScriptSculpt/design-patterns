package practice.flyweightDesignPattern;

public class ExtrinsicContext {
    private Flyweight flyweight;
    private int positionX;
    private int positionY;
    private String color;

    public ExtrinsicContext(Flyweight flyweight, int positionX, int positionY, String color) {
        this.flyweight = flyweight;
        this.positionX = positionX;
        this.positionY = positionY;
        this.color = color;
    }

    public void draw() {
        flyweight.draw(positionX, positionY, color);
    }
}
