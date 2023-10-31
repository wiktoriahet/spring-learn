package pl.hetman.wiktoria.spring.learn.app.shelter.web.model;

public class CatModel {
    private String name;
    private Integer tag;

    public CatModel() {
    }

    public CatModel(String name, Integer tag) {
        this.name = name;
        this.tag = tag;
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
        return "CatModel{" +
                "name='" + name + '\'' +
                ", tag=" + tag +
                '}';
    }
}
