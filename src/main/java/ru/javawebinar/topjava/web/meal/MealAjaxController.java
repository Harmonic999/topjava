package ru.javawebinar.topjava.web.meal;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/ajax/profile/meals")
public class MealAjaxController extends AbstractMealController {

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        super.delete(id);
    }

    @PostMapping
    public void createOrUpdateMeal(@RequestParam("id") Integer id,
                                   @RequestParam("dateTime")
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime,
                                   @RequestParam("description") String description,
                                   @RequestParam("calories") Integer calories) {
        Meal meal = new Meal(id, dateTime, description, calories);
        if (meal.isNew()) {
            super.create(meal);
        } else {
            super.update(meal, id);
        }
    }

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MealWithExceed> getBetween(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(value = "startDate", required = false)
                    LocalDate startDate,

            @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
            @RequestParam(value = "startTime", required = false)
                    LocalTime startTime,

            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @RequestParam(value = "endDate", required = false)
                    LocalDate endDate,

            @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
            @RequestParam(value = "endTime", required = false)
                    LocalTime endTime) {

        return super.getBetween(startDate, startTime, endDate, endTime);
    }
}
