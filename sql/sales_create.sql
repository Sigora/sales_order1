-- Last modification date: 2016-04-04 22:11:14.326

-- tables
-- Table customer
CREATE TABLE customer (
    id bigint  NOT NULL  AUTO_INCREMENT,
    code varchar(30)  NOT NULL,
    name varchar(200)  NOT NULL,
    phone1 bigint  NOT NULL,
    phone2 bigint  NULL,
    credit_limit decimal(30,2)  NOT NULL,
    current_credit decimal(30,2)  NOT NULL,
    CONSTRAINT customer_pk PRIMARY KEY (id)
);

-- Table `order`
CREATE TABLE `order` (
    id bigint  NOT NULL  AUTO_INCREMENT,
    customer_id bigint  NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table product
CREATE TABLE product (
    id bigint  NOT NULL  AUTO_INCREMENT,
    code varchar(30)  NOT NULL,
    description varchar(200)  NULL,
    price decimal(30,2)  NOT NULL,
    quantity int  NOT NULL,
    CONSTRAINT product_pk PRIMARY KEY (id)
);

-- Table products_in_order
CREATE TABLE products_in_order (
    product_id bigint  NOT NULL,
    order_id bigint  NOT NULL,
    CONSTRAINT products_in_order_pk PRIMARY KEY (product_id,order_id)
);


-- foreign keys
-- Reference:  customer_order (table: customer)

ALTER TABLE customer ADD CONSTRAINT customer_order FOREIGN KEY customer_order (id)
    REFERENCES `order` (customer_id);
-- Reference:  order_products_in_order (table: `order`)

ALTER TABLE `order` ADD CONSTRAINT order_products_in_order FOREIGN KEY order_products_in_order (id)
    REFERENCES products_in_order (order_id);
-- Reference:  product_products_in_order (table: product)

ALTER TABLE product ADD CONSTRAINT product_products_in_order FOREIGN KEY product_products_in_order (id)
    REFERENCES products_in_order (product_id);



-- End of file.

