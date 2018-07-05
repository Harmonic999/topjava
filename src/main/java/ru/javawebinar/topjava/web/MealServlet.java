package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.service.MealServiceImpl;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Objects;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {

    private static final Logger log = getLogger(MealServlet.class);
    private MealService service = new MealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionPar = request.getParameter("action");

        if (actionPar != null && actionPar.equalsIgnoreCase("delete")) {
            int id = getId(request);
            service.delete(id);
            log.debug("Deleting meal with id=" + id);
            response.sendRedirect("meals");
        } else {
            request.setAttribute("mealsList", MealsUtil.getFilteredWithExceeded(service.getMealList(), LocalTime.MIN, LocalTime.MAX, 1500));
            request.getRequestDispatcher("meals.jsp").forward(request, response);
        }
    }

    private int getId(HttpServletRequest request) {
        return Integer.valueOf(Objects.requireNonNull(request.getParameter("meal_id")));
    }
}
