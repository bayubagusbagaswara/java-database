# SQL dengan Parameter

- Saat membuat aplikasi, kita tidak mungkin akan melakukan hardcode perintah SQL di kode program Java kita
- Biasanya kita akan menerima input data dari user, kemudian membuat perintah SQL dari input user, selanjutnya mengirimnya ke database menggunakan perintah SQL

# SQL Injection

- SQL Injection adalah sebuah teknik yang menyalahgunakan sebuah celah keamanan yang terjadi dalam lapisan basis data sebuah aplikasi
- Biasanya SQL Injection dilakukan dengan mengirim input dari user dengan perintah yang salah, sehingga menyebabkan hasil SQL yang kita buat menjadi tidak valid
- SQL Injection sangat berbahaya, jika sampai kita salah membuat SQL, bisa jadi data kita tidak aman

# Solusinya?

- Statement tidak didesain untuk bisa menangani SQL Injection
- Oleh karena itu, jika SQL query yang kita gunakan dibuat berdasarkan input dari user, maka kita jangan menggunakan Statement
- Untuk menghindari SQL Injection, terdapat interface bernama `PreparedStatement`, ini adalah jenis statement yang bisa menangani SQL Injection dengan baik