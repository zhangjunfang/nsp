　--My SQL数据库最简单，是利用mySQL的LIMIT函数,LIMIT [offset,] rows从数据库表中M条记录开始检索N条记录的语句为：

　　SELECT * FROM 表名称 LIMIT M,N

　--　例如从表Sys_option(主键为sys_id)中从10条记录还是检索20条记录，语句如下：

　　select * from sys_option limit 10,20