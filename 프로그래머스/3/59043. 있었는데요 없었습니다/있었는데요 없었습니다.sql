SELECT ins.animal_id, ins.name
FROM animal_ins as ins, animal_outs as outs
WHERE ins.animal_id = outs.animal_id AND ins.datetime > outs.datetime
ORDER BY ins.datetime