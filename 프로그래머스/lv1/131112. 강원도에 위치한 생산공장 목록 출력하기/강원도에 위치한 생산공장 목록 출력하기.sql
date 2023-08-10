-- 코드를 입력하세요
SELECT factory_id, factory_name, address
FROM FOOD_FACTORY
WHERE address LIKE CONCAT('%', "강원도", '%')
ORDER BY factory_id ASC;