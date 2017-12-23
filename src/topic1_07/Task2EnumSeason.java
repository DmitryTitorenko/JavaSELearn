package topic1_07;

/*
3.2 Перечисление для представления сезона*
Создать перечисление "Сезон". Описать метод получения предыдущего и последующего сезона.
Протестировать перечисление в функции main() тестового класса.
 */

public class Task2EnumSeason {
    public static void main(String[] args) {
        Season season = Season.WINTER;
        System.out.println(season.getNext());
        System.out.println(season.getPrecede());
    }
}

enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;

    public Season getNext() {
        if (ordinal() == 3) {
            return values()[0];
        } else {
            return values()[ordinal() + 1];
        }
    }

    public Season getPrecede() {
        if (ordinal() == 0) {
            return AUTUMN;
        } else {
            return values()[ordinal() + 1];
        }
    }
}
