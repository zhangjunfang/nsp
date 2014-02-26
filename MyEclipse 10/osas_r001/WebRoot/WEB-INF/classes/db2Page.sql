--DB2分页查询

　　SELECT * FROM (Select 字段1,字段2,字段3,rownumber() over(ORDER BY 排序用的列名 ASC) AS rn from 表名) AS a1 WHERE a1.rn BETWEEN 10 AND 20

--　　以上表示提取第10到20的纪录

　　select * from (select rownumber() over(order by id asc ) as rowid from table where rowid <=endIndex ) where rowid > startIndex

--　　如果Order By 的字段有重复的值，那一定要把此字段放到 over()中

select * from ( select ROW_NUMBER() OVER(ORDER BY DOC_UUID DESC) AS ROWNUM, DOC_UUID, DOC_DISPATCHORG,       DOC_SIGNER, DOC_TITLE    from DT_DOCUMENT  ) a  where ROWNUM > 20 and ROWNUM <=30


--增加行号，不排序

select * from ( select ROW_NUMBER() OVER() AS ROWNUM,t.*  from DT_DOCUMENT  t ) a

--增加行号，按某列排序

select * from ( select ROW_NUMBER() OVER( ORDER BY DOC_UUID DESC ) AS ROWNUM,t.*  from DT_DOCUMENT  t ) a 