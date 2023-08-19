-- 코드를 입력하세요
SELECT COUNT(distinct NAME) count
FROM ANIMAL_INS
WHERE not NAME is NULL;