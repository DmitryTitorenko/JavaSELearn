package patterns.creational.builder;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
