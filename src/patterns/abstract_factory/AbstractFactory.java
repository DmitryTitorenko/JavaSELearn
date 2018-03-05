package patterns.abstract_factory;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);

    abstract Shape getShape(String shape);
}
