package patterns.openclosed;

/**
 * @author Dmitry Titorenko on 07.03.2018
 */
public class Math {
    private  IWriteText iWriteData;
    private  int result;

    public  void sum(int a, int b) {
        result = a + b;
    }

    public  void write(IWriteText iWriteData) {
        iWriteData.write(Integer.toString(result));
    }
}
