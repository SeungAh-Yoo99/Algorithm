SELECT fp.product_id, fp.product_name, SUM(fo.amount) * fp.price AS total_sales
FROM food_product fp JOIN food_order fo ON fp.product_id = fo.product_id
WHERE fo.produce_date BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY fp.product_id
ORDER BY total_sales DESC, fp.product_id