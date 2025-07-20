#!/bin/bash

# Wait for PostgreSQL to be ready
echo "Waiting for PostgreSQL to start..."
until pg_isready -h localhost -U meli; do
  echo "PostgreSQL is unavailable - sleeping"
  sleep 1
done

echo "PostgreSQL is up - executing initialization script"

# Run the initialization script
psql -U meli -d meli -f /docker-entrypoint-initdb.d/init-db.sql

echo "Database initialization completed"