package patterns.abstract_factory;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red.fill() method.");
    }
}
