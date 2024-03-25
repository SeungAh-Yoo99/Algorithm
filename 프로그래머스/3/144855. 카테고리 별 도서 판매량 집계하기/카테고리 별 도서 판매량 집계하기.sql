SELECT category, SUM(sales) as total_sales
FROM book
    INNER JOIN book_sales
    ON book.book_id = book_sales.book_id
WHERE sales_date LIKE '2022-01%'
GROUP BY category
ORDER BY category