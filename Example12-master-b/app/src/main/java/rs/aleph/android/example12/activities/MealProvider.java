package rs.aleph.android.example12.activities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ljubisa on 31.01.2018..
 */

public class MealProvider {

    public static List<Meal> getMeals() {

        Category SIDE_DISH = new Category(0, "SIDE_DISH");
        Category MAIN_DISH = new Category(1, "MAIN_DISH");
        Category DESERT = new Category(2, "DESERT");

        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal(0,"roasted-baby-spring-vegetables-ck.jpg", "Vegetables", "Roasted spring vegetables", "Potatoes, carrots, seasonal vegetables", 320, 470.0, SIDE_DISH));
        meals.add(new Meal(1, "Grilled-Salmon.jpg", "Grilled salmon", "Grilled salmon fish with grilled vegetables","Fish, olive oil, vegetables", 650, 1500.0, MAIN_DISH));
        meals.add(new Meal(2, "chocolat-cake.jpg", "Chocolat cake", "Crispy bark with chocolate cream", "Chocolate, butter, nuts", 1000, 400.0, DESERT));
        meals.add(new Meal(3,"pizza.jpg", "Pizza", "Italian pizza", "Vegetables, kechup", 500, 320.55, SIDE_DISH));
        meals.add(new Meal(4, "hamburger.jpg", "Hamburger", "American food","Meat, bread", 250, 150.65, SIDE_DISH));
        meals.add(new Meal(5, "voce.jpg", "Fruit", "Fruits", "Appels, oranges", 200, 120.0,DESERT));
        return meals;
    }
    public static List<String> getMealNames() {

        List<String> names = new ArrayList<>();
        names.add("Vegetables");
        names.add("Grilled salmon");
        names.add("Chocolat cake");
        names.add("Pizza");
        names.add("Hamburger");
        names.add("Fruit");
        return names;
    }

    public static Meal getMealById(int id) {

        Category SIDE_DISH = new Category(0, "SIDE_DISH");
        Category MAIN_DISH = new Category(1, "MAIN_DISH");
        Category DESERT = new Category(2, "DESERT");

        switch (id) {
            case 0:
                return new Meal(0, "roasted-baby-spring-vegetables-ck.jpg", "Vegetables", "Roasted spring vegetables", "Potatoes, carrots, seasonal vegetables", 320, 470.0, SIDE_DISH);
            case 1:
                return new Meal(1, "Grilled-Salmon.jpg", "Grilled salmon", "Grilled salmon fish with grilled vegetables","Fish, olive oil, vegetables", 650, 1500.0, MAIN_DISH);
            case 2:
                return new Meal(2, "chocolat-cake.jpg", "Chocolat cake", "Crispy bark with chocolate cream", "Chocolate, butter, nuts", 1000, 400.0, DESERT );
            case 3:
                return  new Meal(3,"pizza.jpg", "Pizza", "Italian pizza", "Vegetables, kechup", 500, 320.55, SIDE_DISH);
            case 4:
                return  new Meal(4, "hamburger.jpg", "Hamburger", "American food","Meat, bread", 250, 150.65, SIDE_DISH);
            case 5:
                return  new Meal(5, "voce.jpg", "Fruit", "Fruits", "Appels, oranges", 200, 120.0,DESERT);
            default:
                return null;
        }
    }

}
