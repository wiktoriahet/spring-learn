package pl.hetman.wiktoria.spring.learn.app.shelter.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hetman.wiktoria.spring.learn.app.shelter.web.model.CatModel;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cats")
public class CatController {
    public static final Logger LOGGER = Logger.getLogger(CatController.class.getName());

    @GetMapping
    public String read(CatModel catModel){
        LOGGER.info("read(" + catModel + ")");
        LOGGER.info("read(...)");
        return "app/shelter/cats.html";
    }
}
