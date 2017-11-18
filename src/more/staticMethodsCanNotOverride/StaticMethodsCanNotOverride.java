package more.staticMethodsCanNotOverride;

/*

You cannot override static method in Java because method overriding is based upon dynamic binding at runtime.
 Usually static methods are bonded using static binding at compile time before even program runs.

Static methods can not be overridden in the exact sense of the word, but they can hide parent static methods.
 In practice it means that  compiler will decide which method to execute at compile time, and not in runtime,
  as it does with overridden instance methods.

The distinction between hiding and overriding has important implications.
 The version of the overridden method that gets invoked is the one in the subclass.
  The version of the hidden method that gets invoked depends on whether it is invoked from the superclass or the subclass

My:
   When we use dynamic binding, method, witch will be invoke depend from object, which refers current object variable,
    as this variable can refer not only on object, witch type she create, but any subclass object
    => we don't know beforehand which method will be invoke
     as static method don't depend from object variable, she depend only from class, in witch she invoke
      we always know, which method will be invoke => we use static binding

   When we use dynamic binding, method, witch will be invoke depend from object
    Static binding use with private, static, final method
 */
public class StaticMethodsCanNotOverride {

    public static void main(String[] args) {

        /*
        Hiding - Parent class methods that are static are not part of a child class
         (although they are accessible), so there is no question of overriding it.
          Even if you add another static method in a subclass,
          identical to the one in its parent class, this subclass static method is unique
           and distinct from the static method in its parent class.
         */

        SubClass subClass = new SubClass();
        System.out.println(subClass.getString()); //Hiding

        //call class method, not instance method (static binding); method call is decided at compile time
        SuperClass superClass = new SubClass();
        System.out.println(superClass.getString());

        System.out.println(SuperClass.getString());//call class method too
    }
}

class SuperClass {
    SuperClass() {
    }

    public static String getString() {
        return "Super Class";
    }
}

class SubClass extends SuperClass {
    SubClass() {
    }

    public static String getString() {
        return "Sub Class";
    }
}


