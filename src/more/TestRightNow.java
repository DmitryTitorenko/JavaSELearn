package more;

public class TestRightNow {


    public static void main(String[] args) {
        SubClass a=new SubClass();
        System.out.println(a.getA());
        SuperClass aa=new SuperClass();
        System.out.println(aa.getA());


    }
}

class SuperClass {
    public  void go(){

    }
    private int a;
    private int b;

    SuperClass(){

    }

    public int getA() {
        return this.a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static String getString() {
        return "Super Class";
    }

}

class SubClass extends SuperClass {
    public   void go(){

    }
    SubClass() {
        super.setA(20);
    }

    public static String getString() {
        return "Sub Class";
    }
}

class SubSubClass extends SuperClass {
    private int b;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        SubSubClass subSubClass = (SubSubClass) obj;


        return subSubClass.b == this.b && subSubClass.getA() == this.getA();
    }



}




