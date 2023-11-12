package pl.hetman.wiktoria.spring.learn.app.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/shops")
public class ShopController {

    private static final Logger LOGGER = Logger.getLogger(ShopController.class.getName());

    @GetMapping
    public String shop(ShopModel shopModel) {
        LOGGER.info("shop(" + shopModel + ")");

        LOGGER.info("shop(...)");
        return "app/shop/shops.html";
    }

    @GetMapping(value = "/create")
    public String createView() {
        LOGGER.info("createView()");
        LOGGER.info("createView(...)");
        return "app/shop/create-shop.html";
    }

    @PostMapping
    public String create(ShopModel shopModel) {
        LOGGER.info("create(" + shopModel + ")");
        LOGGER.info("create(...)");
        return "app/shop/shops.html";
    }

}
