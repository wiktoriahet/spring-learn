package pl.hetman.wiktoria.spring.learn.app.bookstore.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.SpringLearnUserRepository;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.SpringLearnUserEntity;

import java.util.logging.Logger;

@Service
public class SpringLearnUserDetailsService implements UserDetailsService {

    //https://www.md5hashgenerator.com/

    public static final Logger LOGGER = Logger.getLogger(SpringLearnUserDetailsService.class.getName());

    @Autowired
    private SpringLearnUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("loadUserByUsername(" + username + ")");

        SpringLearnUserEntity foundUserEntity = userRepository.findByUsername(username);
        LOGGER.info("### USERENTITY: " + foundUserEntity);

        if (foundUserEntity != null) {
            LOGGER.info("loadUserByUsername(...)");
            return User
                    .withUsername(username)
                    .username(username)
                    .password(passwordEncoder.encode(foundUserEntity.getPassword()))
                    .build();
        } else {
            LOGGER.info("loadUserByUsername(...)");
            throw new UsernameNotFoundException("Username doesn't exist");
        }
    }
    //todo JPARepository dla Users, springlearnuser
}
