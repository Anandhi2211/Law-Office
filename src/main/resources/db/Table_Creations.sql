drop database law_office;
CREATE DATABASE IF NOT EXISTS law_office;
use law_office;

CREATE TABLE IF NOT EXISTS law_firms (
    law_firm_id SERIAL,
    law_firm_name VARCHAR(25) NOT NULL,
    address VARCHAR(50) NOT NULL,
    country VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL,
    PRIMARY KEY (law_firm_id)
);

CREATE TABLE IF NOT EXISTS awards (
    award_id SERIAL,
    award_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (award_id)
);

CREATE TABLE IF NOT EXISTS law_firm_has_awards (
    law_firm_id BIGINT UNSIGNED,
    award_id BIGINT UNSIGNED,
    CONSTRAINT fk_award_law_firm FOREIGN KEY (law_firm_id)
        REFERENCES law_firms (law_firm_id),
    CONSTRAINT fk_award FOREIGN KEY (award_id)
        REFERENCES awards (award_id)
);

CREATE TABLE IF NOT EXISTS salary_details (
    year_of_experiance BIGINT NOT NULL,
    salary BIGINT NOT NULL,
    law_firm_id BIGINT UNSIGNED,
    PRIMARY KEY (year_of_experiance , law_firm_id),
    CONSTRAINT fk_salary_law_firm FOREIGN KEY (law_firm_id)
        REFERENCES law_firms (law_firm_id)
);

CREATE TABLE IF NOT EXISTS attorneys (
    attorney_id SERIAL,
    attorney_name VARCHAR(25) NOT NULL,
    country VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL,
    PRIMARY KEY (attorney_id),
    attorney_law_firm_id BIGINT UNSIGNED,
    CONSTRAINT fk_attorney_law_firm FOREIGN KEY (attorney_law_firm_id)
        REFERENCES law_firms (law_firm_id)
);

CREATE TABLE IF NOT EXISTS clients (
    client_id SERIAL,
    client_name VARCHAR(25) NOT NULL,
    address VARCHAR(50) NOT NULL,
    country VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL,
    PRIMARY KEY (client_id),
    law_firm_id BIGINT UNSIGNED,
    CONSTRAINT fk_client_law_firm FOREIGN KEY (law_firm_id)
        REFERENCES law_firms (law_firm_id)
);

CREATE TABLE IF NOT EXISTS case_categories (
    case_category_id SERIAL,
    case_categorie_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (case_category_id)
);

CREATE TABLE IF NOT EXISTS cases (
    case_id SERIAL,
    case_description VARCHAR(200) NOT NULL,
    PRIMARY KEY (case_id),
    client_id BIGINT UNSIGNED,
    attorney_id BIGINT UNSIGNED,
    case_category_id BIGINT UNSIGNED,
    CONSTRAINT fk_attorney_cases FOREIGN KEY (attorney_id)
        REFERENCES attorneys (attorney_id),
    CONSTRAINT fk_client_cases FOREIGN KEY (client_id)
        REFERENCES clients (client_id),
    CONSTRAINT fk_case_category_cases FOREIGN KEY (case_category_id)
        REFERENCES case_categories (case_category_id)
);

CREATE TABLE IF NOT EXISTS bill_details (
    bill_invoice_no SERIAL,
    bill_amount BIGINT NOT NULL,
    PRIMARY KEY (bill_invoice_no),
    law_firm_id BIGINT UNSIGNED,
    client_id BIGINT UNSIGNED,
    CONSTRAINT fk_bill_details_law_firm FOREIGN KEY (law_firm_id)
        REFERENCES law_firms (law_firm_id),
    CONSTRAINT fk_bill_details_client FOREIGN KEY (client_id)
        REFERENCES clients (client_id)
);

CREATE TABLE IF NOT EXISTS association_bars (
    association_bar_id SERIAL,
    association_bar_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (association_bar_id)
);

CREATE TABLE IF NOT EXISTS area_of_practices (
    area_of_practice_id SERIAL,
    area_of_practice_name VARCHAR(20) NOT NULL,
    PRIMARY KEY (area_of_practice_id)
);

