package more;

public class BitwiseOperators {
    public static void main(String args[]) {

        /*
        Why when we apply >>> to  byte 10000001 get result  11000000, not 01000000?
        1)   widens its arguments to int
         11111111111111111111111110000001

        2)  use >>>
        01111111111111111111111111000000

        3) take the last 8 bits as a cast to byte
        11000000
        which is -64.

        sourse
         jls-5.6.1 Unary Numeric Promotion
         Otherwise, if the operand is of compile-time type byte, short, or char, it is promoted to a value of type int by a widening primitive conversion (§5.1.2).
         */

        System.out.println();
        byte b11 = (byte) 0b10000001;
        toBits(b11);
        System.out.println(b11);
        System.out.println();

        b11 = (byte) (b11 >>> 1);
        toBits(b11);
        System.out.println(b11);
        System.out.println();
    }

    private static void toBits(byte b) {
        String result = "";

        for (int i = 7; i >= 0; i--) {
            result += (byte) (1 & (b >> i));
        }
        System.out.println(result);
    }
}


