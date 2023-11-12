package pl.hetman.wiktoria.spring.learn.app.school.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/school")
public class SchoolController {
    public static final Logger LOGGER = Logger.getLogger(SchoolController.class.getName());

    private List<SchoolModel> classes = new ArrayList<>();

    @GetMapping
    public String read(SchoolModel schoolModel) {
        LOGGER.info("read(" + schoolModel + ")");
        LOGGER.info("read(...)");
        return "app/school/classes.html";
    }

    @GetMapping(value = "/create")
    public String createView(ModelMap modelMap) {
        LOGGER.info("createView()");
        modelMap.addAttribute("class", new SchoolModel());
        LOGGER.info("createView(...)");
        return "app/school/create-class.html";
    }

    @PostMapping
    public String create(SchoolModel schoolModel) {
        LOGGER.info("create(" + schoolModel + ")");
        classes.add(schoolModel);
        LOGGER.info("create(...)");
        return "redirect:/school/list";
    }

    @GetMapping(value = "/list")
    public String list(ModelMap modelMap) {
        LOGGER.info("list()");
        modelMap.addAttribute("classes", classes);
        LOGGER.info("list(...)");
        return "app/school/classes.html";
    }
}
