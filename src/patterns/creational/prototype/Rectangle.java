package patterns.creational.prototype;

/**
 * @author Dmitry Titorenko on 06.03.2018
 */
public class Rectangle extends Shape {

    public Rectangle(int id) {
        super(id);
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle.draw() method.");
    }
}
