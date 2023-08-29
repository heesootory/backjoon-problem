-- 코드를 입력하세요
SELECT distinct a.car_id, a.car_type, ROUND(a.daily_fee * 30 * (100 - c.discount_rate) / 100) as fee
FROM CAR_RENTAL_COMPANY_CAR as a
join CAR_RENTAL_COMPANY_RENTAL_HISTORY as b
on a.car_id = b.car_id
join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as c
on a.car_type = c.car_type
where a.car_type in ('세단', 'SUV')
and ( a.car_id not in(
    select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    where start_date <= '2022-11-30' and end_date >= '2022-11-01')
)
and (c.duration_type = '30일 이상' and (a.daily_fee * 30 * (100 - c.discount_rate) / 100) between 500000 and 2000000)
order by fee desc, a.CAR_TYPE, a.CAR_ID desc;