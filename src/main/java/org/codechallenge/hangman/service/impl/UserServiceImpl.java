package org.codechallenge.hangman.service.impl;

import org.codechallenge.hangman.model.User;
import org.codechallenge.hangman.repository.UserRepository;
import org.codechallenge.hangman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by catalin.vladoiu on 10/29/2014.
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(int id) throws DataAccessException {
        return userRepository.getById(id);
    }
}
