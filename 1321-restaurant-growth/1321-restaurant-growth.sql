# Write your MySQL query statement below
WITH daily_amount AS (
    SELECT
        visited_on,
        SUM(amount) AS daily_total
    FROM Customer
    GROUP BY visited_on
),
moving_average AS (
    SELECT
        visited_on,
        SUM(daily_total) OVER (
            ORDER BY visited_on
            ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
        ) AS amount,
        ROUND(
            AVG(daily_total) OVER (
                ORDER BY visited_on
                ROWS BETWEEN 6 PRECEDING AND CURRENT ROW
            ), 2
        ) AS average_amount,
        ROW_NUMBER() OVER (
            ORDER BY visited_on
        ) AS rn
    FROM daily_amount
)
SELECT
    visited_on,
    amount,
    average_amount
FROM moving_average
WHERE rn >= 7
ORDER BY visited_on;