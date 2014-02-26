select
        cap_department.DEPARTMENT_ID,cap_department.DEPARTMENT_NAME,
        
        cap_department.PARENT_ID,cap_staff.STAFF_ID,cap_staff.STAFF_NAME
from
        cap_department ,cap_staff
where 
       (cap_department.DEPARTMENT_ID= cap_staff.DEPARTMENT_ID ) 
       
       
 select cap_department.DEPARTMENT_ID,cap_department.PARENT_ID,cap_department.DEPARTMENT_NAME  from cap_department 