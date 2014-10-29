package org.codechallenge.hangman.controller.util;

/**
 * Created by catalin.vladoiu on 10/26/2014.
 */
public class UrlMapping {
    public static final String START_GAME = "/startGame";
    public static final String START_GAME_WITH_USER = "/startGame/{userId}";
    public static final String NEXT_MOVE = "/nextMove";
    public static final String RESUME_GAME = "/resumeGame/{userId}";
    public static final String LIST_GAMES = "/listGames/{userId}";
    public static final String WELCOME_USER = "/{userId}";
}
