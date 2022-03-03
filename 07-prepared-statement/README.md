# Prepared Statement

- PreparedStatement adalah turunan dari Statement, jadi apapun yang bisa dilakukan Statement, bisa juga dilakukan oleh PreparedStatement
- Yang membedakan PreparedStatement dari Statement adalah PreparedStatement memiliki kemampuan untuk mengamankan input dari user sehingga aman dari serangan SQL Injection

# Membuat PreparedStatement

- Berbeda dengan Statement, pada PreparedStatement, ketika pembuatannya, sudah ditentukan SQL apa yang akan kita gunakan
- Oleh karena itu, PreparedStatement biasanya digunakan untuk sekali mengirim perintah SQL, jika ingin mengirim perintah SQL lagi, kita harus membuat PreparedStatement baru
- Untuk membuat PreparedStatement, kita bisa menggunakan method prepareStatement(sql) milik Connection

# Menerima Input User

- Sekarang pertanyaannya, bagaimana cara menerima input user menggunakan PreparedStatement?
- Untuk menerima input dari user, SQL yang kita buat harus diubah juga
- Input dari user, perlu kita ubah menjadi `? (tanda tanya)`
- Nanti ketika pembuatan object, kita bisa subtitusi datanya menggunakan setXxx(index, value) sesuai dengan tipe datanya, misal `setString()`, `setInt()` dan lain-lain