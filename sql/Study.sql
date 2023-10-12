CREATE DATABASE study;

USE study;
CREATE TABLE passengerInform(
        passengerNumber INT,
        passengerName VARCHAR(50),
        borardingArea VARCHAR(10),
        passportNumber VARCHAR(50)
);


INSERT INTO passengerInform
VALUE(1,'김지수','A5','M32670987');

INSERT INTO passengerInform
VALUE(2,'정민재','B1','M32870982');

INSERT INTO passengerInform
VALUE(3,'윤민주','B3','M09800000');

INSERT INTO passengerInform
VALUE(4,'Chris','B3','M12345678');

INSERT INTO passengerInform
VALUE(5,'John','D2','M51765555');

INSERT INTO passengerInform
VALUE(6,'서은솔','C3','M87666321');

SELECT * FROM passengerInform;