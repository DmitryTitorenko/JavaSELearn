package patterns.creational.prototype;

/**
 * @author Dmitry Titorenko on 06.03.2018
 */
public abstract class Shape implements Cloneable {

    private int id;
    protected String type;

    abstract void draw();

    public String getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public Shape(int id) {
        this.id = id;
    }


    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
