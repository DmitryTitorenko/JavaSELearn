package patterns.bridge;

/**
 * @author Dmitry Titorenko on 06.03.2018
 * <p>
 * Bridge is used when we need to decouple an abstraction from its implementation so that
 * the two can vary independently. This type of design pattern comes under structural pattern
 * as this pattern decouples implementation class and abstract class by providing a bridge
 * structure between them.
 * <p>
 * This pattern involves an interface which acts as a bridge which makes the functionality of
 * concrete classes independent from interface implementer classes. Both types of classes
 * can be altered structurally without affecting each other.
 * <p>
 * We are demonstrating use of Bridge pattern via following example in which a circle can
 * be drawn in different colors using same abstract class method but different bridge
 * implementer classes.
 * <p>
 * see https://sourcemaking.com/design_patterns/bridge
 * see https://www.youtube.com/watch?v=moMF84Mp1tw
 */
public class BridgeDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}