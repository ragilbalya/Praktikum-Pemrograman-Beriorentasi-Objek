

📘 README — Studi Kasus, Latihan, & Tugas Praktikum (Lengkap)

Project Java — IntelliJ IDEA


---

# 🧩 Bagian 1 — Paket latihan

🎯 Tujuan

Menerapkan custom checked exception dan cara penangannya.

✔ Fitur

1. InsufficientFundsException → dilempar jika saldo kurang.


2. BankAccount.withdraw() sudah memanggil dan melempar exception.


3. MainLatihan menunjukkan try–catch saat error terjadi.




---

🧱 UML (Text Diagram)

+---------------------------+
|       BankAccount         |
+---------------------------+
| - balance: double         |
+---------------------------+
| + deposit(amount): void   |
| + withdraw(amount): void  |
| + getBalance(): double    |
+---------------------------+

+--------------------------------------+
|   InsufficientFundsException         |
+--------------------------------------+
| + InsufficientFundsException(msg)    |
+--------------------------------------+

+---------------------------+
|       MainLatihan         |
+---------------------------+
| + main(String[]): void    |
+---------------------------+


---

🖥 Output Contoh

Menarik 150000...
GAGAL: Saldo tidak cukup. Saldo: 100000.0, diminta: 150000.0
Saldo akhir: 100000.0


---

# 🧩 Bagian 2 — Paket tugas

🎯 Tujuan

Membangun sistem input data Student dengan validasi, GUI, dan unit test.

✔ Fitur

Validasi input nama + umur

Melempar:

InvalidInputException

TooManyInvalidAttemptsException


GUI Swing dengan warna visual (pink untuk error)

Unit test JUnit:

Valid input → objek berhasil

Invalid input → exception

Salah 3x → too many attempts




---

🧱 UML (Text Diagram)

+---------------------------+
|          Student          |
+---------------------------+
| - name: String            |
| - age: int                |
+---------------------------+
| + Student(name, age)      |
| + getName(): String       |
| + getAge(): int           |
+---------------------------+

+--------------------------------------+
|       InvalidInputException          |
+--------------------------------------+
| + InvalidInputException(msg)         |
+--------------------------------------+

+---------------------------------------------+
|   TooManyInvalidAttemptsException           |
+---------------------------------------------+
| + TooManyInvalidAttemptsException(msg)      |
+---------------------------------------------+

+---------------------------------------------+
|         StudentInputHandler                 |
+---------------------------------------------+
| - attempts: int                              |
+---------------------------------------------+
| + createStudent(name, age): Student          |
+---------------------------------------------+

+---------------------------------------------+
|          StudentInputGUI                    |
+---------------------------------------------+
| + main(String[]): void                       |
+---------------------------------------------+

+---------------------------------------------+
|   StudentInputHandlerTest (JUnit 5)         |
+---------------------------------------------+


---

# 🖥 Output GUI (Screenshot Deskripsi)

✔ Input valid

Popup:

Sukses membuat Student!

❌ Input salah

Field menjadi pink

Popup:


Input tidak valid.

❌ Salah 3 kali

Terlalu banyak percobaan input yang salah!

GUI otomatis menutup.


---

# 🧪 Output Unit Test (JUnit)

Jika benar:

3 tests passed
0 failed

Jika salah:

expected InvalidInputException but none was thrown


---

# 📌 Catatan

File ini tidak memasukkan kode Java, hanya dokumentasi sesuai permintaan.


---

# 🎉 Selesai!

