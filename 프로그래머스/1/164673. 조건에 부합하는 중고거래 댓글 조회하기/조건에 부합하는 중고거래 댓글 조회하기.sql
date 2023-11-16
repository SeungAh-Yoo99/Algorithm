-- 코드를 입력하세요
SELECT b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, date_format(r.CREATED_DATE, '%Y-%m-%d') 
FROM USED_GOODS_BOARD as b, USED_GOODS_REPLY as r
WHERE b.created_date LIKE '2022-10%' AND b.BOARD_ID = r.BOARD_ID
ORDER BY r.created_date, b.title