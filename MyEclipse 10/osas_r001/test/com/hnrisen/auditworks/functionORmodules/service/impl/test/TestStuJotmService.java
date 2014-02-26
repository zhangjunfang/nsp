/**
 * 
 */
package com.hnrisen.auditworks.functionORmodules.service.impl.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hnrisen.auditworks.jotm.domain.TabA;
import com.hnrisen.auditworks.jotm.domain.TabB;
import com.hnrisen.auditworks.jotm.service.StuJotmService;


/**
 * @author ocean
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class TestStuJotmService {
	
	private Log log=LogFactory.getLog(TestStuJotmService.class);
	
	@Autowired
    private  StuJotmService ser;
    
    
    @Before
	public void setUp() throws Exception {
		
	}

	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void save(){  
		
		  TabA a = null;
          TabB b = null;
          long  startTime=System.currentTimeMillis();        
         for (int i = 0; i <999; i++) {
          	 a = new TabA();
               a.setId(Long.parseLong(i+""));
               a.setName("aaa");
               a.setAddress("address a");
             
               b = new TabB();
               b.setId(Long.parseLong(i+""));
               b.setName("bbb");
               b.setAddress("address b");
               
               Assert.assertNotNull(ser);
               ser.saveAB(a, b);
               
			}
          log.info("出入 数据 所用时间 ：++++++++++++++++++++++========================"+(System.currentTimeMillis()-startTime));
          

	}
    

  
}
