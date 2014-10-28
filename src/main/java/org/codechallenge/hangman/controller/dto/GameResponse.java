package org.codechallenge.hangman.controller.dto;

import java.util.List;

/**
 * Created by catalin.vladoiu on 10/28/2014.
 */
public class GameResponse {

    private Integer gameId;
    private Integer maxAttempts;
    private List<String> displayPhrase;
    private List<String> correctAttempts;
    private List<String> failedAttempts;
    private boolean gameWon;
    private boolean gameLost;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getMaxAttempts() {
        return maxAttempts;
    }

    public void setMaxAttempts(Integer maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    public List<String> getDisplayPhrase() {
        return displayPhrase;
    }

    public void setDisplayPhrase(List<String> displayPhrase) {
        this.displayPhrase = displayPhrase;
    }

    public List<String> getCorrectAttempts() {
        return correctAttempts;
    }

    public void setCorrectAttempts(List<String> correctAttempts) {
        this.correctAttempts = correctAttempts;
    }

    public List<String> getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(List<String> failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    public boolean isGameLost() {
        return gameLost;
    }

    public void setGameLost(boolean gameLost) {
        this.gameLost = gameLost;
    }
}
