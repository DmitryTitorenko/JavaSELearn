package patterns.bridge;

/**
 * @author Dmitry Titorenko on 06.03.2018
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}