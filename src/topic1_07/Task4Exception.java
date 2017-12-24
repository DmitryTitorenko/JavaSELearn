package topic1_07;

/*
3.4 Функция вычисления корня четвертой степени*

Создать класс со статической функцией вычисления корня четвертой степени из действительного числа и вложенным статическим классом-исключением.
 Функция должна генерировать исключение, если аргумент отрицателен. Объект-исключение должен сохранять неверное значение аргумента.
  Протестировать функцию с перехватом исключения.
 */

public class Task4Exception {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        try {
            System.out.println(Exception4Sqrt.solve(-100));

        } catch (Exception4Sqrt.MyNotNullException e) {
            e.printError();
        }
    }
}


class Exception4Sqrt {
    public static double solve(double a) throws MyNotNullException {
        if (a < 0) {
            throw new MyNotNullException(a);
        } else {
            for (int i = 0; i < 4; i++) {
                a = Math.sqrt(a);
            }
        }
        return a;
    }

    static class MyNotNullException extends Exception {
        private double a;

        public void printError() {
            System.out.println("a = " + a + "  a<0");
        }

        public MyNotNullException(double a) {
            this.a = a;
        }
    }
}
