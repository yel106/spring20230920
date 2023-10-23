USE w3schools;
CREATE TABLE bank (
  name VARCHAR(10) PRIMARY KEY ,
  money INT NOT NULL DEFAULT 0
);
INSERT INTO bank(name, money)
VALUES ('son', 10000),
       ('kim', 10000);

-- 송금 업무 son -> kim 1000원 송금
UPDATE bank
SET money = money - 1000
WHERE name = 'son';

UPDATE bank
SET money = money + 1000
WHERE name = 'kim';

SELECT * FROM bank;
-- 그런데 따로 실행하는게 아니라 동시에 실행해야함
-- 업무 단위: transaction (약자 :Tx)

-- Tx: Manual로 하고 money-1000하면 반영된것처럼 보이지만,
-- 다른 콘솔 열면 반영안돼서 9000원으로 보임. 트랜잭션이 완료X
-- 완료시키는 방법은? 되돌리기 & 반영하기
-- 1. 되돌리기.
ROLLBACK ;

-- 2. 반영하기. 업무가 잘됐다면 COMMIT을 해야 다른콘솔에서도 반영됨
COMMIT ;

