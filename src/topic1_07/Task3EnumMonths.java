package topic1_07;

/*
3.3 Перечисление для описания месяцев года*
 Создать перечисление "Месяц".
 Необходимо определять в конструкторе и сохранять количество дней (для невисокосного года).
 Добавить методы получения предыдущего и следующего месяца, а также функцию, которая возвращает сезон для каждого месяца.
 Предусмотреть вывод месяцев на русском (украинском) языке.
 Создать статическую функцию вывода данных обо всех месяцах путем перекрытия метода toString().
 Протестировать перечисление в функции main() тестового класса.
 */

public class Task3EnumMonths {
    public static void main(String[] args) {
        Month month = Month.JANUARY;
        System.out.println(
                " Season: " + month.getSeason() +
                        " NameRus: " + month.getNameRUS() +
                        " Season: " + month.getSeason() +
                        " Precede: " + month.getPrecede() +
                        " Next: " + month.getNext());

        for (int i = 0; i < 11; i++) {
            System.out.println(Month.values()[i]);
        }
    }
}


enum Month {
    JANUARY(31, "январь", "winter"),
    FEBRUARY(28, "февраль", "winter"),
    MARCH(31, "март", "spring"),
    APRIL(30, "апрель", "spring"),
    MAY(31, "май", "spring"),
    JUNE(30, "июнь", "spring"),
    JULY(31, "июль", "summer"),
    AUGUST(31, "август", "summer"),
    SEPTEMBER(30, "сентябрь", "autumn"),
    OCTOBER(31, "октябрь", "autumn"),
    NOVEMBER(30, "ноябрь", "autumn"),
    DECEMBER(31, "декабрь", "winter");


    private int days;
    private String nameRUS;
    private String season;


    Month(int days, String nameRUS, String season) {
        this.days = days;
        this.nameRUS = nameRUS;
        this.season = season;


    }

    public Month getNext() {
        if (ordinal() == 11) {
            return values()[0];
        } else {
            return values()[ordinal() + 1];
        }
    }

    public Month getPrecede() {
        if (ordinal() == 0) {
            return values()[11];
        }
        return values()[ordinal() - 1];
    }

    public String getSeason() {
        return season;
    }

    public String getNameRUS() {
        return nameRUS;
    }


    @Override
    public String toString() {
        return "days: " + days + " nameRUS: " + nameRUS + " season: " + season;
    }
}
