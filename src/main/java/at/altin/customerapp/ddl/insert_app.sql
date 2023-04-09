-- insert data into address table
INSERT INTO address (id, city, country, state, street, type, zip_code, customer_id) VALUES
                                                                                        (1, 'New York City', 'USA', 'New York', '5th Ave', 'Billing', '10001', 1),
                                                                                        (2, 'San Francisco', 'USA', 'California', 'Market St', 'Shipping', '94103', 2),
                                                                                        (3, 'Los Angeles', 'USA', 'California', 'Hollywood Blvd', 'Billing', '90028', 3),
                                                                                        (4, 'London', 'UK', 'England', 'Baker St', 'Shipping', 'NW1 6XE', 4),
                                                                                        (5, 'Paris', 'France', 'Ile-de-France', 'Champs-Élysées', 'Shipping', '75008', 5);

-- insert data into customer table
INSERT INTO customer (id, company, email, image_url, name, phone) VALUES
                                                                      (1, 0, 'john.doe@example.com', 'https://example.com/johndoe.jpg', 'John Doe', '+1-555-555-1234'),
                                                                      (2, 1, 'acme@example.com', 'https://example.com/acme.jpg', 'Acme Inc.', '+1-555-555-5678'),
                                                                      (3, 0, 'jane.doe@example.com', 'https://example.com/janedoe.jpg', 'Jane Doe', '+1-555-555-9101'),
                                                                      (4, 1, 'globex@example.com', 'https://example.com/globex.jpg', 'Globex Corporation', '+44-20-7123-4567'),
                                                                      (5, 0, 'james.smith@example.com', 'https://example.com/jamessmith.jpg', 'James Smith', '+33-1-2345-6789');

-- insert data into order_history table
INSERT INTO order_history (id, customer_id, order_id) VALUES
                                                          (1, 1, 1001),
                                                          (2, 2, 1002),
                                                          (3, 3, 1003),
                                                          (4, 4, 1004),
                                                          (5, 5, 1005);

-- insert data into order_item table
INSERT INTO order_item (id, price, quantity, product_id, purchase_order_id) VALUES
                                                                                (1, 12.99, 2, 1, 1001),
                                                                                (2, 9.99, 1, 2, 1001),
                                                                                (3, 24.99, 1, 3, 1002),
                                                                                (4, 8.99, 3, 4, 1003),
                                                                                (5, 17.49, 2, 5, 1004);

-- insert data into payment table
INSERT INTO payment (id, amount, payment_method, payment_status, transaction_id, order_id) VALUES
                                                                                               (1, 25.98, 'credit_card', 'completed', 'abc123', 1001),
                                                                                               (2, 24.99, 'paypal', 'completed', 'xyz789', 1002),
                                                                                               (3, 26.97, 'credit_card', 'completed', 'def456', 1003),
                                                                                               (4, 34.98, 'paypal', 'completed', 'mno456', 1004),
                                                                                               (5, 27.98, 'credit_card', 'completed', 'pqr789', 1005);

-- insert data into product table
INSERT INTO product (id, brand, description, image_url,model, price) VALUES
                                                                         (1, 'Apple', 'iPhone 13 Pro', 'https://example.com/iphone13pro.jpg', 'A2563', '1099.00'),
                                                                         (2, 'Samsung', 'Galaxy S22 Ultra', 'https://example.com/s22ultra.jpg', 'S128G', '1299.00'),
                                                                         (3, 'Google', 'Pixel 6 Pro', 'https://example.com/pixel6pro.jpg', 'G256P', '999.00'),
                                                                         (4, 'OnePlus', '9 Pro', 'https://example.com/oneplus9pro.jpg', 'OP9P', '899.00'),
                                                                         (5, 'Xiaomi', 'Mi 12', 'https://example.com/mi12.jpg', 'X256M', '799.00');

INSERT INTO promotion (id, code, description, discount_amount, end_date, start_date) VALUES
                                                                                        (1,'PROMO10', 'Get 10% off on your first purchase', 10.0, '2023-06-30', '2023-03-01'),
                                                                                        (2, 'SPRINGSALE', 'Spring Sale: Up to 20% off on all items', 20.0, '2023-04-30', '2023-04-01'),
                                                                                        (3, 'FREESHIPPING', 'Free shipping on orders over $50', null, null, '2023-03-15');

-- insert data into purchase_order table
INSERT INTO purchase_order (id, payment_method, payment_status, total_amount, customer_id) VALUES
                                                                                               (1, 'Credit Card', 'Pending', 100.00, 1),
                                                                                               (2, 'PayPal', 'Complete', 50.00, 2),
                                                                                               (3, 'Cash', 'Cancelled', 75.00, 3);

-- insert data into review table
INSERT INTO review (id, rating, text, customer_id, product_id) VALUES
                                                                   (1, 4, 'Great product, highly recommend!', 1, 1),
                                                                   (2, 2, 'Not very satisfied with this product', 2, 2),
                                                                   (3, 5, 'Absolutely love this product!', 3, 1);

-- insert data into wishlist table
INSERT INTO wishlist (id, customer_id, product_id) VALUES
                                                       (1, 1, 2),
                                                       (2, 2, 3),
                                                       (3, 3, 1);