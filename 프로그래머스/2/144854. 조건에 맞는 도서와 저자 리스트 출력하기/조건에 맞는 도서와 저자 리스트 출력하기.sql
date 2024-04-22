SELECT b.book_id, a.author_name, date_format(published_date, '%Y-%m-%d') as published_date
FROM book as b
LEFT JOIN author as a
ON b.author_id = a.author_id
WHERE category = '경제'
ORDER BY published_date