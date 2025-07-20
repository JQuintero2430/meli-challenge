-- Script to initialize the database with sample data

DO $$
BEGIN
    -- Insert payment methods if table exists and is empty
    IF EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'payment_methods') AND
       (SELECT COUNT(*) FROM payment_methods) = 0 THEN
        INSERT INTO payment_methods (type, provider, is_active, country_code)
        VALUES
            ('CREDIT_CARD', 'Visa', true, 'AR'),
            ('CREDIT_CARD', 'Mastercard', true, 'AR'),
            ('DEBIT_CARD', 'Visa', true, 'AR'),
            ('DEBIT_CARD', 'Mastercard', true, 'AR'),
            ('MERCADO_PAGO', 'MercadoPago', true, 'AR');
END IF;

    -- Insert users if table exists and is empty
    IF EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'users') AND
       (SELECT COUNT(*) FROM users) = 0 THEN
        INSERT INTO users (username, profile_image_url, email, created_at, is_active, country_code)
        VALUES
            ('johndoe', 'https://example.com/images/users/johndoe.jpg', 'john.doe@example.com', NOW(), true, 'AR'),
            ('janedoe', 'https://example.com/images/users/janedoe.jpg', 'jane.doe@example.com', NOW(), true, 'AR');
END IF;

    -- Insert user_payment_methods if table exists and is empty
    IF EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'user_payment_methods') AND
       (SELECT COUNT(*) FROM user_payment_methods) = 0 THEN
        INSERT INTO user_payment_methods (user_id, payment_method_id, added_at, is_preferred)
        VALUES
            (1, 1, NOW(), true),
            (1, 3, NOW(), false),
            (1, 5, NOW(), false),
            (2, 2, NOW(), true),
            (2, 4, NOW(), false);
END IF;

    -- Insert sellers if table exists and is empty
    IF EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'seller') AND
       (SELECT COUNT(*) FROM seller) = 0 THEN
        INSERT INTO seller (nickname, email, phone_number, street, city, state, country, zip_code,
                          reputation_score, total_products_listed, total_sales, image_url, status,
                          registration_date_time, is_verified)
        VALUES
            ('TechHub_Global', 'contact@techhub.com', '+1234567890', '123 Tech St', 'Tech City',
             'Tech State', 'Argentina', '12345', 4.8, 1250, 9875,
             'https://example.com/images/sellers/techhub_global.jpg', 'ACTIVE', NOW(), true),
            ('ElectroWorld', 'info@electroworld.com', '+0987654321', '456 Electro Ave', 'Electro City',
             'Electro State', 'Argentina', '54321', 4.5, 850, 7500,
             'https://example.com/images/sellers/electroworld.jpg', 'ACTIVE', NOW(), true);
END IF;

    -- Insert products if table exists and is empty
    IF EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'products') AND
       (SELECT COUNT(*) FROM products) = 0 THEN
        INSERT INTO products (title, slug, description, price, stock, category, created_at, updated_at)
        VALUES
            ('Smartphone X1 Pro', 'smartphone-x1-pro', 'Un potente smartphone con cámara de 108MP y pantalla OLED.',
             899.99, 50, 'Teléfonos', NOW(), NOW()),
            ('Laptop UltraBook Z3', 'laptop-ultrabook-z3', 'Laptop ultradelgada con procesador de última generación.',
             1299.99, 30, 'Computadoras', NOW(), NOW()),
            ('Auriculares Bluetooth Pro', 'auriculares-bluetooth-pro', 'Auriculares con cancelación de ruido y batería de larga duración.',
             149.99, 100, 'Audio', NOW(), NOW());
END IF;

    -- Insert product attributes if table exists and is empty
    IF EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'product_attributes') AND
       (SELECT COUNT(*) FROM product_attributes) = 0 THEN
        INSERT INTO product_attributes (product_id, attr_key, attr_value)
        VALUES
            (1, 'color', 'Negro Cósmico'),
            (1, 'memoria_ram', '8GB'),
            (1, 'almacenamiento', '256GB'),
            (1, 'sistema_operativo', 'Android 14'),
            (2, 'color', 'Plata'),
            (2, 'memoria_ram', '16GB'),
            (2, 'almacenamiento', '512GB'),
            (2, 'sistema_operativo', 'Windows 11'),
            (3, 'color', 'Negro'),
            (3, 'tipo', 'Over-ear'),
            (3, 'bateria', '30 horas'),
            (3, 'bluetooth', '5.2');
END IF;
END $$;