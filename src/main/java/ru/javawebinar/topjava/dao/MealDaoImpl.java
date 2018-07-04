package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealDaoImpl implements MealDao {

    private final List<Meal> mealList;

    public MealDaoImpl() {
        mealList = new ArrayList<>();
        add(new Meal(LocalDateTime.of(2018, 6, 2, 8, 30), "завтрак", 600));
        add(new Meal(LocalDateTime.of(2018, 6, 2, 12, 0), "обед", 1000));
        add(new Meal(LocalDateTime.of(2018, 6, 2, 17, 0), "ужин", 300));
        add(new Meal(LocalDateTime.of(2018, 6, 3, 8, 30), "завтрак", 600));
        add(new Meal(LocalDateTime.of(2018, 6, 3, 12, 30), "обед", 300));
        add(new Meal(LocalDateTime.of(2018, 6, 3, 17, 30), "ужин", 600));
        add(new Meal(LocalDateTime.of(2018, 6, 4, 8, 30), "завтрак", 500));
        add(new Meal(LocalDateTime.of(2018, 6, 4, 12, 30), "обед", 500));
        add(new Meal(LocalDateTime.of(2018, 6, 4, 17, 30), "ужин", 500));
    }

    @Override
    public List<Meal> getMealList() {
        return mealList;
    }

    @Override
    public void add(Meal newMeal) {
        mealList.add(newMeal);
        newMeal.setId(mealList.size());
    }

    @Override
    public void delete(int id) {
        mealList.remove(--id);
        updateIds(id);
    }

    private void updateIds(int id) {
        for (int i = id; i < mealList.size(); i++) {
            mealList.get(i).setId(i + 1);
        }
    }
}
