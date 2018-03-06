package patterns.creational.prototype;

/**
 * @author Dmitry Titorenko on 06.03.2018
 * <p>
 * This pattern involves implementing a prototype interface which tells to create
 * a clone of the current object. This pattern is used when creation of object
 * directly is costly. For example, an object is to be created after a costly
 * database operation. We can cache the object, returns its clone on next
 * request and update the database as and when needed thus reducing
 * database calls.
 */
public class PrototypeDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape clonedShape = ShapeCache.getShapeById(1);
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = ShapeCache.getShapeById(3);
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = ShapeCache.getShapeById(1);
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
