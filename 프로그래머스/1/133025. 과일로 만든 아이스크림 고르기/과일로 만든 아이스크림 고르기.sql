SELECT fh.flavor
FROM first_half as fh
LEFT JOIN icecream_info as ii ON fh.flavor = ii.flavor
WHERE fh.total_order > 3000 AND ii.ingredient_type = 'fruit_based'
ORDER BY fh.total_order desc;