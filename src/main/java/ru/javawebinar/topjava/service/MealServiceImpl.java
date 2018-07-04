package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.dao.MealDaoImpl;
import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public class MealServiceImpl implements MealService {

    private MealDao mealDao = new MealDaoImpl();

    @Override
    public List<Meal> getMealList() {
        return mealDao.getMealList();
    }

    @Override
    public void add(Meal newMeal) {
        mealDao.add(newMeal);
    }

    @Override
    public void delete(int id) {
        mealDao.delete(id);
    }
}
