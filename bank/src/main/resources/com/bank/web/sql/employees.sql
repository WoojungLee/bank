-- 0. 사원테이블 전체 검색
select * from employees;

-- employee_id, first_name, last_name, email. phone_number, hire_date, job_id
-- salary, commission_pct, manger_id, department_id
select * from departments;
-- department_id, department_name, manager_id, location_id

-- 1. 사원번호, 패밀리네임, 연봉 출력
select employee_id as 사원번호, last_name as 성, salary as 연봉 from EMPLOYEES;
-- 2. 연봉 3000이상인 사원
select employee_id as 사원번호, last_name as 성, salary as 연봉
from EMPLOYEES
where salary >= 3000;
-- 3. 부서번호(department_id)이 100번인 사원
select employee_id as 사원번호, last_name as 성, salary as 연봉, department_id as 부서번호
from EMPLOYEES
where department_id = 100;

-- 4. 입사일이 2000년 1월 1일 이후인 사원
select employee_id as 사원번호, last_name as 성, salary as 연봉, hire_date as 입사일
from EMPLOYEES
where hire_date >= '2000-01-01';

-- 5. 부서가 100번이 아닌 사원
select employee_id as 사원번호, last_name as 성, salary as 연봉, department_id as 부서번호
from EMPLOYEES
where department_id != 100;

select employee_id as 사원번호, last_name as 성, salary as 연봉, department_id as 부서번호
from EMPLOYEES
where department_id <> 100;


-- 6. 연봉이 2000 ~ 3000 (이상, 이하) 사이인 사원
select employee_id as 사원번호, last_name as 성, salary as 연봉
from EMPLOYEES
where salary >= 2000 AND salary <= 3000;

select employee_id as 사원번호, last_name as 성, salary as 연봉
from EMPLOYEES
where salary between 2000 AND 3000;

-- 7. 연봉이 2000~3000 사이에 속하지 않은 사원
select employee_id as 사원번호, last_name as 성, salary as 연봉
from EMPLOYEES
where salary not between 2000 AND 3000;

-- 8. 커미션이 0.2, 0.3, 0.4 인 사원
select employee_id as 사원번호, last_name as 성, commission_pct as 커미션
from EMPLOYEES
where commission_pct in(0.2, 0.3, 0.4);

-- 9. 커미션이 0.2, 0.3, 0.4 이 아닌 사원
select employee_id as 사원번호, last_name as 성, commission_pct as 커미션
from EMPLOYEES
where commission_pct not in(0.2, 0.3, 0.4);

-- 10. 패밀리네임의 시작 알파벳이 K 인 사원
select employee_id as 사원번호, last_name as 성
from EMPLOYEES
where last_name like 'K%';

-- 11. 패밀리네임의 중간 알파벳이 K 인 사원
select employee_id as 사원번호, last_name as 성
from EMPLOYEES
where last_name like '%k%';

-- 12. 패밀리네임의 세번째 알파벳이 a 인 사원
select employee_id as 사원번호, last_name as 성
from EMPLOYEES
where last_name like '__a%';

-- 13. 구글 계정을 사용하는 직원
select employee_id as 사원번호, email as 이메일
from EMPLOYEES
where last_name like '%\@gmail.com%';

-- 14. 커미션을 받지 않는 직원
select employee_id as 사원번호, commission_pct as 커미션
from EMPLOYEES
where commission_pct is null;

-- 15. 커미션을 받는 직원
select employee_id as 사원번호, commission_pct as 커미션
from EMPLOYEES
where commission_pct is not null;

-- 16. 연봉을 적게 받는 순으로 해서 오름차순 정렬
select employee_id as 사원번호, salary 연봉
from EMPLOYEES
order by salary asc;

-- 16-1. 연봉을 많이 받는 순으로 해서 내림차순 정렬
select employee_id as 사원번호, salary 연봉
from EMPLOYEES
order by salary desc;

-- 17. 고액 연봉순 직원리스트(만일, 동일한 연봉을 받으면 패일리네임에 따라 오름차순)
select employee_id as 사원번호, salary 연봉, last_name 성
from EMPLOYEES
order by salary desc, last_name asc;

-- 18. exist 문법 부서번호가 30,60,90인 사원 정보
select e.employee_id 사원번호, e.last_name 이름, e.salary 연봉, e.department_id 부서번호
from EMPLOYEES e
where exists (select d.department_id from departments d where d.department_id in(30, 60, 90) and d.department_id = e.department_id);