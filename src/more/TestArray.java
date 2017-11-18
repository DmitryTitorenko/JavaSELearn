package more;

import java.util.ArrayList;

public class TestArray {
    public static void main(String[] args) {
        SuperClass[] superClass = new SuperClass[5];
        superClass[0] = new SubClass();
        superClass[1] = new SuperClass();
        Object o = new Object();
        o = superClass[0];
        o = new int[29];
        System.out.println(superClass[1].getClass());
        if (superClass[1] instanceof SuperClass){
            System.out.println("superClass is instanceof SuperClass");
        }
        if (superClass[0]instanceof SuperClass){
            System.out.println("subClass is instanceof SuperClass");
        }

        if (superClass[1]instanceof SubClass){
            System.out.println("superClass is instanceof SubClass");

        }

        SuperClass superClass1=new SuperClass();
        ArrayList<Object> myArray=new ArrayList<>();
        myArray.add(superClass1);
        myArray.add(o);
        myArray.add(superClass);
        int [] a =new int[10];
        myArray.add(a);
    }
}
