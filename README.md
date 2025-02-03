# Sipariş Yönetim Sistemi

---

## Proje Amacı

Bu proje, sipariş yönetim işlemlerini kolaylaştırmak ve RESTful API uygulamalarında thread yönetimi, veri işleme ve kaynak senkronizasyonu gibi temel kavramları öğrenmek amacıyla geliştirilmiştir. Proje, kullanıcıların siparişleri listeleme, yeni sipariş ekleme ve belirli bir siparişin detaylarını görüntüleme işlemlerini gerçekleştirmektedir.

---

## Temel Özellikler

- **Sipariş Listeleme:**  
  - `/orders/all` uç noktası ile, sayfalama destekli olarak siparişler listelenir.
  
- **Sipariş Ekleme:**  
  - `/orders/add-order` uç noktası üzerinden yeni siparişler oluşturulabilir.
  
- **Sipariş Detayları:**  
  - `/orders/{orderId}` uç noktası ile, belirtilen ID'ye sahip siparişin detayları görüntülenir.

---

## Kullanılan Teknolojiler

- **Spring Boot:** RESTful API geliştirme
- **Spring Data:** Sayfalama ve veri erişimi işlemleri
- **Spring MVC:** HTTP isteklerinin işlenmesi ve kontrolcülerin yönetimi
- **Java:** JDK 11 veya üzeri
- **Maven/Gradle:** Proje yönetimi ve derleme işlemleri
- **Veritabanı:** (Örnek olarak H2, MySQL veya PostgreSQL kullanılabilir – uygulamanın konfigürasyonuna bağlı)

---

## REST API Uç Noktaları

### 1. Siparişleri Listeleme

- **URL:** `/orders/all`  
- **HTTP Metodu:** GET  
- **Sorgu Parametreleri:**
  - `page` (varsayılan: 0)
  - `size` (varsayılan: 3)  
- **Açıklama:**  
  Sayfalama destekli olarak tüm siparişler listelenir.

### 2. Sipariş Ekleme

- **URL:** `/orders/add-order`  
- **HTTP Metodu:** POST  
- **İstek Gövdesi:**  
  Yeni siparişin bilgilerini içeren JSON formatında bir `OrderDto` nesnesi  
- **Açıklama:**  
  Yeni bir sipariş oluşturulur ve oluşturulan siparişin bilgileri döndürülür.

### 3. Sipariş Detaylarını Görüntüleme

- **URL:** `/orders/{orderId}`  
- **HTTP Metodu:** GET  
- **Yol Parametresi:**
  - `orderId` - Siparişin benzersiz ID'si  
- **Açıklama:**  
  Belirtilen ID'ye sahip siparişin detayları getirilir. Eğer sipariş bulunamazsa 404 Not Found döner.

---

## Kurulum ve Başlatma

### 1. Geliştirme Ortamını Ayarlayın

1. **IDE Seçimi:**  
   Projeyi IntelliJ IDEA, Eclipse, VS Code veya tercih ettiğiniz başka bir Java IDE'sinde geliştirin.  
   Java'nın Thread, Runnable, synchronized, Lock ve ReentrantLock gibi standart kütüphaneleri kullanılmaktadır.

1. **Projeyi Açma:**  
   IDE'nizde "File > Open" veya "File > Open Folder..." seçeneği ile proje klasörünü açın.

1. **Bağımlılıklar:**  
   Projede Maven veya Gradle kullanıyorsanız, `pom.xml` veya `build.gradle` dosyasındaki bağımlılıkların yüklü olduğundan emin olun.

### 2. Projeyi Çalıştırma

- **Derleme:**  
  IDE’nizde projeyi derleyin.  
  Maven kullananlar için:
  ```bash
    mvn clean install

- **Çalıştırma**

  IDE üzerinden "Run" veya "Debug" seçeneğini kullanarak uygulamayı başlatın.  
  Uygulama, varsayılan olarak 8080 portunda çalışacaktır.

- **Test Etme**

  API uç noktalarını Postman veya benzeri bir araçla test edebilirsiniz.  
  Örneğin:
  
  - Siparişleri listelemek için:  
    http://localhost:8080/orders/all?page=0&size=3
  
  - Yeni sipariş eklemek için:  
    http://localhost:8080/orders/add-order
  
  - Belirli bir siparişi görmek için:  
    http://localhost:8080/orders/1 (orderId yerine geçerli bir ID)
