package patterns.creational.abstract_factory;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle.draw() method.");
    }
}
