package pl.hetman.wiktoria.spring.learn.app.bookstore.repository.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "RoleEntity")
public class RoleEntity {

    @Id
    @GeneratedValue
    private Long id;
    private RoleName name;
    @ManyToMany(mappedBy = "roles")
    private List<SpringLearnUserEntity> users = new ArrayList<>();

    public RoleEntity(Long id, RoleName name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
