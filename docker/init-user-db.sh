#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE loanapplications;
    GRANT ALL PRIVILEGES ON DATABASE loanapplications TO dbuser;
    CREATE DATABASE altinn;
    GRANT ALL PRIVILEGES ON DATABASE altinn TO dbuser;
    CREATE DATABASE cases;
    GRANT ALL PRIVILEGES ON DATABASE cases TO dbuser;
    CREATE DATABASE customers;
    GRANT ALL PRIVILEGES ON DATABASE customers TO dbuser;
EOSQL
