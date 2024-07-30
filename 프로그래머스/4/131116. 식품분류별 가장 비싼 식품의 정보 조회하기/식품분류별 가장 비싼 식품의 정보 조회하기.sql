   
 
  SELECT 
         FP.CATEGORY
       , SUB.MAX_PRICE
       , FP.PRODUCT_NAME
    FROM FOOD_PRODUCT FP
       , ( SELECT 
                  CATEGORY
                , MAX(PRICE) MAX_PRICE
             FROM FOOD_PRODUCT
            WHERE 1=1
              AND CATEGORY IN ('과자', '국', '김치', '식용유') 
         GROUP BY CATEGORY ) SUB
   WHERE 1=1
     AND FP.CATEGORY = SUB.CATEGORY
     AND FP.price = sub.max_price 
ORDER BY SUB.MAX_PRICE DESC;