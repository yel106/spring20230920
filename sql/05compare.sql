-- < 작다, >크다, >= 크거나 같다, <= 작거나 같다

SELECT *FROM products
WHERE Price < 10.00;

SELECT * FROM products
WHERE Price > 10.00;

SELECT * FROM products
WHERE Price >= 10.00;

SELECT * FROM products
WHERE Price <=10.00;

SELECT * FROM  products
WHERE NOT Price = 10.00; -- 같지 않다

SELECT * FROM  products -- 같지 않다
WHERE Price != 10.00; /*데이터 마다 버전마다 !이 안될수도 있음*/

SELECT * FROM products
WHERE Price <> 10.00; -- 같지 않다

SELECT * FROM customers
WHERE CustomerID < 3;

SELECT * FROM customers
WHERE CustomerID < '3'; /*비교되는 값이 숫자형식이 아니여도 가능. 문자형식도 가능*/

SELECT * FROM customers
WHERE CustomerName = 'Alfreds Futterkiste';

SELECT * FROM  customers
WHERE CustomerName < 'C'; /*사전 순서대로 A,B로 시작하는 이름 나옴*/

SELECT * FROM  customers
WHERE CustomerName < 'c'; /*대문자 말고 소문자로 써도 결과는 같음*/

SELECT * FROM  customers
WHERE CustomerName >= 'R';

SELECT * FROM employees;
SELECT * FROM employees
WHERE BirthDate >= '1960-01-01'; /*날짜 형식의 비교도 가능. 60년 이후에 태어난 사람만 출력*/

SELECT * FROM employees
WHERE BirthDate < '1960-01-01';

