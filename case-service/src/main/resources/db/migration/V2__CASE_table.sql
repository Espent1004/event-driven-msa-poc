CREATE TABLE public."loan_case"
(
    case_id bigserial NOT NULL,
    product_type text NOT NULL,
    PRIMARY KEY (case_id)
);

ALTER TABLE public."loan_case"
    OWNER to dbuser;
