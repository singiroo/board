package kr.or.ddit;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//repository + service : root-context.xml
//sqlSessionTemplate : datasource-context.xml
//transaction : transaction-context.xml

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/spring/root-context.xml",
								   "classpath:kr/or/ddit/db/datasource_dev-context.xml",
								   "classpath:kr/or/ddit/spring/transaction-context.xml"})
public class ModelTestConfig {
	
	@Resource(name = "dataSource")
	public DataSource dataSource;
	
	@Ignore
	@Test
	public void dummy() {}
	
	
  @Before public void setup() { 
	  ResourceDatabasePopulator populator = new ResourceDatabasePopulator(); 
	  populator.addScripts( new ClassPathResource("/kr/or/ddit/db/initData.sql"));
	  populator.setContinueOnError(false); //스크립트 실행 중 error 발생시 멈춤.
	  DatabasePopulatorUtils.execute(populator, dataSource);
	  
  }
	 
	
	
	
}