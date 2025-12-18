package tugas.document;

public class WordDocument extends Document {

    public WordDocument(String title, int pages) {
        super(title, pages);
    }

    @Override
    public void print() {
        System.out.println("Word Doc: " + title);
        System.out.println("Halaman: " + pages);
        System.out.println("Format: .docx\n");
    }
}