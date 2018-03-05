package patterns.abstract_factory;

/**
 * @author Dmitry Titorenko on 05.03.2018
 * <p>
 * Abstract Factory patterns work around a super-factory which creates other factories.
 * This factory is also called as factory of factories.
 * This type of design pattern comes under creational pattern as this pattern provides one of the best ways to create an object.
 * <p>
 * In Abstract Factory pattern an interface is responsible for creating a factory of related objects without explicitly specifying their classes.
 * Each generated factory can give the objects as per the Factory pattern.
 * <p>
 * see https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm
 */
public class AbstractFactoryDemo {
    public static void main(String[] args) {
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");
        Color color = colorFactory.getColor("green");
        color.fill();
    }
}
