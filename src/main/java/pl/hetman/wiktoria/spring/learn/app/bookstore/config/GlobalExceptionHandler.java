package pl.hetman.wiktoria.spring.learn.app.bookstore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception exception) {
        LOGGER.error("#### Exception: " + exception.getMessage());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("book-error");
        modelAndView.addObject("message", exception.getMessage());
        return modelAndView;
    }

//    @ExceptionHandler(BookException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ResponseEntity<String> handleBookException(BookException bookException) {
//        return new ResponseEntity<>(bookException.getMessage(), HttpStatus.BAD_REQUEST);
//    }

//    @ExceptionHandler(BookNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException bookNotFoundException) {
//        return new ResponseEntity<>(bookNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
//    }

}


