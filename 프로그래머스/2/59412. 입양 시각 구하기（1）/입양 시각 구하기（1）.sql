SELECT date_format(datetime, '%H') as HOUR, count(animal_id) as COUNT
FROM animal_outs
GROUP BY HOUR
HAVING HOUR >= 9 and HOUR <= 19
ORDER BY HOUR