package patterns.builder;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class Coke extends ColdDrink {
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
