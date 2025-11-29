select my.id as id, my.genotype as genotype, p.genotype as parent_genotype
from ecoli_data as my
left join ecoli_data as p
on my.parent_id = p.id
where bin(my.genotype & p.genotype) = bin(p.genotype)
order by my.id;