SELECT animal_type, count(animal_id) as count
FROM animal_ins
GROUP BY animal_type
ORDER BY animal_type;