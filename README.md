# 🚀 REST API com Spring Boot – Projeto de Estudos

Este repositório contém um projeto completo de **API REST construída com Spring Boot**, desenvolvido como parte do curso:

👉 **RESTFul APIs do 0 à Nuvem com Spring Boot e Docker (Udemy)**  
https://www.udemy.com/course/restful-apis-do-0-a-nuvem-com-springboot-e-docker/learn/

O projeto implementa uma API robusta seguindo boas práticas corporativas, com suporte a:

- CRUD completo
- Paginação + Ordenação (Sort)
- Versionamento de DTO (v1 e v2)
- HATEOAS
- Flyway para versionamento de banco
- MySQL como banco de dados
- Camadas Controller → Service → Repository
- Mapeamento com Dozer Mapper

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.5**
- Spring Web
- Spring Data JPA
- Spring HATEOAS
- Springdoc OpenAPI (Swagger UI)
- Flyway
- MySQL 8+
- Dozer Mapper
- Maven

---

## 📁 Estrutura do Projeto

src/
└── main/  
├── java/com/brunohfc/restapi205/demo  
│ ├── controller/  
│ ├── data/dto/v1/  
│ ├── data/dto/v2/  
│ ├── mapper/  
│ ├── model/  
│ ├── repository/  
│ ├── services/  
│ └── DemoApplication.java  
├── resources/  
│ ├── application.yml  
│ └── db/migration/  
└── infra/ ← 📌 Instruções para configurar o MySQL

---

## 🗄️ Banco de Dados – MySQL

Este projeto utiliza MySQL como SGBD.  
📌 **Antes de rodar a aplicação, o MySQL deve estar ligado.**

No diretório:

você encontrará **todas as instruções e scripts** para:

- Criar o banco `person_api`
- Criar usuário
- Permissões
- Configuração completa

### Configuração usada no `application.yml`

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/person_api?useTimezone=true&serverTimezone=UTC
    username: root
    password: root_password
````

## 🧬 Flyway – Migrations Automáticas

As migrations ficam em:

    src/main/resources/db/migration

Flyway roda automaticamente na inicialização.

Exemplos:

- V1__Create_Person_Table.sql

- V2__Insert_Initial_Data.sql

- V3__Update_Schema.sql

- V4__Insert_Many_People.sql

---
##  👤 Funcionalidades da API

### ✔ CRUD completo de pessoas

Endpoints principais:

- GET    /api/person/v1  
- GET    /api/person/v1/{id}  
- POST   /api/person/v1/create  
- PUT    /api/person/v1/{id}  
- DELETE /api/person/v1/{id}  
- PATCH  /api/person/v1/{id}   ← desabilita pessoa  

### ✔ Paginação + Ordenação

Exemplo:

    GET /api/person/v1?page=0&size=10&direction=asc

Ordenação é feita por:

    Sort.by(Sort.Direction.ASC, "nome");

### ✔ Versionamento de DTO

- v1 → PersonDTO
- v2 → PersonDTOV2

### ✔ HATEOAS implementado

Cada resposta possui links como:
``` json
    "_links": {
        "self": {...},
        "create": {...},
        "delete": {...}
    }
```

### 📚 Documentação da API (Swagger UI)

Após rodar o projeto, acesse:

    http://localhost:8080/swagger-ui.html

Ou:

    http://localhost:8080/swagger-ui/index.html

## ▶️ Como Rodar o Projeto  
### 1️⃣ Inicie o MySQL com container

 1) Acesse o arquivo _mysql-db.yml_ no diretório
 
        demo/src/main/infra/mysql-db.yml

2) Faça a configuração do banco de dados
3) Rode o projeto, pois, com o Flyway irá inserir os dados na tabela _person_ 

---

## 🧠 Conceitos praticados

- REST + boas práticas
- DTO + versionamento
- HATEOAS
- Paginação + ordenação
- Flyway
- Exceções personalizadas
- Atualização parcial (PATCH)
- Mapper (Dozer)
- Service Layer padrão corporativo

---
## 📘 Fonte de estudo

Curso utilizado:  
➡ RESTFul APIs do 0 à Nuvem com Spring Boot e Docker
https://www.udemy.com/course/restful-apis-do-0-a-nuvem-com-springboot-e-docker/learn/

---
## 👨‍💻 Autor

**Bruno Henrick**  
Estudante e desenvolvedor em evolução, com foco em back-end e boas práticas de arquitetura.



