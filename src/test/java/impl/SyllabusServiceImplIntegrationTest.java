package impl;

import org.codechallenge.hangman.model.Syllabus;
import org.codechallenge.hangman.service.SyllabusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by catalin.vladoiu on 10/27/2014.
 */
@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class SyllabusServiceImplIntegrationTest {

    @Autowired
    protected SyllabusService syllabusService;

    @Test
    public void getAll() {
        List<Syllabus> syllabuses = syllabusService.getAll();
        assertEquals(5, syllabuses.size());
    }

    @Test
    public void getRandomSyllabus() {
        List<Syllabus> syllabuses = syllabusService.getAll();

        Syllabus syllabus = syllabusService.getRandomSyllabus();
        assertTrue(syllabuses.contains(syllabus));
    }
}
