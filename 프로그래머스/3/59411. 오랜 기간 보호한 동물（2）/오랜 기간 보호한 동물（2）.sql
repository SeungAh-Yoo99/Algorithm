SELECT ai.animal_id, ai.name
FROM animal_ins AS ai
LEFT JOIN animal_outs AS ao ON ai.animal_id = ao.animal_id
ORDER BY (ao.datetime - ai.datetime) DESC LIMIT 2;