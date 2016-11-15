package topic1_05;

/**
 * Created by GrinWey on 14.11.2016.
 */
public class MyCharType {
    public static void main(String[] args) {
        //System.out.println(a+"go\n sdf");
        System.out.println("She said \"Hello!\" to me.");//escape sequences
        System.out.println("\u0022+\u0022");//Unicode escape sequences are processed before the code is parsed
        /*
        // \u000a is a newline
        */

        //exception
        // Look inside c:\0users


        System.out.println(gochar('+'));
    }
    public static int gochar(Character e) {
        return 10 + e + 5;
    }
}
