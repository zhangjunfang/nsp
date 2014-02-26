
--从数据库表中第M条记录开始检索N条记录

　　SELECT *

　　FROM (SELECT ROWNUM r,t1.* From 表名称 t1 where rownum < M + N) t2

　　where t2.r >= M

--　　例如从表Sys_option(主键为sys_id)中从10条记录还是检索20条记录，语句如下：

　　SELECT *

　　FROM (SELECT ROWNUM R,t1.* From Sys_option where rownum < 30 ) t2

　　Where t2.R >= 10


select * from
    (select rownum numrow,FDKFH0000020801.* from 
                          (select t.ID from FDKFH0000020801 t order by t.ID) FDKFH0000020801 ) 
    where numrow >100 and numrow<200