package org.codechallenge.hangman.service.impl;

import org.codechallenge.hangman.model.Syllabus;
import org.codechallenge.hangman.repository.SyllabusRepository;
import org.codechallenge.hangman.service.SyllabusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by catalin.vladoiu on 10/27/2014.
 */
@Service
@Transactional(readOnly = true)
public class SyllabusServiceImpl implements SyllabusService {

    @Autowired
    private SyllabusRepository syllabusRepository;

    @Override
    public List<Syllabus> getAll() throws DataAccessException {
        return syllabusRepository.getAll();
    }

    @Override
    public Syllabus getRandomSyllabus() {
        return syllabusRepository.getRandomSyllabus();
    }
}
