package pl.hetman.wiktoria.spring.learn.app.shelter.web.model;

public class CatModel {
    private String name;
    private int tag;

    public CatModel() {
    }

    public CatModel(String name, int tag) {
        this.name = name;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
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
