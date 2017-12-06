package more;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class MyPoxyTest {
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        //fill elements with proxies for the integers 1...1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;

            //construct wrapper
            InvocationHandler handler = new TraceHandler(value);

            //construct proxy for one or more interfaces
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        //construct a random integer
        Integer key = new Random().nextInt(elements.length + 1);

        //search for the key
        int result = Arrays.binarySearch(elements, key);

        //print math if found
        if (result >= 0) System.out.println(elements[result]);

        elements[0].toString();
        elements[0].equals(5);
    }
}

/*
An invocation handler that prints out the method name and parameters,
then invoke the original method
 */
class TraceHandler implements InvocationHandler {
    private Object target;

    public TraceHandler(Object t) {
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // print implicit argument
        System.out.print("'target' " + target);

        // print method name
        System.out.print("." + method.getName() + "(");

        // print explicit arguments
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print("'args[i]' " + args[i]);
            }
        }
        System.out.println(")");

        /*
        When we invoke method Comparable or any of Object class we call this invoke method and only then we call original
        method
        (use debug to see it)
         */
        if (method.getName().equals("toString")) {
            System.out.println("it's method toSting");
        }

        // invoke actual method
        return method.invoke(target, args);
    }
}