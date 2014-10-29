package org.codechallenge.hangman.service;

import org.codechallenge.hangman.model.Game;
import org.codechallenge.hangman.model.GameStatus;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by catalin.vladoiu on 10/26/2014.
 */
public interface GameService {

    /**
     * Retrieve all <code>Game</code> based on specified <code>GameStatus</code> from the data base.
     *
     * @return a <code>Collection</code> of <code>Game</code>
     */
    List<Game> getAll() throws DataAccessException;

    /**
     * Save a <code>Game</code> to the data base, either inserting or updating it.
     *
     * @param game the <code>Game</code> to save
     */
    Game save(Game game) throws DataAccessException;

    Game createNewGame(int userId) throws DataAccessException;

    Game getById(int id) throws DataAccessException;

    Game getByUserId(int userId) throws DataAccessException;
}
