package pl.hetman.wiktoria.spring.learn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @PostMapping
    public void create(){
        LOGGER.info("create()");

        LOGGER.info("create(...)");
    }

    @GetMapping
    public void read(){
        LOGGER.info("read()");

        LOGGER.info("read(...)");
    }


}
