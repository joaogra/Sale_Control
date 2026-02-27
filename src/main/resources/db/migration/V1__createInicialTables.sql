CREATE TYPE status_venda as ENUM ('Pendente', 'Paga');

CREATE TABLE IF NOT EXISTS customers(
    customer_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    customer_name VARCHAR(50) NOT NULL,
    email VARCHAR(30) ,
    phoneNumber VARCHAR(15)
    );

CREATE TABLE IF NOT EXISTS sales(
    sale_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    customer_id UUID REFERENCES customers(customer_id) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL (10,2) NOT NULL,
    paid_amount DECIMAL (10,2) NOT NULL,
    status status_venda NOT NULL
    );

CREATE TABLE IF NOT EXISTS products(
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(30) NOT NULL,
    price DECIMAL (10,2) NOT NULL
    );

CREATE TABLE IF NOT EXISTS product_sales(
    product_sale_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    product_id INT REFERENCES products(product_id) NOT NULL,
    sale_id UUID REFERENCES sales(sale_id) NOT NULL,
    un_price DECIMAL (10,2) NOT NULL,
    quantity INT NOT NULL
    );

