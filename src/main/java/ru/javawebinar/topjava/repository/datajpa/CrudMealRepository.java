package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional(readOnly = true)
public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Query("SELECT m FROM Meal m WHERE " +
            "m.user.id=:userId ORDER BY m.dateTime DESC")
    List<Meal> findAll(@Param("userId") int userId);

    @Query("SELECT m FROM Meal m WHERE " +
            "m.user.id=:userId AND m.dateTime>=:startTime AND m.dateTime<=:endTime " +
            "ORDER BY m.dateTime DESC")
    List<Meal> getBetween(@Param("startTime") LocalDateTime startTime,
                          @Param("endTime") LocalDateTime endTime,
                          @Param("userId") int userId);

    @Override
    @Transactional
    Meal save(Meal meal);

    @Query("SELECT m FROM Meal m WHERE m.id=:id AND m.user.id=:userId")
    Optional<Meal> findById(@Param("id") int id, @Param("userId") int userId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Meal m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id") int id, @Param("userId") int userId);

    @Transactional
    @Modifying
    @Query("UPDATE Meal SET " +
            "description=:description, dateTime=:dateTime, calories=:calories " +
            "WHERE id=:id")
    void update(@Param("description") String description,
                @Param("dateTime") LocalDateTime dateTime,
                @Param("calories") int calories,
                @Param("id") int id);
}
