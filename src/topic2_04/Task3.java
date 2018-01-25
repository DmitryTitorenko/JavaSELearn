package topic2_04;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * @author Dmitry Titorenko on 25.01.2018
 * <p>
 * 3.3 Прохождение строки в обратном порядке*
 * <p>
 * Осуществить с помощью итератора прохождение строки от заданного индекса к началу строки.
 */
public class Task3 {
    public static void main(String[] args) {
        int index = 3;
        CharacterIterator it = new StringCharacterIterator("1 2 3 4 5");
        for (char ch = it.setIndex(index); ch != CharacterIterator.DONE; ch = it.previous()) {
            System.out.print(ch);
        }
    }
}
