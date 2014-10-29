<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Game started</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
        body { background-color: #eee; font: helvetica; }
        .container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
    </style>
</head>
<body>
        <div id="container" class="container">
            <ul>
                <li>
                    Number of allowed attempts: <span id="maxAttemptsField"><c:out value="${game.maxAttempts}" /></span>
                </li><br/> <br/>
                <li>
                    Failed number of attempts:<span id="failedAttemptsField"> <c:out value="${fn:length(game.failedAttempts)}" /></span> <br/>
                    Failed letters:
                        <span id="failedLettersField">
                            <c:forEach items="${game.failedAttempts}" var="failedAttempt">
                               <c:out value="${failedAttempt}" />
                            </c:forEach>
                        </span>
                </li> <br/> <br/>
                <li>
                    Correct attempts: <span id="correctAttemptsField"> <c:out value="${fn:length(game.correctAttempts)}" /></span> <br/>
                    Correct letters:
                        <span id="correctLettersField">
                            <c:forEach items="${game.correctAttempts}" var="correctAttempt">
                               <c:out value="${correctAttempt}" />
                            </c:forEach><br/>
                        </span>
                </li> <br/> <br/>
                <li>
                    Guess the following word:<br/><br/>
                        <span id="wordToGuessField">
                            <c:forEach items="${game.displayPhrase}" var="letter">
                               <c:out value="${letter}" />
                            </c:forEach>
                        </span>
                </li>
            </ul>
        </div>
        <c:if test="${not game.gameLost}">
            <div id="guessLetterSection" class="container">
                <form id="newGuess">
                    <input id="gameId" name="gameId" type="hidden" value="${game.gameId}"/>

                    <label for="letter">Guess letter: </label>
                    <input id="letterInput" type="text" name="letter" id="letter" />
                    <br/>

                    <input type="submit" value="Submit Guess" /><br/>
                </form>
            </div>
        </c:if>
        <%--
        <ul class="container">
            <li>
                <a href="hangman/<c:out value="${userId}"/>">Back to home page.</a>
            </li>
        </ul>
        --%>

        <script type="text/javascript">
            $(document).ready(function() {
                $('#newGuess').submit(function(e) {
                    // will pass the form date using the jQuery serialize function
                    $.post('${pageContext.request.contextPath}/nextMove', $(this).serialize(), function(gameResponse) {
                        $('#maxAttemptsField').text(gameResponse.maxAttempts);
                        $('#failedAttemptsField').text(gameResponse.failedAttempts.length);
                        $('#failedLettersField').text(gameResponse.failedAttempts.join(", "));
                        $('#correctAttemptsField').text(gameResponse.correctAttempts.length);
                        $('#correctLettersField').text(gameResponse.correctAttempts.join(", "));
                        $('#wordToGuessField').text(gameResponse.displayPhrase.join(""));
                        $('#letterInput').val('');

                        if(gameResponse.gameWon){
                            $('#guessLetterSection').text('Congratulations, you have wan the game!');
                        } else if (gameResponse.gameLost) {
                            $('#guessLetterSection').text('Game over, please try again!');
                        }
                    });
                    e.preventDefault(); // prevent actual form submit and page reload
                });
            });
        </script>
</body>
</html>