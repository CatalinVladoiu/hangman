package org.codechallenge.hangman.service.impl;

import org.codechallenge.hangman.model.Game;
import org.codechallenge.hangman.model.GameStatus;
import org.codechallenge.hangman.repository.GameRepository;
import org.codechallenge.hangman.repository.SyllabusRepository;
import org.codechallenge.hangman.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by catalin.vladoiu on 10/26/2014.
 */
@Service
@Transactional(readOnly = true)
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private SyllabusRepository syllabusRepository;

    @Override
    public List<Game> getAll() throws DataAccessException {
        return gameRepository.getAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Game save(Game game) throws DataAccessException {
        return gameRepository.saveOrUpdate(game);
    }

    @Override
    @Transactional(readOnly = false)
    public Game createNewGame() throws DataAccessException {
        Game newGame = new Game();
        newGame.setSyllabus(syllabusRepository.getRandomSyllabus());
        newGame.setGameStatus(GameStatus.NEW);
        newGame.setMaxAttempts(6);

        return gameRepository.saveOrUpdate(newGame);
    }

    @Override
    public Game getById(int id) throws DataAccessException {
        return gameRepository.getById(id);
    }
}
