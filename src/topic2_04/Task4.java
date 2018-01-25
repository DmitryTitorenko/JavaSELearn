package topic2_04;

import java.util.Formatter;

/**
 * @author Dmitry Titorenko on 25.01.2018
 * <p>
 * 3.4 Форматированный вывод числа
 * <p>
 * Вывести число 100 в шестнадцатеричном и восьмеричном представлении.
 * Вывести числа в диапазоне от 100000 до 10000000 с шагом 100000 в формате, выбирающем более короткое представление.
 * Вывести 5 вещественных чисел, выровняв их по левому краю и задав ширину поля вывода 12, а точность – 4 знака после запятой.
 */
public class Task4 {
    public static void main(String[] args) {

        Formatter f = new Formatter();
        f.format("%x", 100);
        System.out.println("\nШестнадцатеричное представление\n" + f);

        f = new Formatter();
        f.format("%o", 100);
        System.out.println("\nВосьмеричное представление\n" + f);

        f = new Formatter();
        f.format("|%-12.4f|", 123.123);
        System.out.println("\nВыравниевание\n" + f);

        System.out.println("\nВывод использвуя наиболее короткое представление ");
        f = new Formatter();
        for (double i = 100000; i < 10000000; i += 100000) {
            f.format("%g", i);
            System.out.println(f);
            f = new Formatter();

        }
    }
}
