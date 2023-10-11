package pl.hetman.wiktoria.spring.learn.web.model;

import jakarta.validation.constraints.NotBlank;
//import javax.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotBlank;

public class NoteModel {

    @NotBlank(message = "Title must not be blank")
    private String title;
    @NotBlank(message = "Content must not be blank")
    private String content;

    public NoteModel() {
    }

    public NoteModel(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "NoteModel{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
