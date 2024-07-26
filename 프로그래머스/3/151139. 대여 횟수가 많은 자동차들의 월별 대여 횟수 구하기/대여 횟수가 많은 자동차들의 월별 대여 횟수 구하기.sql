SELECT 
        extract(month from START_DATE) AS MONTH
      , CAR_ID
      , COUNT(*) AS RECORDS
   FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
  WHERE 1=1
    AND TO_CHAR(START_DATE, 'MM') IN ('08', '09', '10')
    AND CAR_ID IN (SELECT CAR_ID
                     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    WHERE TO_CHAR(START_DATE, 'MM') IN ('08', '09', '10')
                 GROUP BY CAR_ID
                   HAVING COUNT(CAR_ID) >= 5)
GROUP BY CAR_ID, extract(month from START_DATE)
  HAVING COUNT(*) != 0
ORDER BY MONTH, CAR_ID DESC;