# Request dan Response

- Secara default, komunikasi antara database dan aplikasi Java kita adalah request dan response
- Artinya, setiap kali kita mengirim perintah SQL, maka aplikasi kita akan menunggu sampai database melakukan response dari perintah SQL tersebut
- Proses tersebut kadang terlalu chatty kalau tujuan kita misal ingin mengirim data secara banyak ke database

# Batch Process

- Batch process adalah proses pengiriman perintah secara banyak sekaligus
- Biasanya batch process dilakukan dalam kasus tertentu saja, misal ketika kita ingin mengirim import data dari file excel ke database yang jumlahnya jutaan
- Biasanya dalam batch process, yang diutamakan adalah kecepatan, karena jika perintah SQL nya di execute satu per satu dan menunggu response satu per satu, maka sudah pasti akan sangat lambat sekali

# Batch Process di JDBC

- JDBC mendukung proses eksekusi perintah SQL secara batch di Statement ataupun di PreparedStatement
- Di Statement, terdapat method `addBatch(sql)` untuk menambahkan perintah ke proses batch
- Sedangkan di PreparedStatement terdapat method addBatch() untuk menambahkan proses ke batch, lalu bisa gunakan method clearParameters() untuk menghapus parameter input user sebelumnya
- Setelah proses batch selesai, untuk mengeksekusinya kita bisa gunakan perintah executeBatch()

# PERINGATAN

- Proses batch akan disimpan di memory sebelum dikirim ke database
- Oleh karena itu, bijaklah membuat proses batch, jangan terlalu banyak menambahkan ke batch, misal per 100 atau per 1000
- Jika sudah mencapai 100 atau 1000, maka kita bisa mengirim batch tersebut menggunakan perintah executeBatch()