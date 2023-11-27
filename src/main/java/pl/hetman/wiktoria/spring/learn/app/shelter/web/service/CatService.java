package pl.hetman.wiktoria.spring.learn.app.shelter.web.service;

import org.springframework.stereotype.Service;
import pl.hetman.wiktoria.spring.learn.app.shelter.repository.CatSpringRepository;
import pl.hetman.wiktoria.spring.learn.app.shelter.web.exception.CatException;
import pl.hetman.wiktoria.spring.learn.app.shelter.web.model.CatModel;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CatService {

    private static final Logger LOGGER = Logger.getLogger(CatService.class.getName());

    private CatSpringRepository catSpringRepository;

    public CatService(CatSpringRepository catSpringRepository) {
        this.catSpringRepository = catSpringRepository;
    }

    public CatModel create(CatModel catModel) throws CatException {
        LOGGER.info("create(" + catModel + ")");

        LOGGER.info("create(...)");
        return null;
    }


    public CatModel read(Long id) {
        LOGGER.info("read(" + id + ")");

        LOGGER.info("read(...)");
        return null;
    }

    public CatModel update(Long id, CatModel catModel) {
        LOGGER.info("update(" + id + ", " + catModel + ")");
        LOGGER.info("update(...)");
        return null;
    }

    public boolean delete(Long id) {
        LOGGER.info("delete(" + id + ")");
        LOGGER.info("delete(...)");
        return false;
    }

    public List<CatModel> list() {
        return null;
    }
}
