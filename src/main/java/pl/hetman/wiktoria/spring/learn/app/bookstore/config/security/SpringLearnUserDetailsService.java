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
//    private static Map<String, String> users = new HashMap<>();
//
//    static {
//        users.put("Wiktoria", "alamakota"); //49aa66843380c377e93b198b966eb699
//        //users.put("Wiktoria", "49aa66843380c377e93b198b966eb699"); //49aa66843380c377e93b198b966eb699
//        users.put("user2", "password2");
//        users.put("user3", "password3");
//        users.put("user14", "password4");
//    }

    @Autowired
    private SpringLearnUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    public SpringLearnUserDetailsService(SpringLearnUserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("loadUserByUsername(" + username + ")");

        //String password = users.get(username);
        //LOGGER.info("### PASSWORD: " + password);
        SpringLearnUserEntity foundUserEntity = userRepository.findByUsername(username);

        LOGGER.info("### USERENTITY: " + foundUserEntity);

        if (foundUserEntity != null) {
            LOGGER.info("loadUserByUsername(...)");
            return User
                    .withUsername(username)
                    .username(username)
                    .password(passwordEncoder.encode(foundUserEntity.getPassword()))
                    //.password(password)
                    .build();
        } else {
            LOGGER.info("loadUserByUsername(...)");
            throw new UsernameNotFoundException("Username doesn't exist");
        }

    }
    //todo JPARepository dla Users, springlearnuser
}
