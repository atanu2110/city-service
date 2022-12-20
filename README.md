# Sample REST CRUD API with Spring Boot, H2, and JPA

#### Prerequisite 

Installed:   
[Docker](https://www.docker.com/)   
[git](https://www.digitalocean.com/community/tutorials/how-to-contribute-to-open-source-getting-started-with-git)  

## Steps to Setup

**1. Clone the application**

```
$  git clone  https://github.com/atanu2110/city-service.git
```

**2. Build project using Maven**

```
$ mvn clean install -DskipTests
```

**3. Build docker image**

```
docker build -t city-service .
```

**4. Run docker image**

```
docker run -p 8085:8085 city-service
```

The app will start running at <http://localhost:8085>

## Api Documentation (Swagger)

<http://localhost:8085/swagger-ui/#/>