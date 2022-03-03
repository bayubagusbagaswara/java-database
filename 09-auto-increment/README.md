# Auto Increment

- Kadang setelah melakukan INSERT data ke database yang memiliki primary key auto increment, kita ingin `mendapatkan data id terbarunya`
- Di MySQL sebenarnya kita bisa melakukan query `SELECT LAST_INSERT_ID()`. Namun berarti kita harus melakukan query ulang dengan Statement dan melakukan iterasi lagi dengan ResultSet
- Untungnya di JDBC, ada kemampuan untuk mendapatkan auto generate data seperti `auto increment` dengan method `getGenerateKeys()` yang mengembalikan ResultSet
- Selanjutnya kita bisa melakukan iterasi terhadap ResultSet tersebut

# Mendapatkan Auto Generated Key

- Secara default, Statement ataupun PreparedStatement tidak mengerti untuk mengambil auto generate key
- Kita perlu memberi tahunya agar Statement ataupun PreparedStatement agar mengambil auto generate id secara otomatis
- Untuk Statement, kita perlu memberi tahu ketika memanggil method `executeUpdate(sql, Statement.RETURN_GENERATED_KEYS)`
- Sedangkan untuk PreparedStatement, kita perlu memberi tahu ketika membuat `preparedStatement(sql, Statement.RETURN_GENERATED_KEYS)`
- Setelah itu, untuk mendapatkan auto generate key, kita bisa menggunakan method `getGeneratedKeys()`, method ini akan error jika kita lupa mengirim parameter generated keys