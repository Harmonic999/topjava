package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.util.ArrayList;
import java.util.List;

public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository repository;

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(repository.getAll());
    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public Meal save(Meal meal) {
        return repository.save(meal);
    }

    @Override
    public void delete(int id) {
        repository.delete(id);
    }
}