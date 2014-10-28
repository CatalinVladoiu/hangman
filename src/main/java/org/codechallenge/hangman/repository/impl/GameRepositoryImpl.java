package org.codechallenge.hangman.repository.impl;

import org.codechallenge.hangman.model.Game;
import org.codechallenge.hangman.model.GameStatus;
import org.codechallenge.hangman.model.Syllabus;
import org.codechallenge.hangman.repository.GameRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by catalin.vladoiu on 10/26/2014.
 */
@Repository
public class GameRepositoryImpl implements GameRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Game> getAll() throws DataAccessException {
        String hql = "SELECT g from Game g order by g.gameStatus";
        TypedQuery<Game> query = entityManager.createQuery(hql, Game.class);
        return query.getResultList();
    }

    @Override
    public Game getById(int id) throws DataAccessException {
        return entityManager.find(Game.class, id);
    }

    @Override
    public Game saveOrUpdate(Game game) throws DataAccessException {
        if (game.getId() != null) {
            return this.entityManager.merge(game);
        }

        this.entityManager.persist(game);
        return game;
    }
}