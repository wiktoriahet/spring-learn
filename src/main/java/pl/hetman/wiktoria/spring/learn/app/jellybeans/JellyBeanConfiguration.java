package pl.hetman.wiktoria.spring.learn.app.jellybeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JellyBeanConfiguration {

    @Bean
    public JellyBeanMapper yellowJellyBeanMapper() {
        return new JellyBeanMapper(true);
    }
//
//    @Bean
//    public JellyBeanMapper pinkJellyBeanMapper() {
//        return new JellyBeanMapper(false);
//    }
}
