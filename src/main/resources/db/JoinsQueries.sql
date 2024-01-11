
/* 5  QUERIES USING JOINS */
SELECT DISTINCT
    law_firm_id,
    law_firms.law_firm_name,
    COUNT(attorneys.attorney_id) AS no_or_attorneys
FROM
    attorneys
        INNER JOIN
    law_firms ON attorneys.attorney_law_firm_id = law_firms.law_firm_id
GROUP BY law_firm_id;

/*2. List client id ,client name respective attorney id and its law_firm */
SELECT 
    client_id,
    client_name,
    attorneys.attorney_id,
    attorney_law_firm_id
FROM
    attorneys
        RIGHT JOIN
    clients ON attorneys.attorney_law_firm_id = clients.law_firm_id;

/*3. List every client and having no of cases ---group by*/
SELECT DISTINCT
    cases.client_id, COUNT(cases.case_id)
FROM
    clients
        RIGHT JOIN
    cases ON clients.client_id = cases.client_id
GROUP BY cases.client_id;

/*4. An attorney with min  salary_amount -- having*/
SELECT 
    attorneys.attorney_id,
    attorneys.attorney_name,
    salary_details.salary AS minimum_salary
FROM
    attorneys
        INNER JOIN
    salary_details ON attorneys.year_of_experiance = salary_details.year_of_experiance
        AND attorneys.attorney_law_firm_id = salary_details.law_firm_id
HAVING MIN(salary_details.salary);

/*5. List all the attorney id and no of feedbacks he got and respective law_firm*/
/*SELECT 
    feedbacks.attorney_id,
    COUNT(feedbacks.attorney_id) AS no_of_feedbacks,
    feedbacks.law_firm_id
FROM
    feedbacks
        LEFT JOIN
    law_firms ON feedbacks.law_firm_id = law_firms.law_firm_id
GROUP BY feedbacks.attorney_id;*/


 /*7 QUERIES USING GROUP BY WITHOUT HAVING */
SELECT DISTINCT
    attorneys.attorney_id,
    COUNT(attorney_association_bars.association_bar_id)
FROM
    attorneys
        LEFT JOIN
    attorney_association_bars ON attorneys.attorney_id = attorney_association_bars.attorney_id
GROUP BY attorneys.attorney_id;

/*2. Law firm with highest salary for each experiance group by */
SELECT 
    law_firms.law_firm_id,
    law_firms.law_firm_name,
    salary_details.year_of_experiance,
    MAX(salary_details.salary) AS maximum_salary
FROM
    law_firms
        INNER JOIN
    salary_details ON law_firms.law_firm_id = salary_details.law_firm_id
GROUP BY salary_details.year_of_experiance;

/*3. list of attorney and count of area of practices --- group by*/
SELECT 
    attorneys.attorney_id,
    attorneys.attorney_name,
    COUNT(attorney_area_of_practices.area_of_practice_id)
FROM
    attorneys
        LEFT JOIN
    attorney_area_of_practices ON attorneys.attorney_id = attorney_area_of_practices.attorney_id
        INNER JOIN
    area_of_practices ON area_of_practices.area_of_practice_id = attorney_area_of_practices.area_of_practice_id
GROUP BY attorneys.attorney_id;

/*4. awards acheived by each firm */
SELECT 
    law_firms.law_firm_id,
    law_firms.law_firm_name,
    COUNT(law_firm_has_awards.award_id) AS awards_acheived
FROM
    law_firms
        INNER JOIN
    law_firm_has_awards ON law_firms.law_firm_id = law_firm_has_awards.law_firm_id
        INNER JOIN
    awards ON law_firm_has_awards.award_id = awards.award_id
GROUP BY law_firms.law_firm_id;

/*5. List each client and total bill amount */
SELECT 
    bill_details.client_id,
    clients.client_name,
    SUM(bill_details.bill_amount) AS Total_amount
FROM
    bill_details
        INNER JOIN
    law_firms ON bill_details.law_firm_id = law_firms.law_firm_id
        INNER JOIN
    clients ON clients.client_id = bill_details.client_id
GROUP BY bill_details.client_id;

/*6. No of cases Nithya working with -- group by*/
SELECT 
    attorneys.attorney_id,
    attorneys.attorney_name,
    COUNT(cases.case_id) AS No_of_cases
FROM
    cases
        INNER JOIN
    attorneys ON cases.attorney_id = attorneys.attorney_id
WHERE
    attorneys.attorney_name = 'Nithya'
GROUP BY attorneys.attorney_name;

/*7. No of attorneys in firm (concord, charlotte) -- group by*/
SELECT 
    law_firms.law_firm_id,
    law_firms.city,
    COUNT(attorneys.attorney_id) AS count_of_attorney
FROM
    law_firms
        RIGHT JOIN
    attorneys ON law_firms.law_firm_id = attorneys.attorney_law_firm_id
WHERE
    law_firms.city IN ('Charlotte' , 'Concord')
GROUP BY law_firms.law_firm_id , law_firms.city;


