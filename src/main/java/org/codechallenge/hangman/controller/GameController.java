package org.codechallenge.hangman.controller;

import org.codechallenge.hangman.controller.dto.GameResponse;
import org.codechallenge.hangman.controller.util.UrlMapping;
import org.codechallenge.hangman.model.Attempt;
import org.codechallenge.hangman.model.Game;
import org.codechallenge.hangman.model.GameStatus;
import org.codechallenge.hangman.model.Syllabus;
import org.codechallenge.hangman.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by catalin.vladoiu on 10/26/2014.
 */
@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value = {UrlMapping.START_GAME, UrlMapping.START_GAME_WITH_USER}, method = RequestMethod.GET)
    public String startGame(@PathVariable int userId, ModelMap model) {
        Game game = gameService.createNewGame(userId);
        model.addAttribute("game", createResponse(game));
        return "game";
    }

    @RequestMapping(value = UrlMapping.RESUME_GAME, method = RequestMethod.GET)
    public String resumeGame(@PathVariable int userId, ModelMap model) {
        Game game = gameService.getByUserId(userId);
        //if the game is null means that the user has not played any game before
        if (null == game){
            game = gameService.createNewGame(userId);
        }
        model.addAttribute("game", createResponse(game));
        return "game";
    }

    @RequestMapping(value = UrlMapping.NEXT_MOVE, method = RequestMethod.POST)
    public @ResponseBody GameResponse doMove(@RequestParam("gameId") int gameId, @RequestParam("letter") String letter) {
        Game game = gameService.getById(gameId);
        addGameAttempt(letter, game);
        updateGameStatus(game);

        //update game with latest attempt
        gameService.save(game);

        return createResponse(game);
    }

    @RequestMapping(value = UrlMapping.LIST_GAMES, method = RequestMethod.GET)
    public String listGames(ModelMap model) {
        List<Game> games = gameService.getAll();
        model.addAttribute("games", games);
        return "listGames";
    }

    /**
     * Create the game response object. Used by front-end for displaying game information.
     *
     * @param game
     * @return
     */
    private GameResponse createResponse(Game game) {
        GameResponse gameResponse = new GameResponse();
        gameResponse.setGameId(game.getId());
        gameResponse.setUserId(game.getUser().getId());
        gameResponse.setMaxAttempts(game.getMaxAttempts());
        gameResponse.setDisplayPhrase(getDisplayPhrase(game));
        gameResponse.setCorrectAttempts(fillAttempts(game.getCorrectAttempts()));
        gameResponse.setFailedAttempts(fillAttempts(game.getFailedAttempts()));
        gameResponse.setGameWon(game.isWan());
        gameResponse.setGameLost(game.isLost());

        return gameResponse;
    }

    /**
     * Create the display word which has to be guessed by the user.
     *
     * @param game
     * @return
     */
    private List<String> getDisplayPhrase(Game game) {
        Syllabus syllabus = game.getSyllabus();
        String[] displayPhrase = new String[syllabus.getPhrase().length()];

        if (null != game.getCorrectAttempts()) {
            //add guessed letters to the displayPhrase on correct positions
            for (Attempt attempt : game.getCorrectAttempts()) {
                String letter = attempt.getLetter();
                List<Integer> foundPositions = syllabus.getLetterPositions(letter);
                for (int position : foundPositions) {
                    displayPhrase[position] = letter;
                }
            }
        }
        //add  "-" for empty list element because those should be guessed
        for (int x = 0; x < displayPhrase.length; x++) {
            if (null == displayPhrase[x] || displayPhrase[x].isEmpty()) {
                displayPhrase[x] = "-";
            }
        }

        return Arrays.asList(displayPhrase);
    }

    /**
     * @param attempts
     * @return
     */
    private List<String> fillAttempts(List<Attempt> attempts) {
        List<String> filledAttempts = new ArrayList<>();
        if (null != attempts){
            for (Attempt attempt : attempts) {
                filledAttempts.add(attempt.getLetter());
            }
        }
        return filledAttempts;
    }

    /**
     * Add attempt to Game. Required to keep persistent the state of the game.
     *
     * @param letter
     * @param game
     */
    private void addGameAttempt(String letter, Game game) {
        Attempt attempt = new Attempt();
        attempt.setLetter(letter);

        if (game.getSyllabus().containsLetter(letter)) {
            attempt.setGuessed(Boolean.TRUE);
        } else {
            attempt.setGuessed(Boolean.FALSE);
        }

        game.addAttempt(attempt);
    }

    /**
     * Update game status after each move.
     *
     * @param game
     */
    private void updateGameStatus(Game game){
        if (!game.isWan() && !game.isLost()) {
            game.setGameStatus(GameStatus.IN_PROGRESS);
        }else if (game.isWan()) {
            game.setGameStatus(GameStatus.WON);
        }else if (game.isLost()) {
            game.setGameStatus(GameStatus.FAILED);
        }
    }
}
