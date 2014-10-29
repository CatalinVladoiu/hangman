package org.codechallenge.hangman.repository.impl;

import org.codechallenge.hangman.model.User;
import org.codechallenge.hangman.repository.UserRepository;
import org.codechallenge.hangman.service.UserService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by catalin.vladoiu on 10/29/2014.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getById(int id) throws DataAccessException {
        return entityManager.find(User.class, id);
    }
}
