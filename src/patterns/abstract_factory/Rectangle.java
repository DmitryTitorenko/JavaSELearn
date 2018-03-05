package patterns.abstract_factory;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle.draw() method.");
    }
}
