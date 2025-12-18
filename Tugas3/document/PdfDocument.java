package tugas.document;

public class PdfDocument extends Document {

    public PdfDocument(String title, int pages) {
        super(title, pages);
    }

    @Override
    public void print() {
        System.out.println("PDF: " + title);
        System.out.println("Halaman: " + pages);
        System.out.println("Format: .pdf\n");
    }
}