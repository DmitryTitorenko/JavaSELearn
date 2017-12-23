package topic1_07;

/*
3.1 Перечисление для представления дней недели
В перечислении "День недели" добавить функции получения дня "позавчера" и "послезавтра".
Протестировать перечисление в функции main() тестового класса.
 */

public class Task1EnumDayOfWeek {
    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.MONDAY;
        System.out.println(dayOfWeek.theDayBeforeYesterday());
        System.out.println(dayOfWeek.theDayAfterTomorrow());
    }
}

enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    public DayOfWeek theDayBeforeYesterday() {
        if (this.ordinal() == 1) {
            return DayOfWeek.values()[6]; // values() == DayOfWeek.values()
        } else if (ordinal() == 0) {
            return values()[5];
        } else {
            return values()[ordinal() - 2];
        }
    }

    public DayOfWeek theDayAfterTomorrow() {
        if (ordinal() == 6) {
            return FRIDAY;
        } else if (ordinal() == 5) {
            return MONDAY;
        } else {
            return values()[ordinal() + 2];
        }
    }
}
