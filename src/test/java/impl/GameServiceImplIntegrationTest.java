package impl;

import org.codechallenge.hangman.controller.GameController;
import org.codechallenge.hangman.model.Attempt;
import org.codechallenge.hangman.model.Game;
import org.codechallenge.hangman.model.GameStatus;
import org.codechallenge.hangman.model.Syllabus;
import org.codechallenge.hangman.service.GameService;
import org.codechallenge.hangman.service.SyllabusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by catalin.vladoiu on 10/27/2014.
 */
@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class GameServiceImplIntegrationTest {

    @Autowired
    private GameService gameService;

    @Autowired
    protected SyllabusService syllabusService;

    @Test
    public void getAll() {
        List<Game> games = gameService.getAll();
        assertEquals(1, games.size());
    }

    @Test
    public void getById() {
        Game game = gameService.getById(1);
        assertEquals("NEW", game.getGameStatus().toString());
    }

    @Test
    public void saveGame() {
        //check how many games are in db before adding a new one
        assertEquals(1, gameService.getAll().size());

        Syllabus syllabus = syllabusService.getRandomSyllabus();
        Game game = new Game();
        game.setSyllabus(syllabus);
        game.setGameStatus(GameStatus.NEW);

        Game savedGame = gameService.save(game);

        //check how many games are in db after adding a new one
        assertEquals(2, gameService.getAll().size());
    }

    @Test
    public void updateGame() {
        Game game = gameService.getById(1);
        //check how many correct attempts has this game(sould have 2)
        assertEquals(2, game.getCorrectAttempts().size());

        //add new attempt to the game
        Attempt newAttempt = new Attempt();
        newAttempt.setGuessed(Boolean.TRUE);
        newAttempt.setLetter("D");
        game.addAttempt(newAttempt);

        Game updatedGame = gameService.save(game);

        //check how many games are in db after adding a new one
        assertEquals(3, updatedGame.getCorrectAttempts().size());
    }
}
