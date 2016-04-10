-- Last modification date: 2016-04-06 22:11:14.326

-- tables
-- Table customer
CREATE TABLE customer (
    id bigint  NOT NULL  AUTO_INCREMENT,
    code varchar(30)  NOT NULL,
    name varchar(200)  NOT NULL,
    address varchar(200)  NOT NULL,
    phone1 varchar(30)  NOT NULL,
    phone2 varchar(30) ,
    credit_limit decimal(30,2)  NOT NULL,
    current_credit decimal(30,2)  NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (id),
    UNIQUE (code)
);

-- Table `order`
CREATE TABLE sale_order (
    id bigint  NOT NULL  AUTO_INCREMENT,
    number1 varchar(30)  NOT NULL,
    customer_id bigint  NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id),
    UNIQUE (number1)
);

-- Table product
CREATE TABLE product (
    id bigint  NOT NULL  AUTO_INCREMENT,
    code varchar(30)  NOT NULL,
    description varchar(200)  NULL,
    price decimal(30,2)  NOT NULL,
    quantity int  NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id),
    UNIQUE (code)
);

-- Table products_in_order
CREATE TABLE products_in_order (
    id bigint  NOT NULL  AUTO_INCREMENT,
    product_id bigint  NOT NULL,
    order_id bigint  NOT NULL,
    quantity bigint NOT NULL,
    price_on_sell_moment decimal(30,2)  NOT NULL,
    CONSTRAINT products_in_order_pk PRIMARY KEY (id)
);


-- foreign keys

ALTER TABLE sale_order ADD CONSTRAINT customer_order_fk FOREIGN KEY (customer_id)
REFERENCES customer (id);

ALTER TABLE products_in_order ADD CONSTRAINT order_products_in_order_fk FOREIGN KEY (order_id)
REFERENCES sale_order (id);

ALTER TABLE products_in_order ADD CONSTRAINT product_products_in_order_fk FOREIGN KEY (product_id)
REFERENCES product (id);



-- End of file.

