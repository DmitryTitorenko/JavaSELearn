package patterns.openclosed;

/**
 * @author Dmitry Titorenko on 07.03.2018
 */
public class WriteLocal implements IWriteText {
    @Override
    public void write(String text) {
        System.out.println("Write local to HDD: "+ text);
    }
}
