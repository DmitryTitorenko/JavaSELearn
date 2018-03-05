package patterns.builder;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }
}
