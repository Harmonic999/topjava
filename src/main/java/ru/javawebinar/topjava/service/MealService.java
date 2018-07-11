package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealService {

    List<Meal> getAll(int userId);

    Meal get(int id, int userId);

    Meal save(Meal meal);

    void delete(int id, int userId);

}