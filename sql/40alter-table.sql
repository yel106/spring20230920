USE mydb1;

CREATE TABLE my_table46 (
    col1 INT,
    col2 INT,
    col3 INT,
    col4 INT,
    col5 INT
);

-- NOT NULL 제약사항 추가
ALTER TABLE my_table46
MODIFY col1 INT NOT NULL;


-- NOT NULL 제약사항 삭제
ALTER TABLE my_table46
MODIFY col1 INT NULL; -- NULL허용


-- 예) col2에 not null 제약사항 추가 했다가 삭제
ALTER TABLE my_table46
MODIFY col2 INT NOT NULL;

ALTER TABLE my_table46
MODIFY col2 INT NULL;

-- DEFAULT 제약사항 추가
ALTER TABLE my_table46
ALTER col3 SET DEFAULT 100;

-- DEFAULT 제약사항 삭제
ALTER TABLE my_table46
ALTER col3 DROP DEFAULT ;

-- 예) col4에 기본값 0 제약 사항 추가 후 삭제
ALTER TABLE my_table46
ALTER col4 SET DEFAULT 0;

ALTER TABLE my_table46
ALTER col4 DROP DEFAULT ;

-- UNIQUE 제약사항 추가
ALTER TABLE my_table46
ADD UNIQUE (col5);

-- UNIQUE 제약사항 삭제
SHOW CREATE TABLE  my_table46;
CREATE TABLE `my_table46` (
                              `col1` int(11) DEFAULT NULL,
                              `col2` int(11) DEFAULT NULL,
                              `col3` int(11),
                              `col4` int(11),
                              `col5` int(11) DEFAULT NULL,
                              UNIQUE KEY `col5` (`col5`) -- UNIQUE key가 어떤 이름으로 되어있는지 확인하고 삭제. 괄호 말고 그 앞
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE my_table46
DROP INDEX col5;


-- PRIMARY KEY 제약사항 추가
ALTER TABLE my_table46
ADD PRIMARY KEY (col1); -- pk는 한개도 가능하고 두개도 가능함

-- PRIMARY KEY 제약사항 삭제
SHOW CREATE TABLE my_table46;
CREATE TABLE `my_table46` (
                              `col1` int(11) NOT NULL,
                              `col2` int(11) DEFAULT NULL,
                              `col3` int(11),
                              `col4` int(11),
                              `col5` int(11) DEFAULT NULL,
                              PRIMARY KEY (`col1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE my_table46
DROP PRIMARY KEY ;

ALTER TABLE my_table46 -- not null 제약사항도 삭제함
MODIFY col1 INT NULL;


 CREATE TABLE my_table47 (
     id INT AUTO_INCREMENT primary key ,
     name VARCHAR(10)
 );

-- foreign key 제약사항 추가
ALTER TABLE my_table46
ADD FOREIGN KEY (col5) REFERENCES my_table47(id);

-- foreign key 제약사항 삭제
SHOW CREATE TABLE my_table46;
CREATE TABLE `my_table46` (
                              `col1` int(11) DEFAULT NULL,
                              `col2` int(11) DEFAULT NULL,
                              `col3` int(11),
                              `col4` int(11),
                              `col5` int(11) DEFAULT NULL,
                              KEY `col5` (`col5`),
                              CONSTRAINT `my_table46_ibfk_1` FOREIGN KEY (`col5`) REFERENCES `my_table47` (`id`)
                          -- CONSTRAINT 뒤에 나오는 것을 참고해서 삭제해야함
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 아래 INDEX까지 삭제해야 외래키 사라짐
ALTER TABLE my_table46
DROP FOREIGN KEY my_table46_ibfk_1;

ALTER TABLE my_table46
DROP INDEX col5;

DESC my_table46;










