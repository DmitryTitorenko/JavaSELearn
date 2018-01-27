package topic2_04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Dmitry Titorenko on 27.01.2018
 * <p>
 * 3.8 Проверка формы адреса е-mail*
 * <p>
 * Написать программу, которая проверяет введенную строку на соответствие формату адреса электронной почты.
 * Формат адреса должен соответствовать следующим правилам. Первым должно идти имя учетной записи.
 * Оно начинается с буквы латинского алфавита, после которой могут следовать другие символы латинского алфавита,
 * цифры, знак подчеркивания, затем символ "@", после него имя сервера.
 * Имя сервера должно состоять из нескольких частей (минимум двух), разделенных точками.
 * Последняя часть имени сервера – это имя домена первого уровня.
 * Оно может состоять только из букв латинского алфавита.
 */
public class Task8RegularExpression {
    public static void main(String[] args) {
        String test = "od@ws.com";
        checkFromPattern(test);
    }

    /**
     * Check is string validate from regular expression
     *
     * @param test string witch need to check.
     */

    public static void checkFromPattern(String test) {

        /*
        [a-zA-Z]{1} - one word should be letter
        [a-zA-Z0-9_] - random length of letter and number
        \\@ - symbol @
        [a-z] - letter from low register
        \\. - symbol "."
         */
        Pattern p = Pattern.compile("[a-zA-Z]{1}+[a-zA-Z0-9_]+\\@[a-z\\.a-z]+");
        Matcher m = p.matcher(test);
        if (m.matches()) {
            System.out.println("correct");
        } else {
            System.out.println("not");
        }
    }
}
