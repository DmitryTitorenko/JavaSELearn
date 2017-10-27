package topic1_05;

import java.util.Arrays;

public class TestStrinegBuilder {
    public static void main(String[] args) {
        int balance[][] = new int[5][3];
        System.out.println(Arrays.deepToString(balance));
        int sum = 1;
        for (int i = 0; i < balance.length; i++) {
            if (i == 0) {
                for (int j = 0; j < balance[i].length; j++) {
                    balance[i][j] = sum;
                    sum++;
                }
            } else {
                for (int j = 0; j < balance[i].length; j++) {
                    if (j == 0) {
                        balance[i][j] = balance[i - 1][j] + 1;
                    } else {
                        balance[i][j] = balance[i][j - 1] + balance[i - 1][j];
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(balance));
    }
}
