package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

public class MealRestController {

    @Autowired
    private MealService service;

    public List<Meal> getAll() {
        return service.getAll();
    }

    public Meal get(int id) {
        return service.get(id);
    }

    public Meal save(Meal meal) {
        return service.save(meal);
    }

    public void delete(int id) {
        service.delete(id);
    }

}