CREATE TABLE IF NOT EXISTS attorney_area_of_practices (
    area_of_practice_id BIGINT UNSIGNED,
    attorney_id BIGINT UNSIGNED,
    CONSTRAINT fk_area_of_practice FOREIGN KEY (area_of_practice_id)
        REFERENCES area_of_practices (area_of_practice_id),
    CONSTRAINT fk_attorney FOREIGN KEY (attorney_id)
        REFERENCES attorneys (attorney_id)
);

CREATE TABLE IF NOT EXISTS courts (
    court_id SERIAL,
    court_name VARCHAR(50) NOT NULL,
    address VARCHAR(30) NOT NULL,
    country VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL,
    PRIMARY KEY (court_id)
);

CREATE TABLE IF NOT EXISTS judges (
    judge_id SERIAL,
    judge_name VARCHAR(25) NOT NULL,
    PRIMARY KEY (judge_id)
);

CREATE TABLE IF NOT EXISTS attorney_association_bars (
    attorney_id BIGINT UNSIGNED,
    association_bar_id BIGINT UNSIGNED,
    CONSTRAINT fk_association_bar_attorney FOREIGN KEY (attorney_id)
        REFERENCES attorneys (attorney_id),
    CONSTRAINT fk_association_bar FOREIGN KEY (association_bar_id)
        REFERENCES association_bars (association_bar_id),
    PRIMARY KEY (attorney_id , association_bar_id)
);

create table if not exists law_firm_has_clients (
law_firm_id bigint unsigned,
client_id bigint unsigned,
CONSTRAINT fk_law_firm_clients FOREIGN KEY (client_id)
        REFERENCES clients (client_id),
    CONSTRAINT fk_clients_law_firm FOREIGN KEY (law_firm_id)
        REFERENCES law_firms (law_firm_id),
    PRIMARY KEY (law_firm_id , client_id)
);

INSERT INTO law_firms (law_firm_id,law_firm_name, address, country, city) VALUES (100,'Amarchand Co', '14th Ava street', 'USA','Charlotte');
INSERT INTO law_firms (law_firm_id,law_firm_name, address, country, city) VALUES (101,'Anand & Anand', '90 BROADWAY LANE', 'USA','ohio');
INSERT INTO law_firms (law_firm_id,law_firm_name, address, country, city) VALUES (102,'AZB & Partners', '185 RANCH DR', 'USA','Texas');
INSERT INTO law_firms (law_firm_id,law_firm_name, address, country, city) VALUES (103,'IndusLaw', '154 greens road', 'USA','Concord');
INSERT INTO law_firms (law_firm_id,law_firm_name, address, country, city) VALUES (104,'Phoenix Legal', '85 wills street', 'USA','Arizona');
UPDATE law_firms 
SET 
    city = 'cincinnati'
WHERE
    law_firm_id = 101;
UPDATE law_firms 
SET 
    city = 'dallas'
WHERE
    law_firm_id = 102;

INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (100,'Akron Bar');
INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (101,'Butler County Bar');
INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (102,'Cleveland Bar');
INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (103,'Dayton Bar');
INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (104,'Cincinnati Bar');
INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (105,'Columbus Bar');
INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (106,'Lake county Bar');
INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (107,'Findlay Bar');
INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (108,'Warren County Bar');
INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (109,'Norman Bar');
INSERT INTO association_bars (association_bar_id, association_bar_name) VALUES (110,'Darke County Bar');

UPDATE association_bars 
SET 
    association_bar_name = 'Findlay County Bar'
WHERE
    association_bar_id = 107;
UPDATE association_bars 
SET 
    association_bar_name = 'Dayton County Bar'
WHERE
    association_bar_id = 103;

insert into attorneys (attorney_id,attorney_name, country, city, attorney_law_firm_id) values ('1000','Lakshmi','USA','cincinnati',101);
insert into attorneys (attorney_id,attorney_name, country, city, attorney_law_firm_id) values ('1001','Nithya','USA','Dayton',101);
insert into attorneys (attorney_id,attorney_name, country, city, attorney_law_firm_id) values ('1002','Kanmani','USA','Charlotte',100);
insert into attorneys (attorney_id,attorney_name, country, city, attorney_law_firm_id) values ('1003','Kavitha','USA','Harrisburg',100);
insert into attorneys (attorney_id,attorney_name, country, city, attorney_law_firm_id) values ('1004','Haritha','USA','Tega Cay',103);
insert into attorneys (attorney_id,attorney_name, country, city, attorney_law_firm_id) values ('1005','Hema','USA','Tega Cay',103);
insert into attorneys (attorney_id,attorney_name, country, city, attorney_law_firm_id) values ('1006','Bhavani','USA','Monroe',103);
insert into attorneys (attorney_id,attorney_name, country, city, attorney_law_firm_id) values ('1007','Subha Sree','USA','Concord',103);

