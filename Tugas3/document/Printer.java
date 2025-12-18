package tugas.document;

import java.util.List;

public class Printer {

    public void printAll(List<Document> docs) {
        for (Document d : docs) {
            d.print();
        }
    }
}