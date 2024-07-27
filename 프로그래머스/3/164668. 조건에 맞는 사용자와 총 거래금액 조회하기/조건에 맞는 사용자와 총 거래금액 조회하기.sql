SELECT user.user_id, user.nickname, SUM(board.price) AS total_sales
FROM used_goods_board as board
INNER JOIN used_goods_user as user
ON board.writer_id = user.user_id
WHERE board.status = 'DONE'
GROUP BY board.writer_id
HAVING SUM(board.price) >= 700000
ORDER BY total_sales;