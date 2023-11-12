package pl.hetman.wiktoria.spring.learn.app.school.web.controller;

public class SchoolModel {

    private String className;
    private Integer pupils;

    public SchoolModel() {
    }

    public SchoolModel(String className, Integer pupils) {
        this.className = className;
        this.pupils = pupils;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getPupils() {
        return pupils;
    }

    public void setPupils(Integer pupils) {
        this.pupils = pupils;
    }

    @Override
    public String toString() {
        return "SchoolModel{" +
                "className='" + className + '\'' +
                ", pupils=" + pupils +
                '}';
    }
}
