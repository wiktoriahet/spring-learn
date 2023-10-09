package pl.hetman.wiktoria.spring.learn.web.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hetman.wiktoria.spring.learn.web.model.NoteModel;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/notes")
public class NoteController {
    public static final Logger LOGGER = Logger.getLogger(NoteController.class.getName());
    private List<NoteModel> notes = new ArrayList<>();

    @GetMapping
    public String list() {
        LOGGER.info("list() = " + notes);
        return "notes/notes";
    }

    @GetMapping(value = "/create")
    public String createView() {
        return "notes/create-note";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute(name = "note") NoteModel note,
                         BindingResult bindingResult) {
        LOGGER.info("create(" + note + ")");

        if (bindingResult.hasErrors()) {
            LOGGER.info("validation errors in Model: " + note);
            LOGGER.info("validation errors: " + bindingResult.getAllErrors());
            return "notes/create-note";
        }

        notes.add(note);
        return "redirect:/notes";
    }


}
