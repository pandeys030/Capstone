
-- use instagram;
-- create table employee(
-- emp_id int ,
-- emp_name varchar(50),
-- dept varchar(20),
-- salary int,
-- join_date date
-- );
 -- use instagram;
-- insert into employee values
-- (1,'AAA', 'IT', 50000, '2021-01-10'),
-- (1,'BBB', 'IT', 60000, '2020-03-15'),
-- (1,'CCC', 'IT', 60000, '2022-07-01'),
-- (1,'DDD', 'HR' ,40000, '2019-05-21'),
-- (1,'EEE', 'HR', 45000, '2021-11-11'),
-- (1,'FFF', 'HR', 45000, '2020-02-18'),
-- (1,'GGG', 'Sales', 55000, '2021-08-08'),
-- (1,'HHH', 'Sales', 50000, '2022-04-04'),
-- (1,'III', 'Sales', 60000, '2020-12-12'),
-- (1,'JJJ', 'Sales', 60000, '2019-06-06'),
-- (1,'KKK', 'Finance', 65000, '2018-09-09'),
-- (1,'LLL', 'Finance', 62000, '2021-10-10'),
-- (1,'MMM', 'Finance', 62000, '2022-02-02'),
-- (1,'NNN', 'IT', 52000, '2023-01-01'),
-- (1,'OOO', 'HR', 15000, '2022-09-09');

-- select *from employee;

-- BASIC SYNTAX
-- window_function(expression)
-- over(
-- partition by column
-- order by column

-- Basic:
-- q1) Assign row number by salary (highest first)
-- select emp_name,salary,
-- row_number() over(order by salary desc) as rn
-- from employee;

-- q2) rownumber within each department
-- select emp_name, dept,
-- row_number() over (partition by dept order by emp_id) as rn 
-- from employee;

-- select emp_id, emp_name,join_date,
-- row_number() over (order by join_date) as join_order
-- from employee;

-- get latest joined employee in each department
-- select * from (
-- select *, row_number() over 
-- (partition by dept order by join_date desc ) rn
-- from employee) X WHERE rn = 1;

-- get top 2 employees by salary as per dept
select *from(
select *, row_number() over (
partition by dept order by salary desc) rn
from employee) X where rn<=2;