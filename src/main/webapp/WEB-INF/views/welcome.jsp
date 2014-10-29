<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Hangman coding challange</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
        body { background-color: #eee; font: helvetica; }
        #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
    </style>
</head>
<body>
    <div id="container">
        <h1>Hangman</h1>

        <p> - The app should use jQuery and Ajax queries for interaction.</p>
        <p> - The app should keep the current game state persistent across server and browser re-starts.</p>
        <p> - The app should be built with "Ant/Maven" and produce a war file that can be deployed in a Tomcat instance.</p>
        <p> - The app should have a "Management page" that shows a summary of the state of all games that are currently being played.</p>

        <a href="startGame/<c:out value="${userId}"/>">New Games</a>

        <a href="resumeGame/<c:out value="${userId}"/>">Resume games</a>

        <a href="listGames/<c:out value="${userId}"/>">Show All Games</a>
    </div>
</body>
</html>