package patterns.creational.builder;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
