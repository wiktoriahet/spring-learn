package pl.hetman.wiktoria.spring.learn.app.bookstore.web.model;

//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class BookModel {
    private String title;
    private int pages;

    public BookModel() {
    }

    public BookModel(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                '}';
    }
}
