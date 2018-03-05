package patterns.builder;

/**
 * @author Dmitry Titorenko on 05.03.2018
 */
public interface Item {
     String name();

     Packing packing();

     float price();
}
