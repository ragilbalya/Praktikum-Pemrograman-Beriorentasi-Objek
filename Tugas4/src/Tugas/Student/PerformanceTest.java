package Tugas.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerformanceTest {
    public static void main(String[] args) {

        int size = 1_000_000;

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start, end;

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            arrayList.get(i);
        }
        end = System.nanoTime();
        System.out.println("ArrayList get(): " + (end - start) + " ns");

        start = System.nanoTime();
        for (int i = 0; i < size; i++) {
            linkedList.get(i);
        }
        end = System.nanoTime();
        System.out.println("LinkedList get(): " + (end - start) + " ns");
    }
}