SELECT origin.category, origin.price as max_price, origin.product_name
FROM food_product as origin, (
    SELECT category, MAX(price) as price
    FROM food_product
    WHERE category in ('과자', '국', '김치', '식용유')
    GROUP BY category
) as max_price
WHERE origin.category = max_price.category
AND origin.price = max_price.price
ORDER BY max_price DESC