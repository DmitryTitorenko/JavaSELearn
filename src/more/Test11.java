package more;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Dmitry Titorenko on 20.03.2018
 */
public class Test11 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);


        list.stream().filter(x -> x < 1).forEach(System.out::println);



    }
}
