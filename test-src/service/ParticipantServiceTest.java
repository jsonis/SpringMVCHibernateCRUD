package com.usps.postalone.postalwizard.web.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.usps.postalone.postalwizard.web.domain.rates.PostageRates;
import com.usps.postalone.postalwizard.web.persistence.mapper.RatesMapper;
import com.usps.postalone.postalwizard.web.service.RatesService;
import com.usps.postalone.postalwizard.web.testsupport.builders.PostageStatementBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/applicationContext.xml")
@ActiveProfiles("integration")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
//@DatabaseSetup(type = DatabaseOperation.CLEAN_INSERT, value = "/base-dataset.xls")
//@DbUnitConfiguration(dataSetLoader = XlsDataSetLoader.class)
public class RatesServiceTest {

	@Autowired
	RatesService ratesService;
	
	@Autowired
	RatesMapper ratesMapper;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPostageRatesFirstClassPostageStatement() {
		PostageRates rates = ratesService.getPostageRates(PostageStatementBuilder.createDefaultFirstClassStatement());
		assertTrue(rates.getRatesSections().size() > 0);
	}

}
