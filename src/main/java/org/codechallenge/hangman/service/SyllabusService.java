package org.codechallenge.hangman.service;

import org.codechallenge.hangman.model.Syllabus;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by catalin.vladoiu on 10/27/2014.
 */
public interface SyllabusService {

    List<Syllabus> getAll() throws DataAccessException;

    Syllabus getRandomSyllabus();
}
