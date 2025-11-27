#!/bin/bash

# Script para testar conexão com MySQL

echo "=== Testando conexão com MySQL ==="
echo ""

# Testar conexão
mysql -u root -proot -e "SELECT 1;" 2>/dev/null

if [ $? -eq 0 ]; then
    echo "✅ Conexão com MySQL bem-sucedida!"
    echo ""
    echo "Verificando se o banco de dados existe..."
    mysql -u root -proot -e "SHOW DATABASES LIKE 'careplus_nutrition';" 2>/dev/null
    
    if [ $? -eq 0 ]; then
        echo "✅ Banco de dados 'careplus_nutrition' existe!"
    else
        echo "⚠️  Banco de dados não encontrado. Execute o script setup_database.sql"
    fi
else
    echo "❌ Erro ao conectar ao MySQL"
    echo ""
    echo "Possíveis causas:"
    echo "1. Senha incorreta"
    echo "2. MySQL não está rodando"
    echo "3. Usuário root não tem permissões"
    echo ""
    echo "Para verificar se o MySQL está rodando:"
    echo "  sudo systemctl status mysql"
    echo ""
    echo "Para iniciar o MySQL:"
    echo "  sudo systemctl start mysql"
fi

