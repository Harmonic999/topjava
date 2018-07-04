package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealService {
    List<Meal> getMealList();
    void add(Meal newMeal);
    void delete(int id);
}