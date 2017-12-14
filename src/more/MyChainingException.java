package more;

/*
     Java program to demonstrate working of chained exceptions

Chained Exceptions allows to relate one exception with another exception, i.e one exception describes cause of
 another exception. For example, consider a situation in which a method throws an ArithmeticException because of
  an attempt to divide by zero but the actual cause of exception was an I/O error which caused the divisor to be zero.
  The method will throw only ArithmeticException to the caller. So the caller would not come to know about the actual
   cause of exception. Chained Exception is used in such type of situations.

    getCause() method - This method returns actual cause of an exception.
    initCause(Throwable cause) method :- This method sets the cause for the calling exception.

 */

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyChainingException {

    /*
A logger tha is not referenced by any variable can be garbage collected.
To prevent this, save a reference to the logger with a static variable, as in the example above.
 */
    private static final Logger myLogger = Logger.getLogger(MyChainingException.class.getName());

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            try {
                chainingException();
            } catch (Exception e) {

                // displaying the exception
                System.out.println(e);

                // Getting the actual cause of the exception
                System.out.println(e.getCause());

                myLogger.log(Level.INFO, "Exception", e);

            } finally {
                System.out.println("finally");
            }
        } catch (Exception e) {
            System.out.println();
        }
        System.out.println("after exception");
        myLogger.info("my Log Info");
    }

    public static void chainingException() throws NullPointerException {

        // Creating an exception
        NullPointerException exception = new NullPointerException("Exception");

        // Setting a cause of the exception
        exception.initCause(new ArithmeticException("This is actual cause of the exception, why this exception really occur"));

        // Throwing an exception with cause.
        throw exception;
    }
}