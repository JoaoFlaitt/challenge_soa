#!/usr/bin/env bash
set -euo pipefail

PROJECT_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
MIGRATIONS_DIR="$PROJECT_ROOT/src/main/resources/db/migration"
DB_NAME="careplus_nutrition"
DB_USER="root"
DB_PASS="root"

if ! command -v mysql >/dev/null 2>&1; then
  echo "mysql client não encontrado. Instale o pacote 'mysql-client' e tente novamente."
  exit 1
fi

echo "============================================"
echo "Criando banco de dados (se necessário)..."
echo "============================================"
mysql -u "$DB_USER" -p"$DB_PASS" -e "CREATE DATABASE IF NOT EXISTS ${DB_NAME} CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;"

echo "============================================"
echo "Aplicando migrations do diretório:"
echo "  $MIGRATIONS_DIR"
echo "============================================"

shopt -s nullglob
readarray -t migration_files < <(ls "$MIGRATIONS_DIR"/V*.sql | sort)
shopt -u nullglob

if [ ${#migration_files[@]} -eq 0 ]; then
  echo "Nenhum arquivo V*.sql encontrado em $MIGRATIONS_DIR"
  exit 1
fi

for file in "${migration_files[@]}"; do
  echo ">> Executando $(basename "$file")"
  mysql -u "$DB_USER" -p"$DB_PASS" "$DB_NAME" < "$file"
done

echo "============================================"
echo "Migrations executadas com sucesso!"
echo "============================================"

