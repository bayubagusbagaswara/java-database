# ResultSet

- Seperti yang sudah kita bahas sebelumnya di Statement, ketika kita melakukan query, maka akan menghasilkan java.sql.ResultSet
- ResultSet adalah representasi data hasil query dari database
- ResultSet itu mirip seperti `iterator`, jadi kita bisa melakukan perulangan di ResultSet untuk `mendapatkan data tiap record` nya

# Mengambil Data Kolom di ResultSet

- Cara kerja ResultSet adalah seperti cursor, dimana untuk maju, kita menggunakan method `next()` dan untuk mundur kita bisa menggunakan method `previous()`
- Untuk mendapatkan data tiap kolom pada saat sekarang kita berada di lokasi cursornya, maka kita bisa menggunakan banyak sekali method `geXxx(column)` di ResultSet
- Kita bisa sesuaikan dengan tipe data kolom tersebut, misal `getString(column)`, `getInt(column)`, dan lain-lain