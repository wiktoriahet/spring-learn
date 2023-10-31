package pl.hetman.wiktoria.spring.learn.app.shelter.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hetman.wiktoria.spring.learn.app.shelter.web.model.CatModel;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/cats")
public class CatController {
    public static final Logger LOGGER = Logger.getLogger(CatController.class.getName());

    private List<CatModel> cats = new ArrayList<>();

    @GetMapping
    public String read(CatModel catModel) {
        LOGGER.info("read(" + catModel + ")");
        LOGGER.info("read(...)");
        return "app/shelter/cats.html";
    }

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        LOGGER.info("createView(...)");
        return "app/shelter/create-cat.html";
    }

    @PostMapping
    public String create(CatModel catModel) {
        LOGGER.info("create(" + catModel + ")");
        cats.add(catModel);
        LOGGER.info("create(...)");
        //return "app/shelter/cats.html";
        return "redirect:/cats/list";
    }

    @GetMapping(value = "/list")
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
//        List<CatModel> cats = List.of(
//                new CatModel("Puszek", 745),
//                new CatModel("Mruczek", 26)
//        );
        modelMap.addAttribute("cats", cats);
        LOGGER.info("list(...)");
        return "app/shelter/cats.html";
    }
}
