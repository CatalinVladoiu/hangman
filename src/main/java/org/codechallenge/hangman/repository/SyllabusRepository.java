package org.codechallenge.hangman.repository;

import org.codechallenge.hangman.model.Game;
import org.codechallenge.hangman.model.Syllabus;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by catalin.vladoiu on 10/26/2014.
 */
public interface SyllabusRepository {

    List<Syllabus> getAll() throws DataAccessException;

    Syllabus getRandomSyllabus();
}
