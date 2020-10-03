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

#CREATE TABLE public.loan_application
#(
#    product_type text COLLATE pg_catalog."default" NOT NULL,
#    case_id bigint,
#    user_id bigint NOT NULL,
#    order_id integer NOT NULL DEFAULT nextval('loan_application_order_id_seq'::regclass),
#    CONSTRAINT loan_application_pkey PRIMARY KEY (order_id)
#)
#
#TABLESPACE pg_default;
#
#ALTER TABLE public.loan_application
#    OWNER to dbuser;
