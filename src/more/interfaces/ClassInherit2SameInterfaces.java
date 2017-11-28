package more.interfaces;

public class ClassInherit2SameInterfaces implements I2, I3, I4 {
    public static void main(String[] args) {
        ClassInherit2SameInterfaces cl = new ClassInherit2SameInterfaces();
        cl.foo();
        I2.staticMethod();
        System.out.println(I2.PI);
    }

    @Override
    public void foo() {
        //I2.super.foo();// don't work
        /*
        If TypeName denotes an interface, let T be the type declaration immediately enclosing the method invocation.
         A compile-time error occurs if there exists a method, distinct from the compile-time declaration,
          that overrides (§9.4.1) the compile-time declaration from a direct superclass or direct superinterface of T.

        In the case that a superinterface overrides a method declared in a grandparent interface,
         this rule prevents the child interface from "skipping" the override by simply adding
          the grandparent to its list of direct superinterfaces.
           The appropriate way to access functionality of a grandparent is through the direct superinterface,
            and only if that interface chooses to expose the desired behavior.

         */
        I3.super.foo();
        I4.super.foo();

    }
}

interface I1 {
    double PI = 3.14;

    void foo();
}

interface I2 extends I1 {
    default void foo() {
        System.out.println("I2");
    }

    static void staticMethod() {
        System.out.println("I2 static method");
    }
}

interface I3 extends I2 {
    @Override
    default void foo() {
        System.out.println("I3");
    }
}

interface I4 {
    default void foo() {
        System.out.println("I4");
    }
}



