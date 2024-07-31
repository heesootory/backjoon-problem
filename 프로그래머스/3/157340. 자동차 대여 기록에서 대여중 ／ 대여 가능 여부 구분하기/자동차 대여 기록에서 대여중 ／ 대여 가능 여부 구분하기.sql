-- SELECT 
--        main.CAR_ID
--      , sub.AVAILABILITY
--   FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS main
--      , (SELECT 
--                HISTORY_ID
--              , CAR_ID
--              , (CASE WHEN (TO_CHAR(START_DATE, 'YYYY-MM-DD') <= '2022-10-16' AND 
--                            TO_CHAR(END_DATE, 'YYYY-MM-DD')   >= '2022-10-16') THEN '대여중'
--                      ELSE  '대여 가능'
--                 END) AS AVAILABILITY
--           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) AS sub
--  WHERE 1=1
--    AND main.CAR_ID = sub.CAR_ID
--    AND main.HISTORY_ID = sub.HISTORY_ID;



-- SELECT 
--        CAR_ID
--      , COUNT(DECODE(sub.AVAILABILITY, '대여중', 1, null)) AS asdddd
--   FROM (SELECT
--                HISTORY_ID
--              , CAR_ID
--              , (CASE WHEN (TO_CHAR(START_DATE, 'YYYY-MM-DD') <= '2022-10-16' 
--                            AND TO_CHAR(END_DATE, 'YYYY-MM-DD') >= '2022-10-16') THEN '대여중'
--                      ELSE  '대여 가능'
--                 END) AS AVAILABILITY
--           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY) sub
--  WHERE 1=1
-- GROUP BY sub.CAR_ID


 SELECT
        CAR_ID
      , DECODE(CNT, 1, '대여중', '대여 가능') AS AVAILABILITY
   FROM (SELECT 
                CAR_ID
              , COUNT(CASE WHEN(TO_CHAR(START_DATE, 'YYYY-MM-DD') <= '2022-10-16' 
                                 AND TO_CHAR(END_DATE, 'YYYY-MM-DD') >= '2022-10-16') THEN '대여중'
                           ELSE null
                      END ) AS CNT
           FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
          WHERE 1=1 
         GROUP BY CAR_ID) SUB
   WHERE 1=1
ORDER BY CAR_ID DESC
             
             
             
             
             


 