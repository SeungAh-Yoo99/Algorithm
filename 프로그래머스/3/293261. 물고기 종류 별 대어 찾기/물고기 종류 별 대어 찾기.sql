select fi.id as id, fni.fish_name as fish_name, length
from fish_info as fi
left join fish_name_info as fni
on fi.fish_type = fni.fish_type
where (fi.fish_type, length) in (
    select fish_type, max(length)
    from fish_info
    group by fish_type
);