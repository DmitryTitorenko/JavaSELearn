package topic1_05;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 01.02.2016.
 * Иерархия классов
 * Реализовать классы "Человек", "Гражданин", "Сотрудник". "Сотрудник на ставке", "Сотрудник с почасовой оплатой".
 * Создать массив ссылок на различные объекты иерархии. Для каждого объекта вывести на экран строку данных о нем.
 * В классе сотрудник определить абстрактную функцию "Начисление зарплаты за месяц".
 * В классе "Сотрудник на ставке" описать поля "Ставка" и "Процент премии",
 * а в классе "Сотрудник с почасовой оплатой" - поля "Часовая оплата" "Количество проработанных часов".
 * Значения полей задавать в конструкторах. Создать массив сотрудников различных типов.
 * Для всех сотрудников начислить и вывести заработную плату.
 */
public class Task7ClassHierarchy {
    public static void main(String[] args) {
        EmployeeAtRate employeeAtRate = new EmployeeAtRate(1001, 500, 5);
        System.out.println(employeeAtRate);
        System.out.println("salaryForMonth:" + employeeAtRate.salaryForMonth());
        EmployeeAtHourlyRate employeeAtHourlyRate = new EmployeeAtHourlyRate(1002, 20, 120);
        System.out.println(employeeAtHourlyRate);
        System.out.println("salaryForMonth:" + employeeAtHourlyRate.salaryForMonth());
        MyHuman[] myHumans = new MyHuman[10];
        myHumans[0] = employeeAtHourlyRate;
        myHumans[1] = employeeAtRate;
        myHumans[2] = new Citizen(1212);
        myHumans[3] = new MyHuman(1414);
        System.out.println(Arrays.toString(myHumans));
    }
}

class MyHuman {
    private int id;

    public MyHuman(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id:" + id;
    }
}

class Citizen extends MyHuman {

    public Citizen(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "id:" + getId();
    }
}

abstract class Employee extends Citizen {

    public Employee(int id) {
        super(id);
    }

    public abstract int salaryForMonth();
}

class EmployeeAtRate extends Employee {
    private int rate;//ставка
    private int percent;

    EmployeeAtRate(int id, int rate, int percent) {
        super(id);
        this.rate = rate;
        this.percent = percent;
    }

    @Override
    public int salaryForMonth() {
        return rate + rate / 100 * percent;
    }

    @Override
    public String toString() {
        return "id:" + getId() + " rate:" + rate + " percent:" + percent;
    }
}

class EmployeeAtHourlyRate extends Employee {
    private int salaryForHour;
    private int countHour;

    public EmployeeAtHourlyRate(int id, int salaryForHour, int countHour) {
        super(id);
        this.salaryForHour = salaryForHour;
        this.countHour = countHour;
    }

    @Override
    public int salaryForMonth() {
        return this.salaryForHour * this.countHour;
    }

    @Override
    public String toString() {
        return "id:" + getId() + " salary for hour:" + salaryForHour + " cont hour:" + countHour;
    }
}

