package more;

/**
 * @author Dmitry Titorenko on 25.01.2018
 */
public class MyLambdaSimple {

    public static void main(String[] args) {
        SumI sumI = (a, b) -> a + b;

        sumI = RealiseSum::sum;
    }
}

class RealiseSum {
    static int sum(int a, int b) {
        return a + b;
    }
}

@FunctionalInterface
interface SumI {
    int sum(int a, int b);
}
