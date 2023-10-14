USE w3schools;
SELECT *
FROM products p JOIN suppliers s
    ON p.SupplierID = s.SupplierID;

SELECT *
FROM products p JOIN suppliers s
    USING (SupplierID);

SELECT *
FROM products p NATURAL JOIN suppliers s; /* 두 테이블의 같은 이름을 찾아서 검색해줌*/




