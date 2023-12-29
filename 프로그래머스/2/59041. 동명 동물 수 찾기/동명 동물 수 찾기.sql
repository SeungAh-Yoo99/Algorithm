SELECT name, COUNT(*) as COUNT
FROM animal_ins
GROUP BY name
HAVING COUNT(name) >= 2
ORDER BY name
