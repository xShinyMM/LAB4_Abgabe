CREATE TABLE orders (
    id BIGINT PRIMARY KEY,
    product_id BIGINT,
    user_id BIGINT,
    quantity INT
);