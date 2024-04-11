package pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RoleEntity")
public class RoleEntity {

    @Id
    @GeneratedValue
    private Long id;
    // private RoleName name;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<SpringLearnUserEntity> users = new ArrayList<>();

    public RoleEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SpringLearnUserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<SpringLearnUserEntity> users) {
        this.users = users;
    }

    //    public RoleName getName() {
//        return name;
//    }
//
//    public void setName(RoleName name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
