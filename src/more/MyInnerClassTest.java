package more;

public class MyInnerClassTest {

    //inner class cannot have static methods

    public static void main(String[] args) {

        MyOuterClass myOuter = new MyOuterClass();
        MyOuterClass.MyInnerClass inner = myOuter.new MyInnerClass();  // create object of inner class in other class
        MyOuterClass.MyInnerClass inner2 = myOuter.getMyInnerClass();    // create object of inner use method
        System.out.println(inner.c);
        inner2.test();

        myOuter.localInnerClass();
    }

}

class MyOuterClass {
    private int a = 10;

    public MyInnerClass getMyInnerClass() {
        return new MyInnerClass();// create object of inner class in the outer class

    }


    public class MyInnerClass {
        private static final int b = 10; // any static field declared in an inner class must be final because
        // separate instance of the inner class for each outer object
        int c = b + a;// can get "a" direct

        public void test() {
            MyOuterClass myOuterClass = new MyOuterClass();
            //myOuterClass.a; //  can't get "a"
            c = a; // can get "a" direct
            System.out.println("can get outer private variable 'int a' direct");
        }
    }


    private class MyInnerPrivateClass { // can make private class
    }


    public void localInnerClass() { //can define the class locally in a single method
        int q0 = 10; // define local variable, if we change it late, we can't use it in local inner class

        /*
             Local classes are never declared with an access specifier(public or private)
             Their scope is always restricted to the block in which they are declared
        */

        class LocalInnerClass {

            int q1 = q0 + a + 1; // the inner class can access local variable only if it is effectively final

            public void getQ1() {
                System.out.println("q1=" + q1 + " can get q1 because q1 doesn't change in the method ");
            }
        }

        //q0++;  // if we later change local variable - we can't use her in local inner class

         /*
         Starting in Java SE 8, a local class can access local variables and parameters of the enclosing block
         that are final or effectively final.
         A variable or parameter whose value is never changed after it is initialized is effectively final.
        */

        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.getQ1();
    }
}
