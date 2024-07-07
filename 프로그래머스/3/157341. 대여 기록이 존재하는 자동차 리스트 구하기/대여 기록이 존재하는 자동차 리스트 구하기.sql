SELECT car_id
FROM car_rental_company_car
WHERE car_type = '세단'
AND car_id IN (
    SELECT car_id
    FROM car_rental_company_rental_history
    WHERE start_date >= '2022-10-01' AND start_date <= '2022-10-31'
)
ORDER BY car_id DESC;