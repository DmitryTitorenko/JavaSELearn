package patterns.creational.builder;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
