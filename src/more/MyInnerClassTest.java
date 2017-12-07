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

        //create object of a static inner class, witch doesn't have a reference to the outer class object
        MyOuterClass.StaticInnerClasses staticInnerClasses = new MyOuterClass.StaticInnerClasses();
    }

}

class MyOuterClass { // SomeInterface need for show anonymous inner class
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

    /*
     If you want to make only a single object of this class, you dong't even need to give the class a name.
     Such class is called an anonymous inner class.
     Java Anonymous inner class can be created by two ways:
        -Class (may be abstract or concrete)
        -Interface
     */

    public void AnonymousInnerClassExtendAbstract() {
        SomeAbstractClass someAbstractClass = new SomeAbstractClass() {
            @Override
            void someMethod() {
                System.out.println(a); // can get private int "a";
            }
        };
    }


    public void AnonymousInnerClass() {
        SomeInterface someInterface = new SomeInterface() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };

        LambdaVSAnonymousInnerClass(someInterface);
    }

    public void LambdaExpression() {
        SomeInterface someInterface = (int a, int b) -> a + b;

        LambdaVSAnonymousInnerClass(someInterface);
    }

    public void LambdaVSAnonymousInnerClass(SomeInterface someInterface) {
    }

    static class StaticInnerClasses {
        public int sum(int a, int b) {
            return a + b;
        }

    }
}


/*
 Interface for show anonymous inner class
 */
interface SomeInterface {
    int sum(int a, int b);

    static class StaticClassInsideInterface {
        /*
        Inner classes that are declare inside an interface are automatically static and public
         */
    }
}

/*
 Abstract class for show anonymous inner class
 */
abstract class SomeAbstractClass {
    int a;

    SomeAbstractClass() {
    }

    abstract void someMethod();
}

class InterfaceInsideClassInsideInterface {
    interface Interface {
        class ClassInsideInterface {
            interface More {
            }
        }
    }
}