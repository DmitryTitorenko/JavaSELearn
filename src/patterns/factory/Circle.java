package patterns.factory;

import patterns.factory.Shape;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class Circle implements Shape {
    @Override
    public void daw() {
        System.out.println("Inside Circle.draw() method.");
    }
}
