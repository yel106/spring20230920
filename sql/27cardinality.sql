USE mydb1;

-- 1: n 관계



-- 1: 1관계 (p.347)
CREATE TABLE my_table37_employee (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(20),
  birth DATE
);

CREATE TABLE my_table38_employee_info (
    id INT REFERENCES my_table37_employee(id),
    salary INT,
    address VARCHAR(20)
);


--  책(p350)
-- n: m(다 대 다 관계) 1:n관계의 테이블을 하나 더 만드는게 좋음.
CREATE TABLE my_table39_person(
    id INT PRIMARY KEY  AUTO_INCREMENT,
    name VARCHAR(20)
);

CREATE TABLE my_table40_skill (
    id INT PRIMARY KEY AUTO_INCREMENT,
    skill_name VARCHAR(20) -- 스킬은 겹칠수 있어서 테이블 따로 만듦
);

CREATE TABLE my_table41_person_skill(  -- 주가 되는 것의 이름을 테이블 명으로 만드는게 좋음. 어떤 사람의 특기면 person_skill
    -- id를 따로 안 만들 것. 만드는 사람 마음대로
    person_id INT REFERENCES my_table39_person (id),
    skill_id INT REFERENCES my_table40_skill(id),
    PRIMARY KEY (person_id, skill_id)
);


