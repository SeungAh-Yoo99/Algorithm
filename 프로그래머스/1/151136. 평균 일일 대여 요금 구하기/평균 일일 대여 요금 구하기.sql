SELECT ROUND(AVG(daily_fee)) AS AVERAGE_FEE
FROM car_rental_company_car
GROUP BY car_type
HAVING car_type = 'SUV';