-- 코드를 입력하세요
select ri.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(review_score), 2) as SCORE
from rest_info as ri
right outer join rest_review as rr
on ri.rest_id = rr.rest_id
where address like '서울%'
group by rr.rest_id
order by score desc, favorites desc
