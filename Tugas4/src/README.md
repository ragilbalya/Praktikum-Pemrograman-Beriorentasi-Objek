Studi Kasus & Tugas — Latihan + Tugas Praktikum

Dokumen ini menjelaskan seluruh latihan dan tugas praktikum, termasuk fitur, penjelasan konsep, UML ASCII, serta pemisahan file PUML.


---

## 1. Soal Latihan — package latihan.student

Fitur yang Dibuat

1. searchByName(String partial)

Mencari semua Student yang namanya mengandung substring tertentu

Pencarian bersifat case-insensitive



2. paginate(int page, int size)

Mengembalikan sebagian list berdasarkan nomor halaman

page dimulai dari 1

size adalah jumlah item per halaman




Penjelasan Konsep

Latihan fokus pada manipulasi list.

Tidak ada log atau id, hanya dua fitur inti yang diminta di kelas.



---

UML ASCII (Latihan)

Student

+---------------------------+
|         Student           |
+---------------------------+
| - name : String           |
+---------------------------+
| + getName() : String      |
+---------------------------+

StudentRepository

+-----------------------------------+
|       StudentRepository           |
+-----------------------------------+
| - students : List<Student>        |
+-----------------------------------+
| + add(Student)                    |
| + searchByName(String) : List     |
| + paginate(int, int) : List       |
+-----------------------------------+

Relasi

StudentRepository --> Student

---

## 2. Tugas Praktikum — package tugas.student

Fitur Utama

1. Log Perubahan (Change Log)

Setiap update() atau remove() dilakukan:

Student akan disalin secara defensif (defensive copy)

Lalu disimpan ke list logs


Mencegah modifikasi berbahaya pada object asli.



2. Perbandingan Performa List (ArrayList vs LinkedList)

Membuat 1 juta Integer

Melakukan operasi get(i) dari 0 sampai 999.999

Mengukur waktu akses




Hasil Performa (Ringkasan)

ArrayList unggul jauh karena akses indeks O(1)

LinkedList lambat karena get(i) butuh traversal node (O(n))



---

UML ASCII (Tugas Praktikum)

Student

+-------------------------------+
|            Student            |
+-------------------------------+
| - id   : int                  |
| - name : String               |
+-------------------------------+
| + getId()   : int             |
| + getName() : String          |
+-------------------------------+

StudentRepository

+-----------------------------------------------+
|              StudentRepository                |
+-----------------------------------------------+
| - students : List<Student>                    |
| - logs     : List<Student>                    |
+-----------------------------------------------+
| + add(Student)                                |
| + update(int, String)                         |
| + remove(int)                                 |
| + getLogs() : List<Student>                   |
+-----------------------------------------------+

Relasi

StudentRepository --> Student

---

## 3. Perbandingan Performa — Ringkasan

Operasi	ArrayList (Cepat)	LinkedList (Lambat)

Akses indeks get(i)	O(1)	O(n)
Tambah di akhir	Stabil & cepat	Bervariasi
Remove di tengah	Lambat	Lebih baik
Cocok untuk	Random access	Banyak insert/remove


Kesimpulan: Untuk tugas ini, ArrayList jauh lebih cepat saat mengakses 1 juta data.