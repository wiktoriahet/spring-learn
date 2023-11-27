package pl.hetman.wiktoria.spring.learn.app.shelter.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CatEntity {

    @Id
    @GeneratedValue
    private String name;
    private Integer tag;

    public CatEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "CatEntity{" +
                "name='" + name + '\'' +
                ", tag=" + tag +
                '}';
    }
}
