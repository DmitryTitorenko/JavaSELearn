package topic1_04;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Created by Dmitry Titorenko on 06.11.2015.
 */
public class All {
    public static void main(String[] args) {
        /*
        int [] a=new int[5];
        for (int i = 0; i <a.length; i++) {
            a[i]=i;
        }
        for (int i:a) {
            System.out.println(a[i]);
        }

        int []a1=new int[5];
        int []a2=new int[6];
        System.arraycopy(a,0,a1,0,a.length);
        Arrays.fill(a, 100);
        System.out.println(Arrays.toString(a));
        int [] a3=Arrays.copyOf(a,3);
        System.out.println(Arrays.toString(a3));
        int [] a4={5,1};
        int [] a5={5,0};
        System.out.println(Arrays.equals(a4,a5));
        int aq=0;
        int aqq=0;
        System.out.println(aq+""+aqq);
        String s = new Scanner(System.in).nextLine();
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
        */

        String a="a";
        String a1="a";
        String a2=new String ("a");
        System.out.println(a == a2);
        System.out.println(a.equals(a2));

    }
}
