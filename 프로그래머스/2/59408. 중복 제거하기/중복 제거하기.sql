SELECT count(name) as count
FROM (
    SELECT DISTINCT name
    FROM animal_ins
) tmp;