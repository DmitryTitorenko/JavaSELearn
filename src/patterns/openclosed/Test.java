package patterns.openclosed;

/**
 * @author Dmitry Titorenko on 07.03.2018
 * <p>
 * see http://blog.byndyu.ru/2009/10/blog-post_14.html
 */
public class Test {
    public static void main(String[] args) {
        Math math = new Math();
        math.sum(5, 5);
        math.write(new WriteDB());
    }
}
