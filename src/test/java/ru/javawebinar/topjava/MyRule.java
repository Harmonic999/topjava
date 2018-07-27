package ru.javawebinar.topjava;

import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.util.Util;
import ru.javawebinar.topjava.web.meal.MealRestController;

public class MyRule implements TestRule {

    private static final Logger log = LoggerFactory.getLogger(MealRestController.class);

    @Override
    public Statement apply(Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                long startTime = System.nanoTime();
                statement.evaluate();
                long endTime = System.nanoTime();
                long timeTaken = endTime - startTime;
                log.debug(description.getMethodName() + " method test took " + Util.nanoToSeconds(timeTaken) + " ms");
            }
        };
    }
}
