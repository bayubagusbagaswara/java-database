# Mengirim Perintah SQL

- Saat kita terkoneksi ke database via Connection, sudah pasti kita ingin mengirim perintah SQL ke database
- Connection adalah object yang bertugas sebagai jembatan koneksi dari aplikasi kita ke database, untuk mengirim perintah SQL, kita bisa menggunakan beberapa object lain, salah satunya yang akan kita bahas sekarang, yaitu `Statement`

# Statement 

- java.sql.Statement adalah `interface` yang bisa kita gunakan untuk mengirim SQL ke database, sekaligus menerima response data dari database
- Ada banyak method yang bisa kita gunakan di Statement untuk mengirim perintah SQL, kita akan bahas satu per satu
- Untuk membuat statement kita bisa menggunakan method `createStatement()` milik Connection

# Statement.executeUpdate(sql)

- Method pertama yang akan kita bahas adalah `executeUpdate(sql)`
- Method ini digunakan untuk mengirim perintah SQL INSERT, UPDATE, DELETE, atau apapun yang tidak membutuhkan result
- Bahkan bisa perintah SQL DDL (create table, create index, dan lain-lain), walaupun best practice nya, perintah DDL lebih baik dilakukan langsung di database, atau menggunakan migration script, jadi tidak dari aplikasi nya
- executeUpdate(sql) mengembalikan `return int`, dimana ini biasanya mengembalikan berapa banyak record di database yang terkena impact perintah SQL kita, misal ketika kita mengirim perintah UPDATE, berapa banyak record yang berhasil ter-update 

# Statement.executeQuery(sql)

- Jika kita ingin `mengirim perintah SQL yang mengembalikan data`, maka kita bisa menggunakan method `executeQuery(sql)`
- Misalnya kita kirimkan perintah SELECT, dimana balikannya adalah data hasil select nya
- Method ini akan mengembalikan object java.sql.ResultSet, yaitu berisikan data-data hasil query SQL yang kita kirimkan
