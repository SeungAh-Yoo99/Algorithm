SELECT product_code, sum(sales_amount * price) as sales
FROM offline_sale as os
left join product as p
on os.product_id = p.product_id
GROUP BY product_code
ORDER BY sales desc, product_code