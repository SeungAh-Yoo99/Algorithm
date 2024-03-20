SELECT
    pt_name,
    pt_no,
    gend_cd,
    age,
    CASE
        WHEN tlno IS NULL THEN 'NONE'
        ELSE tlno
    END as tlno
FROM patient
WHERE age <= 12 AND gend_cd = 'W'
ORDER BY age desc, pt_name