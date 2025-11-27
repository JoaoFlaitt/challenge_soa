-- Script para configurar o banco de dados
-- Execute este script como root no MySQL

-- Criar o banco de dados se não existir
CREATE DATABASE IF NOT EXISTS careplus_nutrition 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

-- Garantir que o usuário root tem todas as permissões
GRANT ALL PRIVILEGES ON careplus_nutrition.* TO 'root'@'localhost';
FLUSH PRIVILEGES;

-- Verificar se o banco foi criado
SHOW DATABASES LIKE 'careplus_nutrition';

