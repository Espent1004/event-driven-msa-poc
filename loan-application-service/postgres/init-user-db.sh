#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE loanapplications;
    GRANT ALL PRIVILEGES ON DATABASE loanapplications TO dbuser;
    CREATE DATABASE altinndata;
    GRANT ALL PRIVILEGES ON DATABASE altinndata TO dbuser;
EOSQL
