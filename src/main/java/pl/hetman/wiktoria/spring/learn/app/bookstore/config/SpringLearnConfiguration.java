package pl.hetman.wiktoria.spring.learn.app.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.hetman.wiktoria.spring.learn.app.bookstore.web.service.mapper.BookMapper;

@Configuration
public class SpringLearnConfiguration {

    @Bean
    public BookMapper customBookMapper(){
        return new BookMapper();
    }

    @Bean
    public BookMapper vipBookMapper(){
        return new BookMapper();
    }



}
