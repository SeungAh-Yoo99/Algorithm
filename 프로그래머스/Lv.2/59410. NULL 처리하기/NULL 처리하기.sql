SELECT animal_type, COALESCE(name, 'No name'), sex_upon_intake
FROM animal_ins
ORDER BY animal_id

SELECT
    animal_type,
    CASE WHEN name IS NULL THEN 'No name' ELSE name END,
    sex_upon_intake
FROM animal_ins
ORDER BY animal_id

SELECT animal_type, IFNULL(name, 'No name'), sex_upon_intake
FROM animal_ins
ORDER BY animal_id
