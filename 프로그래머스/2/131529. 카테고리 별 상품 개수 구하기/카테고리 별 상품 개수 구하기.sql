SELECT LEFT(product_code, 2) as category, COUNT(product_id) as products
FROM product
GROUP BY LEFT(product_code, 2)