package patterns.singleton;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        return instance;
    }

    public void getMessage() {
        System.out.println("This is singleton");
    }
}