UPDATE attorneys 
SET 
    attorney_law_firm_id = 102
WHERE
    attorney_id = 1007;
UPDATE attorneys 
SET 
    city = 'Monroe'
WHERE
    attorney_id = 1005;

insert into attorney_association_bars (attorney_id, association_bar_id) values (1000,100);
insert into attorney_association_bars (attorney_id, association_bar_id) values (1000,101);
insert into attorney_association_bars (attorney_id, association_bar_id) values (1000,105);
insert into attorney_association_bars (attorney_id, association_bar_id) values (1000,110);

insert into attorney_association_bars (attorney_id, association_bar_id) values (1001,102);
insert into attorney_association_bars (attorney_id, association_bar_id) values (1001,104);
insert into attorney_association_bars (attorney_id, association_bar_id) values (1001,106);

insert into attorney_association_bars (attorney_id, association_bar_id) values (1002,100);
insert into attorney_association_bars (attorney_id, association_bar_id) values (1002,101);
insert into attorney_association_bars (attorney_id, association_bar_id) values (1002,102);

insert into attorney_association_bars (attorney_id, association_bar_id) values (1003,110);
insert into attorney_association_bars (attorney_id, association_bar_id) values (1003,109);
insert into attorney_association_bars (attorney_id, association_bar_id) values (1003,105);
insert into attorney_association_bars (attorney_id, association_bar_id) values (1003,106);

alter table clients
drop column address;

/*alter table clients
add column attorney_id bigint unsigned;*/

/*alter table clients
add constraint fk_client_attorney foreign key (attorney_id) references attorneys (attorney_id);*/


insert into clients (client_id,client_name,country,city,law_firm_id) values (200,'Thamari','USA','cincinnati',101);
insert into clients (client_id,client_name,country,city,law_firm_id) values (201,'Rekha','USA','concord',103);
insert into clients (client_id,client_name,country,city,law_firm_id) values (202,'Vishnu','USA','cincinnati',101);
insert into clients (client_id,client_name,country,city,law_firm_id) values (203,'Raji','USA','charlotte',100);

insert into clients (client_id,client_name,country,city,law_firm_id) values (204,'Som','USA','cincinnati',101);
insert into clients (client_id,client_name,country,city,law_firm_id) values (205,'Srini','USA','concord',103);
insert into clients (client_id,client_name,country,city,law_firm_id) values (206,'Pavan','USA','cincinnati',102);
insert into clients (client_id,client_name,country,city,law_firm_id) values (207,'Rajeev','USA','charlotte',100);

UPDATE clients 
SET 
    client_name = 'Rajeshwari'
WHERE
    client_id = 203;
UPDATE clients 
SET 
    client_name = 'Vishnu Priya'
WHERE
    client_id = 202;

insert into area_of_practices(area_of_practice_id, area_of_practice_name) values (1,'civil');
insert into area_of_practices(area_of_practice_id,area_of_practice_name) values (2,'Family Law');
insert into area_of_practices(area_of_practice_id,area_of_practice_name) values (3,'Real estate');
insert into area_of_practices(area_of_practice_id,area_of_practice_name) values (4,'Divorce');
insert into area_of_practices(area_of_practice_id,area_of_practice_name) values (5,'Bankruptcy');
insert into area_of_practices(area_of_practice_id,area_of_practice_name) values (6,'Immigration Law');
insert into area_of_practices(area_of_practice_id,area_of_practice_name) values (7,'Municipal Law');
insert into area_of_practices(area_of_practice_id,area_of_practice_name) values (8,'Personal Injury');
insert into area_of_practices(area_of_practice_id,area_of_practice_name) values (9,'Business Law');

UPDATE area_of_practices 
SET 
    area_of_practice_name = 'civil Law'
WHERE
    area_of_practice_id = 1;
UPDATE area_of_practices 
SET 
    area_of_practice_name = 'Bankruptcy Law'
WHERE
    area_of_practice_id = 5;

insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (1,1000);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (2,1000);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (1,1001);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (5,1001);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (9,1001);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (1,1003);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (5,1003);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (6,1003);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (8,1003);

DELETE FROM attorney_area_of_practices 
WHERE
    area_of_practice_id = 1;
DELETE FROM attorney_area_of_practices 
WHERE
    area_of_practice_id = 2;
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (2,1000);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (1,1000);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (1,1001);
insert into attorney_area_of_practices(area_of_practice_id, attorney_id ) values (1,1003);

insert into awards(award_id , award_name) values(1,'Alexander Award');
insert into awards(award_id , award_name) values(2,'Gambrell Awards');
insert into awards(award_id , award_name) values(3,'John Marshall Award');
insert into awards(award_id , award_name) values(4,'Publico Awards');
insert into awards(award_id , award_name) values(5,'Smith Award');
insert into awards(award_id , award_name) values(6,'Keane Award');

insert into law_firm_has_awards(law_firm_id, award_id) values(100,1);
insert into law_firm_has_awards(law_firm_id, award_id) values(100,5);
insert into law_firm_has_awards(law_firm_id, award_id) values(100,3);
insert into law_firm_has_awards(law_firm_id, award_id) values(101,3);
insert into law_firm_has_awards(law_firm_id, award_id) values(101,4);
insert into law_firm_has_awards(law_firm_id, award_id) values(103,2);
insert into law_firm_has_awards(law_firm_id, award_id) values(103,5);
insert into law_firm_has_awards(law_firm_id, award_id) values(103,1);

DELETE FROM law_firm_has_awards 
WHERE
    law_firm_id = 103;
insert into law_firm_has_awards(law_firm_id, award_id) values(103,2);
insert into law_firm_has_awards(law_firm_id, award_id) values(103,5);
insert into law_firm_has_awards(law_firm_id, award_id) values(103,1);

insert into salary_details(year_of_experiance, salary, law_firm_id) values (1,100000,100);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (3,300000,100);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (9,900000,100);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (1,110000,101);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (4,400000,101);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (3,900000,101);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (1,111000,102);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (3,235000,102);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (9,785000,102);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (1,120000,103);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (3,330000,103);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (9,800000,103);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (1,121000,104);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (3,335000,104);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (9,885000,104);

DELETE FROM salary_details 
WHERE
    year_of_experiance = 3
    AND law_firm_id = 103;
DELETE FROM salary_details 
WHERE
    year_of_experiance = 1;
insert into salary_details(year_of_experiance, salary, law_firm_id) values (1,100000,100);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (1,110000,101);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (1,120000,103);
insert into salary_details(year_of_experiance, salary, law_firm_id) values (3,330000,103);

insert into judges(judge_id,judge_name) values (1111,'Ashok');
insert into judges(judge_id,judge_name) values (2222,'Arun');
insert into judges(judge_id,judge_name) values (3333,'Arjun');
insert into judges(judge_id,judge_name) values (4444,'Anish');

DELETE FROM judges 
WHERE
    judge_id = 4444;
DELETE FROM judges 
WHERE
    judge_id = 2222;
insert into judges(judge_id,judge_name) values (2222,'Arun');
insert into judges(judge_id,judge_name) values (4444,'Anish');

alter table courts
drop column court_name;

alter table courts
drop column address;

alter table courts
add judge_id bigint unsigned;

ALTER TABLE courts
ADD CONSTRAINT fk_court_judge
FOREIGN KEY (judge_id) REFERENCES judges(judge_id);

insert into courts(court_id, country, city, judge_id ) values (11,'USA','cincinnati', 2222);
insert into courts(court_id, country, city, judge_id ) values (22,'USA','charlotte', 2222);
insert into courts(court_id, country, city, judge_id ) values (33,'USA','cincinnati', 3333);

DELETE FROM courts 
WHERE
    court_id = 33;
insert into courts(court_id, country, city, judge_id ) values (33,'USA','cincinnati', 3333);

alter table case_categories
rename column case_categorie_name to case_category_name;

insert into case_categories (case_category_id ,case_category_name) values (1, 'civil');
insert into case_categories (case_category_id ,case_category_name) values (2, 'bank');
insert into case_categories (case_category_id ,case_category_name) values (3, 'criminal');

