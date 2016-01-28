package topic1_05;

/**
 * Created by Dmitry Titorenko on 08.01.2016.
 * <p>
 * наследование - использование обьектов дочернего класса как обьект базового класса
 * обьект подкласса можно использовать вместо любого обьекта суперкласса
 */
public class Inheritance {
    public static void main(String[] args) {
        //обьектная переменная суперкласса может ссылатся на любой обьект подкласса
        People people = new Student(15, "do");
        //способность переменной ссылаться на обьекты, имеющие разные фактические типы называется полиморфизмом
        //вызывается метод, соответствующий фактическому типу обьекта, на который ссылается переменная people (обьект Student)
        System.out.println(people.getId());

        //приведение типов
        Student s;

        s = (Student) people;//работает т.к. people ссылается на обьект Student
        System.out.println(s.getGroup());


        People people1 = new People(10);
        /*
        s = (Student) people1;// не работает, т.к. people1 ссылается на обьект People
        System.out.println(s.getGroup());
        */

        // что бы не было ошибок нужно проверить корректность вызова метода: ссылается ли people1 на Student
        if (people1 instanceof Student) {
            System.out.println(((Student) people1).getGroup());
        } else {
            System.out.println("people1 ! instanceof  Student ");
        }
    }
}

class People {
    protected int idPeople;

    public People(int idPeople) {
        this.idPeople = idPeople;
    }

    public int getId() {
        return this.idPeople;
    }
}

class Student extends People {
    private String group;

    public Student(int idStudent, String group) {
        super(idStudent);//вызов конструктора суперкласса People с параметром idPeople
        this.group = group;
    }

    @Override
    public int getId() {
        return super.getId() + 10;
    }

    public String getGroup() {
        return this.group;
    }
}

