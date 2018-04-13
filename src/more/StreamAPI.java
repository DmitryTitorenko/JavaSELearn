package more;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Dmitry Titorenko on 24.03.2018
 */
public class StreamAPI {
    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        int a = stream.filter(x -> x > 3)
                .findFirst()
                .get();
        System.out.println(a);

        List<Integer> integers = Stream.of(1, 2, 3, 4, 4)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(integers);

        //stream object to primitive stream (int)
        a = Stream.of("i1", "i2")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();
        System.out.println(a);

        //stream int to stream object
        List<String> strings = IntStream.of(1, 2, 4)
                .map(i->i*i)
                .mapToObj(i -> "s" + i)
                .collect(Collectors.toList());
        System.out.println(strings);


        System.out.println(someOptional(Optional.of(3)));

    }

    private static Integer someOptional(Optional<Integer> integer) {

        // set new value
        integer = Optional.of(9);
        integer.ifPresent(System.out::println);

        integer = Optional.empty();

        if (integer.isPresent()) {
            System.out.println("not empty ");
        } else {
            System.out.println("empty");
        }

        //return 1 if integer is empty
        return integer.orElse(1);

    }
}
