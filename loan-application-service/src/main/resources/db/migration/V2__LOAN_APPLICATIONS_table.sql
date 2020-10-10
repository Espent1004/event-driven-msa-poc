CREATE TABLE public."loan_application"
(
    product_type text NOT NULL,
    order_id bigserial NOT NULL,
    case_id bigint,
    user_id bigint NOT NULL,
    PRIMARY KEY (order_id)
);

ALTER TABLE public."loan_application"
    OWNER to dbuser;
