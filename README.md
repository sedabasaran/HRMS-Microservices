# Genel Bakış
Bu proje, Departman Servisi ve Çalışan Servisi olmak üzere iki mikroservis içerir.

Departman Servisi departmanları ve bunlara bağlı çalışanları yönetir.
Çalışan Servisi çalışan kayıtlarını yönetir ve departmana göre sorgulama yapar.
Gereksinimler
Java 17 veya daha yenisi
Maven 3.6 veya daha yenisi
Docker (isteğe bağlı, konteynerizasyon için)
PostgreSQL (veya başka bir veritabanı, yapılandırılmışsa)
Başlarken
Depoyu Klonlayın

bash
git clone https://github.com/your-repo/department-employee-microservices.git
cd department-employee-microservices
Projeyi Derleyin

Her mikroservis dizinine gidip projeyi Maven ile derleyin:

bash
cd department-service
mvn clean install

cd ../employee-service
mvn clean install
Mikroservisleri Çalıştırın

Her mikroservisi ayrı ayrı çalıştırabilirsiniz:

bash
# Departman Servisi için
cd department-service
mvn spring-boot:run

# Çalışan Servisi için
cd ../employee-service
mvn spring-boot:run
Alternatif olarak, Docker kullanıyorsanız, imajları oluşturup konteynerleri çalıştırabilirsiniz:

bash
# Docker imajlarını oluştur
docker build -t department-service -f department-service/Dockerfile .
docker build -t employee-service -f employee-service/Dockerfile .

# Docker konteynerlerini çalıştır
docker run -p 8080:8080 department-service
docker run -p 8081:8081 employee-service

Overview
This project includes two microservices: Department Service and Employee Service.

Department Service manages departments and their associated employees.
Employee Service handles employee records and allows querying based on department.
Prerequisites
Java 17 or later
Maven 3.6 or later
Docker (optional, for containerization)
PostgreSQL (or any other database if configured)
Getting Started
Clone the Repository

bash
git clone https://github.com/your-repo/department-employee-microservices.git
cd department-employee-microservices
Build the Project

Navigate to each microservice directory and build the project using Maven:

bash
cd department-service
mvn clean install

cd ../employee-service
mvn clean install
Run the Microservices

You can run each microservice individually using:

bash
# For Department Service
cd department-service
mvn spring-boot:run

# For Employee Service
cd ../employee-service
mvn spring-boot:run
Alternatively, if you are using Docker, build and run the containers:

bash
# Build Docker images
docker build -t department-service -f department-service/Dockerfile .
docker build -t employee-service -f employee-service/Dockerfile .

# Run Docker containers
docker run -p 8080:8080 department-service
docker run -p 8081:8081 employee-service

![Ekran Resmi 2024-07-29 00 13 16](https://github.com/user-attachments/assets/20b2589a-6598-4a0c-903d-70e5f1061afc)

![Ekran Resmi 2024-07-29 00 14 28](https://github.com/user-attachments/assets/99feb19f-dfe8-43b8-a6a0-1d6bfcf01c72)

![Ekran Resmi 2024-07-29 00 14 47](https://github.com/user-attachments/assets/46efb874-bc54-47b5-88a9-86766dc1a67a)

![Ekran Resmi 2024-07-29 00 16 33](https://github.com/user-attachments/assets/6de93ad4-8d4b-4621-8a5f-2d03a496e5de)




