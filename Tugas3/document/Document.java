package tugas.document;

public abstract class Document {
    protected String title;
    protected int pages;

    public Document(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public abstract void print();
}