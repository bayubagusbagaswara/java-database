# Date, Time, dan Timestamp

- Seperti kita ketahui, tipe tanggal dan waktu di database biasanya banyak, ada Date, Time, ada juga Timestamp
- Sedangkan di Java hanya terdapat tipe data java.util.Date
- Agar bisa menghandle hal ini, terdapat class-class turunan java.util.Data di package java.sql yang bernama Date, Time dan Timestamp
- Sesuai dengan namanya, class-class tersebut digunakan sebagai representasi di Java
- Secara otomatis JDBC bisa melakukan konversi tipe data tersebut dari database menjadi object di Java