# Spring CRUD (Create, Read, Update, Delete) Projesi
Bu repository Java Spring Boot kullanılarak CRUD işlemlerine ait bir proje örneğidir.  

Projede PostgreSQL ilişkisel veri tabanı kullanılmıştır. Veri tabanında e-ticaret örneği düşünülerek “kategori” ve “ürün” olmak üzere 2 adet birbiri ile ilişkili tablo oluşturulmuştur.  

Model katmanında bu 2 tablonun entitylerine ait sınıflar yer almaktadır. Burada tabloda yer almasını istediğimiz özellikler entitylere eklenmiştir.

Repository kısmında entitylerimizin veri tabanı işlemleri için spring’in sağlamış olduğu “JpaRepository” den kalıtım alınmıştır.  

Service katmanında ise iş mantığı ile ilgili kodlamalar yapılır. Burada CRUD işlemlerine ait tabloya veri girişi, tablodan veriyi okuma, tablodan veri silme, tablodaki veriyi güncelleme işlemlerine ait metodlar bulunmaktadır. Tablodan veri okuma için iki farklı metod oluşturulmuştur. Birincisi ile tabloda yer alan tüm veri okunur, ikincisi ile ise id’ye göre tekil veri okunması sağlanmıştır.  

Controller kısmında gelen requestlere göre ilgili service üzerinden entitylere ait response dönüşleri kararlaştırılmıştır.  

Postman kullanılarak tablolara veri girişi yapılmış ve tablolardaki verilerin okunması, güncellenmesi, silinmesi işlemleri yapılabildiği görülmüştür.

|METOD	| BAĞLANTI	                       | İŞLEM DETAYI                             |  
|-------|---------------------------------|------------------------------------------|
|POST	| /api/category/save	             | Kategori oluşturma endpoint’i            |
|DELETE	| /api/category/delete/{{id}}	    | Kategori silme endpoint’i                |
|GET	| /api/category/all	              | Tüm kategorileri listeleme endpoint’i    |
|GET	| /api/category/get/{{id}}	       | Id’ye göre kategori listeleme endpoint’i |
|PUT	| /api/category/update/{{id}}	    | Kategori güncelleme endpoint’i           |
|POST	| /api/product/save	              | Ürün oluşturma endpoint’i                |
|DELETE	| /api/v1/ product/delete/{{id}}	 | Ürün silme endpoint’i                    |
|GET	| /api/ product/all	              | Tüm ürünleri listeleme endpoint’i        |
|GET	| /api/product/get/{{id}}	        | Id’ye göre ürün listeleme endpoint’i                              |
|PUT	| /api/product/update/{{id}}	     | Ürün güncelleme endpoint’i      |