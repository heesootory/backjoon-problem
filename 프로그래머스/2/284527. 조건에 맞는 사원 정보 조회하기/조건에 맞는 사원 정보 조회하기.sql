
    SELECT 
           G.SCORE
         , E.EMP_NO
         , E.EMP_NAME
         , E.POSITION
         , E.EMAIL
      FROM HR_DEPARTMENT D
         , HR_EMPLOYEES  E
         , (SELECT EMP_NO
                 , SUM(SCORE) SCORE
              FROM HR_GRADE
          GROUP BY EMP_NO
           ) G
     WHERE 1=1
       AND D.DEPT_ID = E.DEPT_ID
       AND E.EMP_NO  = G.EMP_NO
  ORDER BY G.SCORE DESC
     LIMIT 1