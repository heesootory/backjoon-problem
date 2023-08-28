-- 코드를 입력하세요
SELECT HISTORY_ID, CAR_ID, 
DATE_FORMAT(start_date, "%Y-%m-%d") as START_DATE, 
DATE_FORMAT(end_date, "%Y-%m-%d") as END_DATE,
CASE 
    when DATEDIFF(END_DATE, START_DATE) >= 29 then "장기 대여"
    else "단기 대여"
END AS RENT_TYPE
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where START_DATE like "2022-09-%"
order by HISTORY_ID DESC;