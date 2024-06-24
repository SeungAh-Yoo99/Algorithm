SELECT ingredient_type, SUM(total_order) AS TOTAL_ORDER
FROM first_half as fh
LEFT JOIN icecream_info as ii ON fh.flavor = ii.flavor
GROUP BY ingredient_type
ORDER BY TOTAL_ORDER