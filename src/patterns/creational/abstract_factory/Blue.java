package patterns.creational.abstract_factory;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue.fill() method.");
    }
}
