package latihan;

public class MainTextAnalyzer {
    public static void main(String[] args) {
        TextAnalyzer ta = new TextAnalyzer();
        String text = "Halo halo Bandung kota ku Bandung";

        System.out.println("Jumlah kata unik: " + ta.countUniqueWords(text));
    }
}