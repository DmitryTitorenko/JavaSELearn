package patterns.creational.factory;

/**
 * @author Dmitry Titorenko on 05.03.2018
 * <p>
 * This type of design pattern comes under creational pattern as
 * this pattern provides one of the best ways to create an object.
 * <p>
 * In Factory pattern, we create object without exposing the creation
 * logic to the client and refer to newly created object using a common interface.
 */
public class FactoryDemo {
    public static void main(String[] args) {
        ShapeFactory.getShape("circle").daw();
    }
}
