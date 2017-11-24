package more;

public class MyEnums {
    public static void main(String[] args) {
        MyEnum myEnum = MyEnum.FIRST;
        System.out.println(myEnum + " " + myEnum.getAbbreviation() + myEnum.getNumb());
        myEnum = MyEnum.valueOf("SECOND");
        System.out.println(myEnum);
    }
}

enum MyEnum {
    FIRST("f", 1), SECOND("s", 2);
    private String abbreviation;
    int numb;

    MyEnum(String abbreviation, int numb) {
        this.abbreviation = abbreviation;
        this.numb = numb;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public int getNumb() {
        return numb;
    }
}