DELETE FROM case_categories 
WHERE
    case_category_id = 3;
insert into case_categories (case_category_id ,case_category_name) values (3, 'criminal');

insert into cases (case_id, case_description, client_id, attorney_id, case_category_id) values 
(5000, 'Hired a buidler to renovate Kitchen which he totally ruined it.',200,1001,1);
insert into cases (case_id, case_description, client_id, attorney_id, case_category_id) values 
(5001, 'applied load to a bank and it bankrupted',201,1002,2);
insert into cases (case_id, case_description, client_id, attorney_id, case_category_id) values 
(5003, 'someone trying to treaten and ask money ',203,1002,3);

insert into cases (case_id, case_description, client_id, attorney_id, case_category_id) values 
(5002, 'Car hit when car was in the parkinglot',201,1001,1);
insert into cases (case_id, case_description, client_id, attorney_id, case_category_id) values 
(5004, 'Money gone in share market',203,1005,2);
insert into cases (case_id, case_description, client_id, attorney_id, case_category_id) values 
(5005, 'some random threaten calls coming ',200,1001,3);

insert into cases (case_id, case_description, client_id, attorney_id, case_category_id) values 
(5006, 'Car hit when car was in the parkinglot',204,1001,1);
insert into cases (case_id, case_description, client_id, attorney_id, case_category_id) values 
(5007, 'Money gone in share market',206,1005,2);
insert into cases (case_id, case_description, client_id, attorney_id, case_category_id) values 
(5008, 'some random threaten calls coming ',205,1001,3);

alter table cases
add column court_id bigint unsigned;

alter table cases
add constraint fk_court_case foreign key (court_id) references courts(court_id);

UPDATE cases 
SET 
    court_id = 11
WHERE
    case_id IN (5000 , 5003, 5007);

UPDATE cases 
SET 
    court_id = 22
WHERE
    case_id IN (5001 , 5002, 5004);

UPDATE cases 
SET 
    court_id = 33
WHERE
    case_id IN (5005 , 5006, 5008);

alter table attorneys
add column year_of_experiance bigint;

alter table attorneys
add constraint fk_attorney_salary_year_of_exp foreign key(year_of_experiance) references salary_details(year_of_experiance);

UPDATE attorneys 
SET 
    year_of_experiance = 1
WHERE
    attorney_id = 1000;

UPDATE attorneys 
SET 
    year_of_experiance = 3
WHERE
    attorney_id = 1001;
UPDATE attorneys 
SET 
    year_of_experiance = 3
WHERE
    attorney_id = 1002;
UPDATE attorneys 
SET 
    year_of_experiance = 9
WHERE
    attorney_id = 1003;
UPDATE attorneys 
SET 
    year_of_experiance = 4
WHERE
    attorney_id = 1004;
UPDATE attorneys 
SET 
    year_of_experiance = 3
WHERE
    attorney_id = 1005;
UPDATE attorneys 
SET 
    year_of_experiance = 1
WHERE
    attorney_id = 1006;
UPDATE attorneys 
SET 
    year_of_experiance = 9
WHERE
    attorney_id = 1007;

alter table bill_details 
rename column bill_invoice_no to invoice_no;

insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(123456,5000,101,200);
insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(456789,4500,103,201);
insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(789456,3500,100,203);

insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(111111,9000,101,200);
insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(222222,5000,103,201);
insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(333333,3001,100,203);

insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(444444,5200,101,202);
insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(555555,4000,103,205);
insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(666666,4500,100,203);

insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(777777,7000,101,200);
insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(888888,6000,103,201);
insert into bill_details (invoice_no, bill_amount, law_firm_id, client_id) values(999999,8500,100,203);

   /* alter table clients
drop constraint fk_client_law_firm;

alter table clients
drop column law_firm_id;*/

insert into law_firm_has_clients values (100,201);
insert into law_firm_has_clients values (100,203);
insert into law_firm_has_clients values (101,200);
insert into law_firm_has_clients values (101,201);
insert into law_firm_has_clients values (101,204);
insert into law_firm_has_clients values (101,205);
insert into law_firm_has_clients values (103,203);
insert into law_firm_has_clients values (103,206);

alter table attorneys 
drop constraint fk_attorney_salary_year_of_exp;

alter table attorneys
drop column year_of_experiance;

drop table  salary_details;
