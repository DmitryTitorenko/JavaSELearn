package patterns.openclosed;

/**
 * @author Dmitry Titorenko on 07.03.2018
 */
public class WriteDB implements IWriteText {
    @Override
    public void write(String text) {
        System.out.println("Write to DB: "+text);
    }
}
