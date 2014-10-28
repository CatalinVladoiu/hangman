package org.codechallenge.hangman.repository.impl;

import org.codechallenge.hangman.model.Game;
import org.codechallenge.hangman.model.Syllabus;
import org.codechallenge.hangman.repository.SyllabusRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by catalin.vladoiu on 10/26/2014.
 */
@Repository
public class SyllabusRepositoryImpl implements SyllabusRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Syllabus> getAll() throws DataAccessException {
        String hql = "SELECT s FROM Syllabus s";
        TypedQuery<Syllabus> query = entityManager.createQuery(hql, Syllabus.class);

        return query.getResultList();
    }

    @Override
    public Syllabus getRandomSyllabus() {
        List<Syllabus> syllabuses = getAll();

        return syllabuses.get(new Random().nextInt(syllabuses.size()));
    }
}