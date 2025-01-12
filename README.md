# ecommerce
Project Inditex ecommerce database

# Information
* Java 17
* Spring Boot 3.3.7

# Tools
* draw.io: https://app.diagrams.net/

# How to run the app
* Execute this command in the root folder of the project

mvn spring-boot:run

# Here’s how to use the API example with Postman or a browser based on the provided curl command
* curl -X GET http://localhost:8080/price?productId=35455&brandId=1&applicationDate=2020-06-14T10:00:00.000-00:00


* Response
{
    "productId": 35455,
    "brandId": 1,
    "rateId": 1,
    "applicationDate": "2020-06-14T10:00:00Z",
    "price": 35.5
}
```