-- 코드를 입력하세요
SELECT board_id, writer_id, title, price,
    CASE
    WHEN status = 'SALE' THEN '판매중'
    WHEN status = 'DONE' THEN '거래완료'
    WHEN status = 'RESERVED' THEN '예약중'
    END AS status
FROM used_goods_board as ugb
where created_date = '2022-10-05'
ORDER BY board_id DESC