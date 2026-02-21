SELECT D.dept_id, D.dept_name_en, ROUND(AVG(E.sal)) as avg_sal
FROM hr_department D
JOIN hr_employees E ON D.dept_id = E.dept_id
GROUP BY D.dept_id
ORDER BY avg_sal desc;