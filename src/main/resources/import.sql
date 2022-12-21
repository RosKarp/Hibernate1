DROP TABLE IF EXISTS clients CASCADE;
DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS clients (id serial, title varchar(255), PRIMARY KEY (id));
INSERT INTO clients (title) VALUES ('Bob'), ('Jack'), ('John'), ('Bill');
CREATE TABLE IF NOT EXISTS products (id serial, title varchar(255), price INTEGER, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Bread', 10), ('Juice', 23), ('Oranges', 20), ('Milk', 18);
CREATE TABLE IF NOT EXISTS products_clients (product_id integer REFERENCES products (id), client_id integer REFERENCES clients (id));
INSERT INTO products_clients (product_id, client_id) VALUES (1, 3), (2, 4), (1, 1), (3, 2), (4, 1), (3, 4);