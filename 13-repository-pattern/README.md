# Repository Pattern

- Dalam buku Domain-Driven Design, Eric Evans menjelaskan bahwa `repository is a mechanism for encapsulating storage, retrieval, and search behaior, which emulates a collection of objects`
- Pattern repository ini biasanya digunakan sebagai jembatan antar business logic aplikasi kita dengan semua perintah SQL ke database
- Jadi semua perintah SQL akan ditulis di Repository, sedangkan business logic kode program kita hanya cukup menggunakan Repository tersebut

# Repository vs DAO (Data Access Object)

- Jika teman-teman cari tutorial tentang Java Database, banyak juga yang menggunakan Data Access Object
- Secara garis besar, konsep Repository dan DAO hampir sama, yang membedakan Repository tidak menganggap bahwa storage itu hanya database, sedangkan biasanya kalau di DAO storage nya berupa database
- Jadi untuk kasus database, sebenarnya DAO lebih cocok. Namun karena sekarang lebih populer nama Repository Pattern, jadi sekarang kita akan gunakan Repository Pattern
- Jika berdebat dengan programmer lain, tentang Repository dan DAO, sebenarnya gak terlalu berguna, karena tujuan dua pattern itu sama, yakni untuk mengenkapsulasi cara mengakses data

# Entity atau Model

- Dalam pemrograman berorientasi object, biasanya sebuah table di database akan selalu dibuat representasinya sebagai class Entity atau Model
- Ini bisa mempermudah ketika membuat kode program
- Misal ketika kita query ke Repository, dibanding mengembalikan ResultSet, alangkah baiknya Repository melakukan konversi terlebih dahulu ke class Entity/Model, sehingga kita tinggal menggunakan objectnya saja