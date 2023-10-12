package pl.hetman.wiktoria.spring.learn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller //spring ma sie tym zainteresowac (to tez jest component)
@RequestMapping(value = "/notesexample") //moduł web ma pod konkretnym adresem url obsługiwać żądania http
public class ExampleNoteController {

    private static final Logger LOGGER = Logger.getLogger(ExampleNoteController.class.getName());

    @PostMapping //metody protokołu http
    public void create() {
        LOGGER.info("create()");

        LOGGER.info("create(...)");
    }

    @GetMapping //metody protokołu http
    public void read() {
        LOGGER.info("read()");

        LOGGER.info("read(...)");
    }

}
