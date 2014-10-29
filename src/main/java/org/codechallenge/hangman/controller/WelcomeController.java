package org.codechallenge.hangman.controller;

import org.codechallenge.hangman.controller.util.UrlMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by catalin.vladoiu on 10/27/2014.
 */
@Controller
public class WelcomeController {
    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    /**
     * Simply selects the welcome view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    /**
     * Simply selects the welcome view to render by returning its name.
     */
    @RequestMapping(value = UrlMapping.WELCOME_USER, method = RequestMethod.GET)
    public String welcomeUser(@PathVariable Long userId, ModelMap model) {
        model.addAttribute("userId", userId);
        return "welcome";
    }
}
