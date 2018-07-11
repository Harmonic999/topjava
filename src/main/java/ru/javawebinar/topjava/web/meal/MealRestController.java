package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

@Controller
public class MealRestController {

    private MealService service;

    @Autowired
    public MealRestController(MealService service) {
        this.service = service;
    }

    public List<Meal> getAll(int userId) {
        return service.getAll(userId);
    }

    public Meal get(int id, int userId) {
        return service.get(id, userId);
    }

    public Meal save(Meal meal) {
        return service.save(meal);
    }

    public void delete(int id, int userId) {
        service.delete(id, userId);
    }

}