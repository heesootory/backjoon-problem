
  SELECT 
         COUNT(ID) AS FISH_COUNT
       , EXTRACT(MONTH FROM TIME) AS MONTH
    FROM FISH_INFO
   WHERE 1=1
GROUP BY EXTRACT(MONTH FROM TIME)
ORDER BY 2