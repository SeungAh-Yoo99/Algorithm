-- 코드를 입력하세요
SELECT COUNT(user_id) AS USERS
FROM user_info
WHERE joined BETWEEN "2021-01-01" AND "2021-12-31"
AND age >= 20 and age <= 29