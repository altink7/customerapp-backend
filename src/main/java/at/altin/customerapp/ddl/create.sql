DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS hibernate_sequence;
DROP TABLE IF EXISTS order_history;
DROP TABLE IF EXISTS order_item;
DROP TABLE IF EXISTS payment;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS promotion;
DROP TABLE IF EXISTS purchase_order;
DROP TABLE IF EXISTS review;
DROP TABLE IF EXISTS wishlist;

CREATE TABLE address (
                         id bigint NOT NULL,
                         city varchar(255),
                         country varchar(255),
                         state varchar(255),
                         street varchar(255),
                         type varchar(255),
                         zip_code varchar(255),
                         customer_id bigint,
                         PRIMARY KEY (id)
) ENGINE=MyISAM;

CREATE TABLE customer (
                          id bigint NOT NULL,
                          company bit NOT NULL,
                          email varchar(255),
                          image_url varchar(255),
                          name varchar(255),
                          phone varchar(255),
                          PRIMARY KEY (id)
) ENGINE=MyISAM;

CREATE TABLE hibernate_sequence (
    next_val bigint
) ENGINE=MyISAM;

INSERT INTO hibernate_sequence VALUES (1);

CREATE TABLE order_history (
                               id bigint NOT NULL,
                               customer_id bigint,
                               order_id bigint,
                               PRIMARY KEY (id)
) ENGINE=MyISAM;

CREATE TABLE order_item (
                            id bigint NOT NULL,
                            price double precision,
                            quantity integer,
                            product_id bigint,
                            purchase_order_id bigint,
                            PRIMARY KEY (id)
) ENGINE=MyISAM;

CREATE TABLE payment (
                         id bigint NOT NULL,
                         amount double precision,
                         payment_method varchar(255),
                         payment_status varchar(255),
                         transaction_id varchar(255),
                         order_id bigint,
                         PRIMARY KEY (id)
) ENGINE=MyISAM;

CREATE TABLE product (
                         id bigint NOT NULL,
                         brand varchar(255),
                         description varchar(255),
                         image_url varchar(255),
                         model varchar(255),
                         price varchar(255),
                         PRIMARY KEY (id)
) ENGINE=MyISAM;

CREATE TABLE promotion (
                           id bigint NOT NULL,
                           code varchar(255),
                           description varchar(255),
                           discount_amount double precision,
                           end_date date,
                           start_date date,
                           PRIMARY KEY (id)
) ENGINE=MyISAM;

CREATE TABLE purchase_order (
                                id bigint NOT NULL,
                                payment_method varchar(255),
                                payment_status varchar(255),
                                total_amount double precision,
                                customer_id bigint,
                                PRIMARY KEY (id)
) ENGINE=MyISAM;

CREATE TABLE review (
                        id bigint NOT NULL,
                        rating integer,
                        text varchar(255),
                        customer_id bigint,
                        product_id bigint,
                        PRIMARY KEY (id)
) ENGINE=MyISAM;

CREATE TABLE wishlist (
                          id bigint NOT NULL,
                          customer_id bigint,
                          product_id bigint,
                          PRIMARY KEY (id)
) ENGINE=MyISAM;

ALTER TABLE address
    ADD CONSTRAINT FK_address_customer_id
        FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE order_history
    ADD CONSTRAINT FK_order_history_customer_id
        FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE order_history
    ADD CONSTRAINT FK_order_history_order_id
        FOREIGN KEY (order_id) REFERENCES purchase_order (id);

ALTER TABLE order_item
    ADD CONSTRAINT FK_order_item_product_id
        FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE order_item
    ADD CONSTRAINT FK_order_item_purchase_order_id
        FOREIGN KEY (purchase_order_id) REFERENCES purchase_order (id);

ALTER TABLE payment
    ADD CONSTRAINT FK_payment_order_id
        FOREIGN KEY (order_id) REFERENCES purchase_order (id);

ALTER TABLE purchase_order
    ADD CONSTRAINT FK_purchase_order_customer_id
        FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE review
    ADD CONSTRAINT FK_review_customer_id
        FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE review
    ADD CONSTRAINT FK_review_product_id
        FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE wishlist
    ADD CONSTRAINT FK_wishlist_customer_id
        FOREIGN KEY (customer_id) REFERENCES customer (id);

ALTER TABLE wishlist
    ADD CONSTRAINT FK_wishlist_product_id
        FOREIGN KEY (product_id) REFERENCES product (id);