# Driver

- Driver adalah jembatan penghubung antara JDBC dan Database Management System yang akan kita gunakan
- Sebenarnya Driver itu berisikan class-class implementasi dari interface yang terdapat di JDBC
- Tanpa menggunakan Driver, maka JDBC kita tidak bisa terkoneksi ke DBMS
- Driver di JDBC direpresentasikan oleh interface `java.sql.Driver`

# MySQL Driver

- MySQL sudah menyediakan driver untuk JDBC
- Kita bisa cari MySQL Driver dengan menggunakan kata kunci `mysql-connector-java`
- Lalu tambahkan ke dependency project kita

# Registrasi Driver ke JDBC

- Setelah menambah dependency MySQL Driver ke project kita
- Kita perlu melakukan registrasi Driver terlebih dahulu
- Untuk melakukan registrasi driver, kita bisa menggunakan static method `registerDriver()` milik class java.sql.DriverManager