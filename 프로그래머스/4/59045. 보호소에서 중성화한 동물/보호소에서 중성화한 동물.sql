SELECT ai.animal_id, ai.animal_type, ai.name
FROM animal_ins AS ai
LEFT JOIN animal_outs AS ao ON ai.animal_id = ao.animal_id
WHERE ai.sex_upon_intake like 'Intact%'
    AND (ao.sex_upon_outcome = 'Neutered Male' OR ao.sex_upon_outcome = 'Spayed Female')
ORDER BY ai.animal_id