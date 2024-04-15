package pl.hetman.wiktoria.spring.learn.app.bookstore.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.SpringLearnUserRepository;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.RoleEntity;
import pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity.SpringLearnUserEntity;

import java.util.List;
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
        List<RoleEntity> foundRoles = foundUserEntity.getRoles();

        if (foundUserEntity != null) {
            LOGGER.info("loadUserByUsername(...)");
            return User
                    .withUsername(username)
                    .username(username)
                    .password(passwordEncoder.encode(foundUserEntity.getPassword()))
                    .roles("ADMIN") //todo wstawić nazwy ról pochodzące z foundRoles
                    .build();
        } else {
            LOGGER.info("loadUserByUsername(...)");
            throw new UsernameNotFoundException("Username doesn't exist");
        }
    }

    //todo stworzyć nową encję przechowującą role (id, name), opcjonalnie
    //name jako enum
    //napisać relację łączącą tabelę/encję users z roles (hibernate) many-to-many
    //encja przechowujaca uzytkownikow bedze posiadala dodatkowa metode add()
    //ktora polaczy nowa role z biezacym uzytkownikiem
    //lista/zbior inicjalizowana w momencie tworzenia pola w klasie


    //https://www.baeldung.com/hibernate-many-to-many
    //https://www.baeldung.com/role-and-privilege-for-spring-security-registration
}
