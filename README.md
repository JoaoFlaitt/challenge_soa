# 📘 CarePlus Nutrition – Web Service SOA

Integrantes
  Gabriel Souza Fiore – RM553710
  Guilherme Santiago – RM552321
  Miguel Leal Tasso – RM553009
  João Víctor Flaitt – RM553888
  Lucca Calsolari – RM553678

📝 Descrição
O **CarePlus Nutrition** é um sistema baseado em arquitetura **SOA**, fornecendo serviços RESTful para autenticação, gerenciamento de usuários, registro de refeições e integração com a API FatSecret. A aplicação utiliza MySQL para persistência e segue uma estrutura modular clara com camadas organizadas.

 🛠 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3**
- **Spring Web**
- **Spring Security + JWT**
- **MySQL 8**
- **JPA / Hibernate**
- **Lombok**
- **Swagger / OpenAPI**

 📡 Endpoints Principais

 🔐 Autenticação
- `POST /api/auth/register`
- `POST /api/auth/login`

 👤 Usuários e 🍽 Refeições
- `GET /api/users/...`
- `POST /api/meals/...`

 📌 Pré-requisitos
- **Java 17** instalado  
- **Maven 3.6+**  
- **MySQL 8** rodando  
- Credenciais padrão esperadas:  
  - Usuário: `root`  
  - Senha: `root`  

 🚀 Como Executar o Projeto

 1️⃣ Criar o Banco de Dados
O projeto inclui um script SQL para criação do banco:

2️⃣ Executar a Aplicação
bash

mvn clean install
mvn spring-boot:run

 🌐 Acesso à Aplicação
Swagger UI: http://localhost:8080/swagger-ui.html

API Base: http://localhost:8080/api

🗂 Estrutura do Projeto
pgsql
Copiar código
CHALLENGE_CAREPLUS/
 ├── .vscode/
 ├── scripts/
 ├── src/
 │   └── main/
 │       ├── java/br/com/careplus/nutrition/
 │       │    ├── config
 │       │    ├── controller
 │       │    ├── domain
 │       │    ├── dto
 │       │    ├── exception
 │       │    ├── security
 │       │    ├── service
 │       │    └── CarePlusNutritionApplication.java
 │       └── resources/
 ├── setup_database.sql
 ├── test_connection.sh
 ├── pom.xml
 └── README.md
🗄 Banco de Dados
O banco de dados é configurado via:

setup_database.sql — criação das tabelas e estrutura inicial

test_connection.sh — validação da conexão

application.yml — configurações JDBC (URL, usuário, senha, driver, etc.)

📚 Arquitetura do Projeto
O sistema segue boas práticas de SOA e organização por camadas:

Config — Configurações gerais da aplicação

Controller — Endpoints REST

Domain — Entidades e lógica de domínio

DTO — Modelos de transferência de dados

Exception — Tratamento de erros e respostas personalizadas

Security — JWT, autenticação e filtros de segurança

Service — Regras de negócio