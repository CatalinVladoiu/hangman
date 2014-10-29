package impl;

import org.codechallenge.hangman.model.User;
import org.codechallenge.hangman.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * Created by catalin.vladoiu on 10/29/2014.
 */
@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserServiceImplIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void getById() {
        User user = userService.getById(1);
        assertEquals("Dan", user.getName());
    }
}
