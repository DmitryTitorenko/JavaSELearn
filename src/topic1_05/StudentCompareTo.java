package topic1_05;

import java.util.Arrays;

/**
 * Created by Dmitry Titorenko on 23.01.2016.
 */

public class StudentCompareTo implements Comparable {
    public int student_id;
    public String last_name;
    public String first_name;

    public StudentCompareTo(int student_id, String last_name, String first_name) {
        this.student_id = student_id;
        this.last_name = last_name;
        this.first_name = first_name;
    }

  /* Перегрузка метода compareTo */

    public int compareTo(Object obj) {
        StudentCompareTo tmp = (StudentCompareTo) obj;
        if (this.student_id < tmp.student_id) {
      /* текущее меньше полученного */
            return -1;
        } else if (this.student_id > tmp.student_id) {
      /* текущее больше полученного */
            return 1;
        }
    /* текущее равно полученному */
        return 0;
    }

    public static void main(String[] args) {
  /* Создание массива объектов Student */

        StudentCompareTo[] students = new StudentCompareTo[3];
        students[0] = new StudentCompareTo(52645, "Smith", "Bob");
        students[1] = new StudentCompareTo(98765, "Jones", "Will");
        students[2] = new StudentCompareTo(1354, "Johnson", "Matt");

  /* Сортировка массива */
        Arrays.sort(students);

  /* Печать отсортированных значений */

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].student_id +
                    students[i].last_name + students[i].first_name);
        }
    }
}
