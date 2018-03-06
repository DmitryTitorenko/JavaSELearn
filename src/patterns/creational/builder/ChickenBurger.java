package patterns.creational.builder;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
