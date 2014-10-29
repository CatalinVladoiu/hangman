<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>List of all games from DB</title>
        <style>
            body { background-color: #eee; font: helvetica; }
            #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
        </style>
    </head>

    <body>
        <div id="container">
            <ul>
                <c:forEach items="${games}" var="game">
                    <li>Game status: <c:out value="${game.gameStatus}" />; Word which had to be guessed: <c:out value="${game.syllabus.phrase}"/></li>
                </c:forEach>
            </ul>

            <%--
            <ul>
                <li>
                    <a href="/<c:out value="${userId}"/>">Back to home page.</a>
                </li>
            </ul>
            --%>
        </div>
    </body>
</html>