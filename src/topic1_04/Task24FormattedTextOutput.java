package topic1_04;

/**
 * Created by Dmitry Titorenko on 26.12.2015.
 * <p>
 * Форматированный вывод текста
 * <p>
 * Осуществить форматирование текста с выравниванием по ширине.
 * Текст разбить на строки с длиной, не превосходящей заданного количества символов.
 * Если очередное слово не помещается в текущей строке, его необходимо переносить на следующую.
 */
public class Task24FormattedTextOutput {
    public static void main(String[] args) {
        String st = " Абстракция — это мощнейшее средство программирования. Именно то, что позволяет нам строить большие системы и поддерживать контроль над ними. Вряд ли мы когда-либо подошли бы хотя бы близко к сегодняшнему уровню программ, если бы не были вооружены таким инструментом. Однако как абстракция соотносится с ООП? ";
        max30Length(st);

        int a = 30;
        int a0 = 0;
        int lastSpace = 0;
        int lastSpaceAll = 0;
        String newStr;
        for (int i = 30; i < st.length(); i += lastSpace) {
            if (i == 30) {
                a = 30;
            } else {
                a += lastSpace;
            }
            if (i == a) {
                String ee = st.substring(a0, a);
                lastSpace = ee.lastIndexOf(" ");
                System.out.println(lastSpace);
                if (i == 30) {
                    newStr = st.substring(a0, lastSpace);
                    System.out.println(newStr);
                    lastSpaceAll += lastSpace;
                } else {
                    newStr = st.substring(a0, lastSpaceAll += lastSpace);
                    System.out.println(newStr);
                }
            }
            a0 += lastSpace;
        }
    }

    //Alternative
    private static void max30Length(String st) {
        String[] arrayString = st.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i].length() + stringBuilder.length() > 30) {
                System.out.println(stringBuilder);
                stringBuilder.delete(0, stringBuilder.length() - 1);
                i--;
            } else {
                stringBuilder.append(arrayString[i] + " ");
            }
        }
    }
}
