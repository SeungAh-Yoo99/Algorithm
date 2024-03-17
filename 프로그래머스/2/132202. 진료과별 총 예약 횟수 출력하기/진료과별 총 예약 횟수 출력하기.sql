SELECT mcdp_cd as '진료과 코드', count(pt_no) as '5월 예약건수'
FROM appointment
WHERE apnt_ymd like '2022-05%'
GROUP BY mcdp_cd
ORDER BY count(pt_no), mcdp_cd