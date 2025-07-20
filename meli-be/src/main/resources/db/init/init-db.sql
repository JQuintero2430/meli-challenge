-- Script to initialize the database with sample data

-- Insert payment methods if table exists and is empty
INSERT INTO payment_methods (type, provider, is_active, country_code)
SELECT 'CREDIT_CARD', 'Visa', true, 'AR'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'payment_methods')
  AND (SELECT COUNT(*) FROM payment_methods) = 0;

INSERT INTO payment_methods (type, provider, is_active, country_code)
SELECT 'CREDIT_CARD', 'Mastercard', true, 'AR'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'payment_methods')
  AND (SELECT COUNT(*) FROM payment_methods) <= 1;

INSERT INTO payment_methods (type, provider, is_active, country_code)
SELECT 'DEBIT_CARD', 'Visa', true, 'AR'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'payment_methods')
  AND (SELECT COUNT(*) FROM payment_methods) <= 2;

INSERT INTO payment_methods (type, provider, is_active, country_code)
SELECT 'DEBIT_CARD', 'Mastercard', true, 'AR'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'payment_methods')
  AND (SELECT COUNT(*) FROM payment_methods) <= 3;

INSERT INTO payment_methods (type, provider, is_active, country_code)
SELECT 'MERCADO_PAGO', 'MercadoPago', true, 'AR'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'payment_methods')
  AND (SELECT COUNT(*) FROM payment_methods) <= 4;

-- Insert users if table exists and is empty
INSERT INTO users (username, profile_image_url, email, created_at, is_active, country_code)
SELECT 'johndoe', 'https://example.com/images/users/johndoe.jpg', 'john.doe@example.com', NOW(), true, 'AR'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'users')
  AND (SELECT COUNT(*) FROM users) = 0;

INSERT INTO users (username, profile_image_url, email, created_at, is_active, country_code)
SELECT 'janedoe', 'https://example.com/images/users/janedoe.jpg', 'jane.doe@example.com', NOW(), true, 'AR'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'users')
  AND (SELECT COUNT(*) FROM users) <= 1;

-- Insert user_payment_methods if table exists and is empty
INSERT INTO user_payment_methods (user_id, payment_method_id, added_at, is_preferred)
SELECT 1, 1, NOW(), true
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'user_payment_methods')
  AND (SELECT COUNT(*) FROM user_payment_methods) = 0;

INSERT INTO user_payment_methods (user_id, payment_method_id, added_at, is_preferred)
SELECT 1, 3, NOW(), false
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'user_payment_methods')
  AND (SELECT COUNT(*) FROM user_payment_methods) <= 1;

INSERT INTO user_payment_methods (user_id, payment_method_id, added_at, is_preferred)
SELECT 1, 5, NOW(), false
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'user_payment_methods')
  AND (SELECT COUNT(*) FROM user_payment_methods) <= 2;

INSERT INTO user_payment_methods (user_id, payment_method_id, added_at, is_preferred)
SELECT 2, 2, NOW(), true
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'user_payment_methods')
  AND (SELECT COUNT(*) FROM user_payment_methods) <= 3;

INSERT INTO user_payment_methods (user_id, payment_method_id, added_at, is_preferred)
SELECT 2, 4, NOW(), false
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'user_payment_methods')
  AND (SELECT COUNT(*) FROM user_payment_methods) <= 4;

-- Insert sellers if table exists and is empty
INSERT INTO seller (nickname, email, phone_number, street, city, state, country, zip_code,
                    reputation_score, total_products_listed, total_sales, image_url, status,
                    registration_date_time, is_verified)
SELECT 'TechHub_Global', 'contact@techhub.com', '+1234567890', '123 Tech St', 'Tech City',
       'Tech State', 'Argentina', '12345', 4.8, 1250, 9875,
       'https://example.com/images/sellers/techhub_global.jpg', 'ACTIVE', NOW(), true
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'seller')
  AND (SELECT COUNT(*) FROM seller) = 0;

INSERT INTO seller (nickname, email, phone_number, street, city, state, country, zip_code,
                    reputation_score, total_products_listed, total_sales, image_url, status,
                    registration_date_time, is_verified)
SELECT 'ElectroWorld', 'info@electroworld.com', '+0987654321', '456 Electro Ave', 'Electro City',
       'Electro State', 'Argentina', '54321', 4.5, 850, 7500,
       'https://example.com/images/sellers/electroworld.jpg', 'ACTIVE', NOW(), true
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'seller')
  AND (SELECT COUNT(*) FROM seller) <= 1;

-- Insert products if table exists and is empty
INSERT INTO products (title, slug, description, price, stock, category, created_at, updated_at)
SELECT 'Smartphone X1 Pro', 'smartphone-x1-pro', 'Un potente smartphone con cámara de 108MP y pantalla OLED.',
       899.99, 50, 'Teléfonos', NOW(), NOW()
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'products')
  AND (SELECT COUNT(*) FROM products) = 0;

INSERT INTO products (title, slug, description, price, stock, category, created_at, updated_at)
SELECT 'Laptop UltraBook Z3', 'laptop-ultrabook-z3', 'Laptop ultradelgada con procesador de última generación.',
       1299.99, 30, 'Computadoras', NOW(), NOW()
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'products')
  AND (SELECT COUNT(*) FROM products) <= 1;

INSERT INTO products (title, slug, description, price, stock, category, created_at, updated_at)
SELECT 'Auriculares Bluetooth Pro', 'auriculares-bluetooth-pro', 'Auriculares con cancelación de ruido y batería de larga duración.',
       149.99, 100, 'Audio', NOW(), NOW()
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'products')
  AND (SELECT COUNT(*) FROM products) <= 2;

-- Insert product attributes if table exists and is empty
INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 1, 'color', 'Negro Cósmico'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) = 0;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 1, 'memoria_ram', '8GB'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 1;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 1, 'almacenamiento', '256GB'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 2;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 1, 'sistema_operativo', 'Android 14'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 3;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 2, 'color', 'Plata'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 4;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 2, 'memoria_ram', '16GB'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 5;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 2, 'almacenamiento', '512GB'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 6;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 2, 'sistema_operativo', 'Windows 11'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 7;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 3, 'color', 'Negro'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 8;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 3, 'tipo', 'Over-ear'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 9;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 3, 'bateria', '30 horas'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 10;

INSERT INTO product_attributes (product_id, attr_key, attr_value)
SELECT 3, 'bluetooth', '5.2'
    WHERE EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes')
  AND (SELECT COUNT(*) FROM product_attributes) <= 11;