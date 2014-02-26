　--从数据库表中的第M条记录开始取N条记录，利用Top关键字：注意如果Select语句中既有top，又有order by，则是从排序好的结果集中选择：

　　SELECT *

　　FROM ( SELECT Top N *

　　FROM (SELECT Top (M + N - 1) * FROM 表名称 Order by 主键 desc) t1 ) t2

　　Order by 主键 asc

　--　例如从表Sys_option(主键为sys_id)中从10条记录还是检索20条记录，语句如下：

　　SELECT *

　　FROM ( SELECT TOP 20 *

　　FROM (SELECT TOP 29 * FROM Sys_option order by sys_id desc) t1) t2

　　Order by sys_id asc