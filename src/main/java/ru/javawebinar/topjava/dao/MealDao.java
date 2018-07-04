package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealDao {
    List<Meal> getMealList();
    void add(Meal newMeal);
    void delete(int id);
}