-- 코드를 입력하세요
SELECT a.FLAVOR
FROM FIRST_HALF a
JOIN (select flavor, sum(total_order) as total from july group by flavor) as b
on a.flavor = b.flavor
order by a.total_order + b.total desc
limit 3;
