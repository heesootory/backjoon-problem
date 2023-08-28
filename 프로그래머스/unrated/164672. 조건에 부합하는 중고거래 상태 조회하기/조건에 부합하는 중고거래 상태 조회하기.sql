-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, title, price,
CASE 
    WHEN STATUS = 'SALE' THEN '판매중'
    WHEN STATUS = 'RESERVED' THEN '예약중'
    WHEN STATUS = 'DONE' THEN '거래완료'
END AS STATUS
FROM used_goods_board
where created_date = '2022-10-05'
ORDER BY board_id DESC;