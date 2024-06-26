package pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USERS")
public class SpringLearnUserEntity {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    @ManyToMany
    private List<RoleEntity> roles = new ArrayList<>();

    public void add(RoleEntity roleEntity){
        roles.add(roleEntity);
        roleEntity.getUsers().add(this);
    }

//    public void addAddress(Address address) {
//        addresses.add(address);
//        address.getPeople().add(this);
//    }
//
//    public void removeAddress(Address address) {
//        addresses.remove(address);
//        address.getPeople().remove(this);
//    }

    public SpringLearnUserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "SpringLearnUserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
