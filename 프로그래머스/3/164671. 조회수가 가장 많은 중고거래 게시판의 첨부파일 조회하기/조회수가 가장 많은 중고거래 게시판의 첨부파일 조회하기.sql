-- 코드를 입력하세요
SELECT CONCAT('/home/grep/src/', ugb.board_id, '/', file_id, file_name, file_ext) as file_path
FROM used_goods_board as ugb, used_goods_file as ugf
WHERE views = (
    SELECT max(views)
    FROM used_goods_board
) AND ugb.board_id = ugf.board_id
ORDER BY file_id DESC