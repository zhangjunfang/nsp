select 
      -- cap_syscode.ORDER_ID,
      -- cap_syscode.REMARK,
       cap_syscode.SYSCODE_ID,
      --distinct( cap_syscode.SYSCODE_NAME) as SYSCODE_NAME  , 
       --cap_syscode.SYSCODE_TYPE_ID , 
       cap_syscode.SYSCODE_NAME,
       cap_syscode_type.SYSCODE_TYPE_NAME,
       cap_syscode_type.SYSCODE_TYPE_ID
       
from    
       cap_syscode  code , cap_syscode_type   types
where  
      --(cap_syscode.order_id= cap_syscode_type.order_id) and 
      cap_syscode.SYSCODE_TYPE_ID= cap_syscode_type.SYSCODE_TYPE_ID 
      

--group by
       --cap_syscode_type.SYSCODE_TYPE_NAME
      
-- order by
      
       --cap_syscode.order_id  