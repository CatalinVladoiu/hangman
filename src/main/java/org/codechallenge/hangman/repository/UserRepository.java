package org.codechallenge.hangman.repository;

import org.codechallenge.hangman.model.User;
import org.springframework.dao.DataAccessException;

/**
 * Created by catalin.vladoiu on 10/29/2014.
 */
public interface UserRepository {

    User getById(int id) throws DataAccessException;
}
