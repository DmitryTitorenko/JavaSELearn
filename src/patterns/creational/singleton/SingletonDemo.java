package patterns.creational.singleton;

/**
 * @author Dmitry Titorenko on 05.03.2018
 * <p>
 * This type of design pattern comes under creational pattern as this pattern
 * provides one of the best ways to create an object.
 * <p>
 * This pattern involves a single class which is responsible to create an object while
 * making sure that only single object gets created. This class provides a way to access
 * its only object which can be accessed directly without need to instantiate the object of the class.
 * <p>
 * see https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
 */
public class SingletonDemo {
    public static void main(String[] args) {
        SingleObject singleObject = SingleObject.getInstance();
        singleObject.getMessage();
    }
}
