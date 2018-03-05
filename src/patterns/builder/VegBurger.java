package patterns.builder;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
