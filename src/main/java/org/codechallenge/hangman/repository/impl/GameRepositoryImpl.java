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
            return entityManager.merge(game);
        }

        entityManager.persist(game);
        return game;
    }

    @Override
    public Game getByUserId(int userId) throws DataAccessException {
        //TODO Have to look more into this do to stupid error
        /*String hql = String.format("SELECT Game WHERE user_id = %s", userId);
        TypedQuery<Game> query = entityManager.createQuery(hql, Game.class);
        query.setParameter("user_id", userId);
        return query.getSingleResult();*/
        List<Game> games = getAll();
        for (Game g : games){
            if (g.getUser().getId() == userId) {
                return g;
            }
        }
        return null;
    }
}