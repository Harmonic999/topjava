<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Meals</title>
    <style type="text/css">
        TABLE {
            width: max-content; /* Ширина таблицы */
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
            text-align: center;
            font-size: 20px;
        }
        TD, TH {
            padding: 6px; /* Поля вокруг содержимого таблицы */
            border: 1px solid black; /* Параметры рамки */
        }
        TH {
            background: #c0e3e6; /* Цвет фона */
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Date</th>
            <th>Meal</th>
            <th>Calories</th>
            <th>Exceeded</th>
        </tr>
        <c:forEach items="${mealsList}" var="meal">
            <tr>
                <td><a>${meal.stringDateTime}</a></td>
                <td><a>${meal.description}</a></td>

                <c:if test="${meal.exceed}">
                    <td><a style="color: red">${meal.calories}</a></td>
                </c:if>

                <c:if test="${not meal.exceed}">
                    <td><a style="color: green">${meal.calories}</a></td>
                </c:if>

                <td><a>${meal.exceed}</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