/*7 QUERIES USING GROUP BY AND HAVING*/
SELECT 
    law_firms.law_firm_id,
    law_firms.law_firm_name,
    COUNT(clients.client_id)
FROM
    clients
        LEFT JOIN
    law_firms ON law_firms.law_firm_id = clients.law_firm_id
GROUP BY law_firms.law_firm_id
HAVING law_firms.law_firm_name LIKE 'A%';

/*2. List now of case under civil category -- having , group by*/
SELECT 
    case_categories.case_category_name,
    COUNT(case_categories.case_category_id) AS no_of_cases
FROM
    cases
        INNER JOIN
    courts ON cases.court_id = courts.court_id
        INNER JOIN
    clients ON cases.client_id = clients.client_id
        INNER JOIN
    case_categories ON case_categories.case_category_id = cases.case_category_id
GROUP BY case_categories.case_category_name
HAVING case_categories.case_category_name LIKE 'Civil';

/*3. list attorney details in for firm 103 -- group by and having*/
SELECT 
    *
FROM
    attorneys
        INNER JOIN
    law_firms ON attorneys.attorney_law_firm_id = law_firms.law_firm_id
        INNER JOIN
    salary_details ON attorneys.attorney_law_firm_id = salary_details.law_firm_id
GROUP BY attorneys.attorney_name
HAVING law_firms.law_firm_id = 103;

SELECT 
    *
FROM
    association_bars;

/*4. Attorney has no of association acheived above experiannce 2 --group by and having  */
SELECT 
    attorneys.attorney_id,
    attorneys.attorney_name,
    attorneys.year_of_experiance,
    COUNT(attorney_association_bars.association_bar_id) AS no_of_association_bars
FROM
    attorney_association_bars
        INNER JOIN
    association_bars ON attorney_association_bars.association_bar_id = association_bars.association_bar_id
        INNER JOIN
    attorneys ON attorneys.attorney_id = attorney_association_bars.attorney_id
GROUP BY attorneys.attorney_id , attorneys.year_of_experiance
HAVING attorneys.year_of_experiance > 2;

/*5. No of crimial cases --group by and having*/
SELECT 
    cases.case_category_id,
    case_categories.case_category_name,
    COUNT(cases.case_category_id) AS No_of_cases
FROM
    case_categories
        INNER JOIN
    cases ON case_categories.case_category_id = cases.case_category_id
GROUP BY cases.case_category_id , case_categories.case_category_name
HAVING case_categories.case_category_name = 'criminal';

/*6. No of courts in cintinati location -- group by having*/
SELECT 
    courts.court_id, courts.city, COUNT(attorneys.attorney_id)
FROM
    courts
        INNER JOIN
    cases ON courts.court_id = cases.court_id
        INNER JOIN
    attorneys ON cases.attorney_id = attorneys.attorney_id
GROUP BY courts.court_id , courts.city
HAVING courts.city = 'cincinnati';


/*QUERY JOINING ALL THE TABLES*/
SELECT 
    attorneys.attorney_id,
    attorneys.attorney_name,
    attorneys.country,
    attorneys.attorney_law_firm_id,
    law_firms.law_firm_name,
    awards.award_id,
    awards.award_name,
    attorney_association_bars.association_bar_id,
    association_bars.association_bar_name,
    attorney_area_of_practices.area_of_practice_id,
    area_of_practices.area_of_practice_name,
    salary_details.year_of_experiance,
    salary_details.salary,
    clients.client_id,
    clients.client_name,
    cases.case_id,
    cases.case_category_id,
    case_categories.case_category_name,
    courts.court_id,
    judges.judge_id,
    judges.judge_name
FROM
    attorneys
        LEFT JOIN
    law_firms ON attorneys.attorney_law_firm_id = law_firms.law_firm_id
        LEFT JOIN
    salary_details ON salary_details.law_firm_id = law_firms.law_firm_id
        LEFT JOIN
    attorney_association_bars ON attorney_association_bars.attorney_id = attorneys.attorney_id
        LEFT JOIN
    association_bars ON association_bars.association_bar_id = attorney_association_bars.association_bar_id
        LEFT JOIN
    clients ON clients.law_firm_id = law_firms.law_firm_id
        LEFT JOIN
    cases ON cases.client_id = clients.client_id
        LEFT JOIN
    attorney_area_of_practices ON attorney_area_of_practices.attorney_id = attorneys.attorney_id
        LEFT JOIN
    area_of_practices ON area_of_practices.area_of_practice_id = attorney_area_of_practices.area_of_practice_id
        LEFT JOIN
    case_categories ON cases.case_category_id = case_categories.case_category_id
        LEFT JOIN
    courts ON courts.court_id = cases.court_id
        LEFT JOIN
    judges ON judges.judge_id = courts.judge_id
        LEFT JOIN
    law_firm_has_awards ON law_firm_has_awards.law_firm_id = law_firms.law_firm_id
        LEFT JOIN
    awards ON awards.award_id = law_firm_has_awards.award_id; 