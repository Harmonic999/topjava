package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MealDao {

    public static final List<Meal> mealList;

    static {
        mealList = new ArrayList<>();
        mealList.add(new Meal(LocalDateTime.of(2018, 6, 2, 8, 30), "завтрак", 600));
        mealList.add(new Meal(LocalDateTime.of(2018, 6, 2, 12, 0), "обед", 1000));
        mealList.add(new Meal(LocalDateTime.of(2018, 6, 2, 17, 0), "ужин", 300));
        mealList.add(new Meal(LocalDateTime.of(2018, 6, 3, 8, 30), "завтрак", 600));
        mealList.add(new Meal(LocalDateTime.of(2018, 6, 3, 12, 30), "обед", 300));
        mealList.add(new Meal(LocalDateTime.of(2018, 6, 3, 17, 30), "ужин", 600));
        mealList.add(new Meal(LocalDateTime.of(2018, 6, 4, 8, 30), "завтрак", 500));
        mealList.add(new Meal(LocalDateTime.of(2018, 6, 4, 12, 30), "обед", 500));
        mealList.add(new Meal(LocalDateTime.of(2018, 6, 4, 17, 30), "ужин", 500));
    }


}
