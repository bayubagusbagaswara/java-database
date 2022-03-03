# Metadata

- Kadang kita ingin mendapatkan informasi seputar database yang kita gunakan
- Informasi tersebut bernama MetaData
- Ada banyak jenis metadata, seperti DatabaseMetaData, ParameterMetaData, ResultSetMetaData

# DatabaseMetaData

DatabaseMetaData adalah informasi seputar seluruh database yang kita gunakan, seperti misalnya:

- Nama database
- Versi database
- Table yang ada di database
- dan lain-lain

Untuk membuat DatabaseMetaData, kita bisa menggunakan method `getMetaData()` dari object Connection

# ParameterMetadata

- ParameterMetadata adalah informasi seputar parameter yang terdapat di PreparedStatement
- Dengan PrameterMetadata, kita bisa mendapat banyak informasi parameter yang bisa digunakan untuk input di PreparedStatement, seperti berapa banyak parameter, tipe data parameter, dan lain-lain
- Namun perlu diperhatikan, beberapa Driver mungkin tidak mendukung untuk mendapatkan jenis tipe parameter di ParameterMetaData

# ResultSetMetaData

- ResultSetMetaData adalah informasi seputar hasil ResultSet
- Dengan ResultSetMetaData, kita bisa mendapatkan informasi tentang jumlah kolom, nama kolom, tipe data tiap kolom nya, dan lain-lain