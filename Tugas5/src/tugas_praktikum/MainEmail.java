package tugas_praktikum;

import java.util.Arrays;
import java.util.Set;

public class MainEmail {
    public static void main(String[] args) throws Exception {
        EmailDeduplicator ed = new EmailDeduplicator();

        Set<String> result = ed.deduplicate(Arrays.asList(
                "Abilrauf184@gmail.com",
                "Nabilrauf7676@gmail.com",
                "testing2332@yahoo.com",
                "Testing242425@yahoo.com"
        ));

        System.out.println("Email unik: " + result);

        ed.writeToFile(result, "emails_unique.txt");
        System.out.println("File 'emails_unique.txt' berhasil dibuat.");
    }
}