SELECT car_type, COUNT(car_id) as cars
FROM car_rental_company_car
WHERE
    options like '%통풍시트%'
    OR options like '%열선시트%'
    OR options like '%가죽시트%'
GROUP BY car_type
ORDER BY car_type