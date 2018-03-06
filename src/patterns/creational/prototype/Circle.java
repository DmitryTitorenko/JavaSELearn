package patterns.creational.prototype;

/**
 * @author Dmitry Titorenko on 06.03.2018
 */
public class Circle extends Shape {

    public Circle(int id) {
        super(id);
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
