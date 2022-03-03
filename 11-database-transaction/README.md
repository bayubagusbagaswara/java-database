# Database Transaction

- Fitur paling bermanfaat di database salah satunya adalah database transaction
- Fitur database transaction pun bisa kita jalankan menggunakan JDBC

# Auto Commit

- Secara default, Connection yang kita buat menggunakan JDBC memiliki sifat `auto commit`
- Auto commit artinya setiap perintah SQL yang kita kirim akan langsung di commit secara otomatis
- Karena dalam database transaction, kita biasanya melakukan commit transaction setelah semua proses selesai, maka kita perlu mematikan auto commit di JDBC
- Untuk mematikan fitur auto commit di JDBC, kita bisa menggunakan method di Connection bernama `setAutoCommit(false)`
- Setelah selesai melakukan proses transaction, kita bisa melakukan commit transaction dengan menggunakan method `commit()` miliki Connection
- Untuk membatalkan proses transaksi (rollbak), kita bisa menggunakan method `rollback()` milik Connection