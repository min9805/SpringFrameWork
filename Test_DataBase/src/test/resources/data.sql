-- data.sql

INSERT INTO user (name, email) VALUES
   ('John Doe', 'john@example.com'),
   ('Jane Smith', 'jane@example.com');

INSERT INTO product (user_id, name, description, price) VALUES
    (1, 'Product 1', 'Product 1 Description', 100),
    (2, 'Product 2', 'Product 2 Description', 200);
