-- 정규화 NORMALIZATION

-- 첫번째 정규화 (FIRST NORMAL FORM) INF
-- 원자적 데이터를 가진 테이블 , PK(primary key) 컬럼이 있어야함

-- 책(p.369)
-- 두번째 정규화 (SECOND NORMAL FORM) 2NF
-- 1NF이면서, 부분적 함수 의존이 없어야함

-- 부분적 함수 의존( partial functional dependency)
-- 키가 아닌 컬럼의 값이 키 컬럼 일부에 종속되지 않아야 함
-- 만약 키의 일부가 변경될 때 키가 아닌 컬럼이 변경되어야 하면 부분적 함수 의존이 있는것임

-- ex) toy_id와 store_id가 pk일때 store_id가 바뀌면 store_address도 바껴야함. 키 컬럼 일부에 종속되어있음. 중복된 값이 있기때문
-- 우리가 인위적으로 만든 키 id가 있다면 sotre_address가 store_id에 부분적으로 종속되지 않을 것 .


-- 책(p.374)
-- 세번째 정규화 (THIRD NORMAL FORM) 3NF
-- 2NF여야 하고, 이행적 종속이 없어야 함

-- 이행적 종속 (transitive dependency)이란? : 키가 아닌 컬럼이 키가 아닌 다른 컬럼에 의존하는 것
-- 키가 아닌 컬럼이 변경되면 다른 키가 아닌 컬럼이 변경되어야 할 때 를 말함
-- ex) id 컬럼을 만들어주고 store_id와 toy_id가 키가 아닐때 store_address가 store_id에 의존하고 있다면 테이블을 따로 뺴줘야함


USE mydb1;
-- 입사지원자
-- id(인위적으로 pk를 줌), 이름, 학교, 학교주소
CREATE TABLE my_table30_person(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    school VARCHAR(10),
    school_address VARCHAR(10)
);

-- school_address는 school에 의존하고 있음
INSERT INTO my_table30_person( name, school, school_address)
VALUES ('흥민', '서울대', '관악'),
       ('강인', '고려대', '안암'),
       ('민재', '연세대', '신촌'),
       ('지성', '고려대', '안암'),
       ('범근', '연세대', '신촌');

SELECT * FROM my_table30_person;

CREATE TABLE my_table31_person (
    id INT PRIMARY KEY AUTO_INCREMENT, -- 2NF만족
    name VARCHAR(10), -- 3NF만족: 키가 아닌 컬럼 중에 의존하는게 없음
    school VARCHAR(10)
);
CREATE TABLE my_table32_school (
    id INT PRIMARY KEY AUTO_INCREMENT, -- name이나 address가 변경될 위험이 있으니까 id pk를 인위적으로 만들어줌
    name VARCHAR(10),
    address VARCHAR(10)
);

INSERT INTO my_table31_person( name, school)
VALUES ('흥민', '서울대'),
       ('강인', '고려대'),
       ('민재', '연세대'),
       ('지성', '고려대'),
       ('범근', '연세대');

INSERT INTO my_table32_school( name, address)
VALUES ('seoul univ', '관악'),
       ('korea univ', '안암'),
       ('연세대', '신촌');
SELECT * FROM my_table33_person;



CREATE TABLE my_table33_person (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(10),
    school_id INT -- 한 테이블의 컬럼이 다른 테이블을 참조한다면 참조하는 테이블의 pk를 사용해야함. type도 맞춰줘야함
);
CREATE TABLE my_table34_school (
    id INT PRIMARY KEY AUTO_INCREMENT, -- name이나 address가 변경될 위험이 있으니까 id pk를 인위적으로 만들어줌
    name VARCHAR(10),
    address VARCHAR(10)
);




INSERT INTO my_table33_person (name, school_id)
VALUES ('흥민', 1),
       ('강인', 2),
       ('민재', 1);
INSERT INTO my_table34_school (name, address)
VALUES ('서울대', '관악'),
       ('연세대', '신촌'),
       ('고려대', '안암');
SELECT * FROM my_table33_person;
SELECT * FROM my_table34_school;

INSERT INTO my_table33_person (name, school_id)
VALUES ('지성', 4);

CREATE TABLE my_table35_person (
   id INT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(10),
   school_id INT REFERENCES my_table36_school(id) -- table 36에 이미 아이디가 있어야됨. pk가 들어감
    -- 참조하고 있으니까 table36이 먼저 있어야 이 테이블이 만들어짐
    -- 외래키(foreigh key) 제약사항
);
CREATE TABLE my_table36_school (
   id INT PRIMARY KEY AUTO_INCREMENT, -- name이나 address가 변경될 위험이 있으니까 id pk를 인위적으로 만들어줌
   name VARCHAR(10),
   address VARCHAR(10)
);
INSERT INTO my_table35_person (name, school_id)
VALUES ('흥민', 1),
       ('강인', 2),
       ('민재', 1);
INSERT INTO my_table36_school (name, address)
VALUES ('서울대', '관악'),
       ('연세대', '신촌'),
       ('고려대', '안암');

INSERT INTO my_table35_person (name, school_id)
VALUES ('지성', 4);

DELETE FROM my_table36_school WHERE id= 1; -- 참조하고 있기 때문에 지울 수 없음;
DELETE FROM my_table36_school WHERE id= 3; -- 고려대는 참조하고 있는게 없어서 지울 수 있음;

DESC my_table35_person; -- MUL: Multi라고 떠서 참조하고 있다는걸 확인 가능
SHOW CREATE TABLE my_table35_person;
CREATE TABLE `my_table35_person` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT,
                                     `name` varchar(10) DEFAULT NULL,
                                     `school_id` int(11) DEFAULT NULL,
                                     PRIMARY KEY (`id`),
                                     KEY `school_id` (`school_id`),
                                     CONSTRAINT `my_table35_person_ibfk_1` FOREIGN KEY (`school_id`) REFERENCES `my_table36_school` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 외래키, 참조키, FK ( foreign key)










