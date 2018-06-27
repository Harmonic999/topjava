package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 1500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 12, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 900),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );

        List<UserMealWithExceed> list = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
        for (UserMealWithExceed exceed : list) {
            System.out.println(exceed);
        }
    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate, Integer> dateTotalCaloriesMap = new HashMap<>();
        List<UserMeal> filteredMealList = new ArrayList<>();
        List<UserMealWithExceed> result = new ArrayList<>();

        for (UserMeal userMeal : mealList) {
            LocalTime time = userMeal.getDateTime().toLocalTime();
            if (TimeUtil.isBetween(time, startTime, endTime)) {
                LocalDate date = userMeal.getDateTime().toLocalDate();
                int mealCalories = userMeal.getCalories();
                int sumDayCalories = dateTotalCaloriesMap.getOrDefault(date, mealCalories);
                dateTotalCaloriesMap.merge(date, sumDayCalories, (oldValue, newValue) -> oldValue + mealCalories);
                filteredMealList.add(userMeal);
            }
        }

        for (UserMeal userMeal : filteredMealList) {
            UserMealWithExceed newMealWithExceed = new UserMealWithExceed(userMeal.getDateTime(),
                    userMeal.getDescription(),
                    userMeal.getCalories(),
                    dateTotalCaloriesMap.get(userMeal.getDateTime().toLocalDate()) > caloriesPerDay);
            result.add(newMealWithExceed);
        }

        return result;
    }
}
