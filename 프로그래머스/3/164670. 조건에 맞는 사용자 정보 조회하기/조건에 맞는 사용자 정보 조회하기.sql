SELECT DISTINCT ugu.user_id, ugu.nickname, CONCAT(ugu.city, ' ', street_address1, ' ', street_address2) AS 전체주소, CONCAT(SUBSTRING(ugu.tlno, 1, 3), '-', SUBSTRING(ugu.tlno, 4, 4), '-', SUBSTRING(ugu.tlno, 8, 4)) AS 전화번호
FROM used_goods_user AS ugu
WHERE ugu.user_id in (
    SELECT writer_id
    FROM used_goods_board
    GROUP BY writer_id
    HAVING COUNT(writer_id) >= 3
)
ORDER BY ugu.user_id DESC