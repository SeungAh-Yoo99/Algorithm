SELECT COUNT(*) AS fish_count, fish_name
FROM fish_info AS fi
LEFT JOIN fish_name_info AS fni ON fi.fish_type = fni.fish_type
GROUP BY fish_name
ORDER BY fish_count desc