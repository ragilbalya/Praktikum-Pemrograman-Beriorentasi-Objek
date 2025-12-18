package tugas_praktikum;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EmailDeduplicator {

    public Set<String> deduplicate(List<String> emails) {
        Set<String> unique = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        for (String e : emails) {
            if (e != null) {
                unique.add(e.toLowerCase());
            }
        }
        return unique;
    }

    public void writeToFile(Set<String> emails, String fileName) throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        for (String e : emails) {
            bw.write(e);
            bw.newLine();
        }
        bw.close();
    }
}