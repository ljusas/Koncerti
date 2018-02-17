package com.example.fujitsu.mojprojekat.activity.providers;

import com.example.fujitsu.mojprojekat.activity.modeli.Category;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ljubisa on 31.01.2018..
 */

public class CategoryProvider {

    public static List<Category> getCategories() {

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "SIDE_DISH"));
        categories.add(new Category(1, "MAIN_DISH"));
        categories.add(new Category(2, "DESERT"));
        return categories;
    }

    public static List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        names.add("SIDE_DISH");
        names.add("MAIN_DISH");
        names.add("DESERT");
        return names;
    }

    public static Category getCategoryById(int id) {
        switch (id) {
            case 0:
                return new Category(0, "SIDE_DISH");
            case 1:
                return new Category(1, "MAIN_DISH");
            case 2:
                return new Category(2, "DESERT");
            default:
                return null;
        }
    }
}
