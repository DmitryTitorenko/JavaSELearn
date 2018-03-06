package patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmitry Titorenko on 06.03.2018
 * <p>
 * PrototypePatternDemo uses ShapeCache class to get clones of shapes stored in a HashMap.
 */

public class ShapeCache {

    private static Map<Integer, Shape> shapes = new HashMap<>();

    public static void loadCache() {
        Circle circle = new Circle(1);
        shapes.put(circle.getId(), circle);

        Square square = new Square(2);
        shapes.put(square.getId(), square);

        Rectangle rectangle = new Rectangle(3);
        shapes.put(rectangle.getId(), rectangle);
    }

    public static Shape getShapeById(int shapeId) {
        Shape cachedShape = shapes.get(shapeId);
        return (Shape) cachedShape.clone();
    }
}
