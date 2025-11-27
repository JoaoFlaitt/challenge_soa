CarePlus Nutrition – Web Service SOA

Integrantes:
  Gabriel Souza Fiore – RM553710
  Guilherme Santiago – RM552321
  Miguel Leal Tasso – RM553009
  João Víctor Flaitt – RM553888
  Lucca Calsolari – RM553678
 

Este projeto implementa um sistema baseado em Arquitetura Orientada a Serviços (SOA) com integração via Web Services RESTful, seguindo boas práticas de modularização, segurança e interoperabilidade.

✔ Funcionalidades Principais
  API REST para autenticação, cadastro de usuários e registro de refeições.
  Integração externa com a API FatSecret para informações nutricionais.
  Conexão com banco de dados MySQL com JPA/Hibernate.
  Migração automática de tabelas via Hibernate.
  Estrutura modular separando:
    Controllers (apresentação) 
    Services (regra de negócio)
    Repositories (persistência)
    Entities (modelo de dados)

✔ Tecnologias Utilizadas
  Java 17
  Spring Boot 3
  Spring Web / WebFlux
  Spring Security + JWT
  MySQL / JPA / Hibernate
  Lombok
  OpenAPI (Swagger)

✔ Endpoints Principais
  Autenticação
    POST /api/auth/register
    POST /api/auth/login
    Usuários / Perfil / Refeições
    GET /api/users/...
    POST /api/meals/...

✔ Pré-requisitos
  Java 17 ou superior
  Maven 3.6+
  MySQL 8.0+ instalado e rodando
  MySQL configurado com usuário 'root' e senha 'root' (ou ajuste no application.yml)

✔ Configuração e Execução

  1. Configurar o Banco de Dados MySQL
     Certifique-se de que o MySQL está rodando:
       sudo systemctl status mysql
       # ou
       sudo systemctl start mysql

  2. Criar o Banco de Dados e Executar Migrations
     Execute o script de migrations para criar todas as tabelas:
       cd soa_corrigido
       chmod +x scripts/run_db_migrations.sh
       ./scripts/run_db_migrations.sh

     Este script irá:
       - Criar o banco de dados 'careplus_nutrition' (se não existir)
       - Executar todas as migrations em ordem (V1, V2, V3, V4)
       - Criar todas as tabelas necessárias

  3. Verificar Configuração do Banco
     O arquivo application.yml já está configurado com:
       - URL: jdbc:mysql://localhost:3306/careplus_nutrition
       - Usuário: root
       - Senha: root
     
     Se suas credenciais forem diferentes, edite:
       src/main/resources/application.yml

  4. Compilar e Executar a Aplicação
     Execute:
       mvn clean install
       mvn spring-boot:run

  5. Acessar a Aplicação
     Swagger UI: http://localhost:8080/swagger-ui.html
     API Base: http://localhost:8080/api

✔ Troubleshooting

  Erro: "Access denied for user 'root'@'localhost'"
    - Verifique se o MySQL está rodando
    - Confirme que o usuário 'root' existe e a senha está correta
    - Teste a conexão manualmente: mysql -u root -p

  Erro: "Table 'users' already exists"
    - O script de migrations usa DROP TABLE IF EXISTS, então pode ser executado múltiplas vezes
    - Se persistir, execute manualmente: mysql -u root -p careplus_nutrition < src/main/resources/db/migration/V1__create_users_profile.sql

  Erro: "Unable to build Hibernate SessionFactory"
    - Verifique se o banco de dados foi criado
    - Execute novamente o script de migrations: ./scripts/run_db_migrations.sh
    - Verifique se todas as migrations foram executadas com sucesso

  Aplicação não inicia
    - Verifique os logs para identificar o erro específico
    - Confirme que a porta 8080 está livre
    - Verifique se todas as dependências foram baixadas: mvn clean install

✔ Estrutura SOA e Boas Práticas
  Serviços independentes, modularizados e reutilizáveis.
  Padrões REST e JSON.
  Validação de entrada e JWT para segurança.
  Arquitetura pronta para escalar e integrar novos módulos.

✔ Correções e Melhorias Implementadas

  Problemas Identificados e Resolvidos:
  
  1. Erro de Conexão com Banco de Dados
     - Problema: "Access denied for user 'root'@'localhost'"
     - Causa: Credenciais incorretas ou banco não configurado
     - Solução: Configuração padronizada no application.yml e script de migrations

  2. Script de Migration Corrompido
     - Problema: V1__create_users_profile.sql tinha SQL duplicado e malformado
     - Causa: Arquivo continha comandos CREATE TABLE duplicados na mesma linha
     - Solução: Script corrigido com DROP TABLE IF EXISTS e estrutura limpa

  3. Falta de Processo de Setup
     - Problema: Não havia forma automatizada de criar o banco e tabelas
     - Solução: Script run_db_migrations.sh que cria banco e executa todas as migrations

  4. Flyway Desabilitado
     - Problema: Flyway estava desabilitado, então migrations não rodavam automaticamente
     - Solução: Script manual de migrations + Hibernate ddl-auto=update como backup

  Arquivos Criados/Modificados:
    - scripts/run_db_migrations.sh: Script para executar todas as migrations
    - src/main/resources/db/migration/V1__create_users_profile.sql: Corrigido
    - src/main/resources/application.yml: Credenciais padronizadas
