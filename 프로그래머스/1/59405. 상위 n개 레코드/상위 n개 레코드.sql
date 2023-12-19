SELECT name
FROM animal_ins
where datetime = (
    SELECT MIN(datetime)
    FROM animal_ins
)