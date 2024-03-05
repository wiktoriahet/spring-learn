package pl.hetman.wiktoria.spring.learn.app.jellybeans;

import org.springframework.stereotype.Service;

@Service
public class JellyBeanService {
    private JellyBeanMapper yellowJellyBeanMapper;

    public JellyBeanService(JellyBeanMapper yellowJellyBeanMapper) {
        this.yellowJellyBeanMapper = yellowJellyBeanMapper;
    }

    public JellyBeanModel read(Long id) {
        return null;
    }
}
