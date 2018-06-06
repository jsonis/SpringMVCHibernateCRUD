package com.usps.postalone.postalwizard.web.persistence.mapper.gen;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.usps.postalone.postalwizard.web.domain.postagestatement.StandardMailPostageStatement;
import com.usps.postalone.postalwizard.web.persistence.mapper.gen.SMRateMapper;
import com.usps.postalone.postalwizard.web.testsupport.builders.PostageStatementBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/applicationContext.xml")
@ActiveProfiles("integration")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class SMRateMapperTest {

	@Resource
	SMRateMapper mapperUnderTest;
	
	StandardMailPostageStatement statement = PostageStatementBuilder.createDefaultStandardMailStatement();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testResultsReturn() {
		assertThat(mapperUnderTest.getStandardMailRates(statement).size(), greaterThan(0));
	}

}
