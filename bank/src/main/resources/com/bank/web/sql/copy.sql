create table emp_copy as 
select employee_id as 사원번호, last_name as 성, salary as 연봉 from EMPLOYEES;

select * from emp_copy;

select 