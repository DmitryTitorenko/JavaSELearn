package more;

public class MyWildcardTypeVsGenericMethod {
    public static void main(String[] args) {
        WildcardType<String> wildcardType = new WildcardType<>();

        WildcardType<SubForWildcard1> subForWildcard1WildcardType = new WildcardType<>();
        wildcardType.setSubType(subForWildcard1WildcardType);

        WildcardType<SuperForWildcard> superForWildcardWildcardType = new WildcardType<>();
        wildcardType.setSuperType(superForWildcardWildcardType);

        wildcardType.setAnyType(subForWildcard1WildcardType);


    }
}


class WildcardType<T> {
    WildcardType wildcardType;

    public WildcardType getWildcardType() {
        return wildcardType;
    }

    /*
       Wildcard type
       WildcardType<? extends SuperForWildcard>
       denotes any generic WildcardType type whose type parameter is a subclass of SuperForWildcard
    */
    public void setSubType(WildcardType<? extends SuperForWildcard> subType) {
        this.wildcardType = subType;

    }

    public WildcardType<? extends SuperForWildcard> getSomeSubType() {
        return wildcardType;
    }


    /*
    Any generic WildCard type whose type parameter is a superclass of subForWildcard1
     */
    public void setSuperType(WildcardType<? super SubForWildcard1> superType) {
        this.wildcardType = superType;
    }


    public void setAnyType(WildcardType<?> anyType) {
        this.wildcardType = anyType;
        Object a = anyType.getWildcardType();
        //Integer i=anyType.getWildcardType();
    }


    public static <T extends Number> void myGenericMethod(WildcardType<T> dest, WildcardType<T> scr) {
        /*
        Here, you are ensured that both dest and src have same parameterized type for WildcardType.
         So, it's safe to copy elements from src to dest.
        */
    }

    public void myWildcard(WildcardType<? extends Number> dest, WildcardType<? extends Number> scr) {

        /*
        it won't work as expected. In 2nd case, you can pass WildcardType<Integer> and WildcardType<Float> as dest and src.
         So, moving elements from src to dest wouldn't be type safe anymore.
         */
    }

    /*
    Some other difference between using wildcards and type parameters are:

    - If you have only one parameterized type argument, then you can use wildcard, although type parameter will also work.
    - Type parameters support multiple bounds, wildcards don't.
    - Wildcards support both upper and lower bounds, type parameters just support upper bounds.
    So, if you want to define a method that takes a List of type Integer or it's super class, you can do:

    public void print(List<? super Integer> list)  // OK

    but you can't use type parameter:

     public <T super Integer> void print(List<T> list)  // Won't compile

     */


}


class SuperForWildcard {

}

class SubForWildcard1 extends SuperForWildcard {

}

class SubForWildcard2 extends SuperForWildcard {


}