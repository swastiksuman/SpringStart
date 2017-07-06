package com.swastik.test.tests;

import static org.junit.Assert.assertEquals;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swastik.dao.OffersDAO;

@ActiveProfiles("dev")
@ContextConfiguration(locations={"classpath:com/swastik/config/dao-context.xml", 
								 "classpath:com/swastik/config/security-context.xml",
								 "classpath:com/swastik/test/config/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTest {
	
	@Autowired
	private OffersDAO offersDao;
	
	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init(){
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
	}
	@Test
	public void testCreateUser(){
		assertEquals(offersDao.getOffer("Swastik").getName(), "Swastik");
		assertEquals(offersDao.getOffer("Souj").getId(), 1234);
	}
	
}
