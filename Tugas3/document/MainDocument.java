package tugas.document;

import java.util.ArrayList;
import java.util.List;

public class MainDocument {

    public static void main(String[] args) {

        List<Document> docs = new ArrayList<>();
        docs.add(new PdfDocument("Laporan Keuangan", 12));
        docs.add(new WordDocument("Surat Undangan", 3));

        Printer p = new Printer();
        p.printAll(docs);
    }
}