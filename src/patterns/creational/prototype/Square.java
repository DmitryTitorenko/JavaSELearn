package patterns.creational.prototype;

/**
 * @author Dmitry Titorenko on 06.03.2018
 */
public class Square extends Shape {

    public Square(int id) {
        super(id);
        type = "Square";
    }

    @Override
    void draw() {
        System.out.println("Inside Square.draw() method.");
    }
}
