package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(UserServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MealWithExceed> meals = new ArrayList<>();
        MealDao.mealList.forEach(meal -> meals.add(new MealWithExceed(meal.getDateTime(),
                meal.getDescription(),
                meal.getCalories(),
                meal.getCalories() > 500)));

        request.setAttribute("mealsList", MealsUtil.getFilteredWithExceeded(MealDao.mealList, LocalTime.MIN, LocalTime.MAX, 1500));
        log.debug("forward to meals.jsp");
        request.getRequestDispatcher("meals.jsp").forward(request, response);
    }
}
