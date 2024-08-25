SELECT TRUNCATE(price, -4) AS price_group, COUNT(product_id) as products
FROM product
GROUP BY TRUNCATE(price, -4)
ORDER BY price_group