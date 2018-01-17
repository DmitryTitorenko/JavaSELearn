package topic2_02;

/*
3.6 Данные о пользователях*

Представить данные о пользователях в виде ассоциативного массива (имя / пароль) с предположением,
что все имена пользователей разные. Вывести данные о пользователях с длиной пароля более 6 символов.
 */

import java.util.HashMap;
import java.util.Map;

public class Task6Map {
    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        users.put("user1", "1234567");
        users.put("user2", "12345");
        System.out.println(getName(users));
    }

    public static String getName(Map<String, String> users) {
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, String> stringStringEntry : users.entrySet()) {
            if (stringStringEntry.getValue().length() > 6) {
                stringBuilder.append(stringStringEntry.getKey());
            }
        }
        return stringBuilder.toString();
    }
}
