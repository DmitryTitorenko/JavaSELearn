package patterns.creational.builder;

/**
 * @author Dmitry Titorenko on 05.03.2018
 * <p>
 * Builder pattern builds a complex object using simple objects and using a step by step approach.
 * This type of design pattern comes under creational pattern as this pattern provides one of the
 * best ways to create an object.
 * <p>
 * A Builder class builds the final object step by step.
 * This builder is independent of other objects.
 * <p>
 * see https://www.tutorialspoint.com/design_pattern/builder_pattern.htm
 */
public class BuilderDemo {
    public static void main(String[] args) {

        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}
