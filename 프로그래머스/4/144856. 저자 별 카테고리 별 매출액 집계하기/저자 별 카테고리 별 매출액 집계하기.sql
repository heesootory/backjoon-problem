-- SELECT 
--        *
--   FROM BOOK B
--      , BOOK_SALES BS
--  WHERE 1=1
--    AND B.BOOK_ID = BS.BOOK_ID
--    AND TO_CHAR(BS.SALES_DATE, 'YYYY-MM') = '2022-01'
--    AND B.CATEGORY = '인문' 
 
 
 SELECT 
         A.AUTHOR_ID
       , A.AUTHOR_NAME
       , B.CATEGORY
       , SUM(BS.SALES * B.PRICE) AS TOTAL_SALES
      -- , COUNT(*)
    FROM BOOK B
       , AUTHOR A
       , BOOK_SALES BS
   WHERE 1=1
     AND B.BOOK_ID = BS.BOOK_ID
     AND A.AUTHOR_ID = B.AUTHOR_ID
     AND TO_CHAR(BS.SALES_DATE, 'YYYY-MM') = '2022-01'
GROUP BY A.AUTHOR_ID,A.AUTHOR_NAME, B.CATEGORY
ORDER BY A.AUTHOR_ID, B.CATEGORY DESC;





