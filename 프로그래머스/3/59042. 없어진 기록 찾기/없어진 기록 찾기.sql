SELECT animal_id,name
FROM animal_outs
WHERE animal_id NOT IN (
    SELECT animal_id
    FROM animal_ins
)
ORDER BY animal_id;