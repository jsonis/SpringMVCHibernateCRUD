package com.usps.postalone.postalwizard.web.persistence.mapper.gen;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Collection;

import javax.annotation.Resource;

import model.ESRate;

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
import com.usps.postalone.postalwizard.web.domain.postagestatement.FirstClassPostageStatement;
import com.usps.postalone.postalwizard.web.domain.postagestatement.FirstClassPostageStatementBuilder;
import com.usps.postalone.postalwizard.web.persistence.mapper.gen.ESRateMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:WebContent/WEB-INF/applicationContext.xml")
@ActiveProfiles("integration")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
public class ESRateMapperTest {

	@Resource
	ESRateMapper mapperUnderTest;
	
	FirstClassPostageStatementBuilder builder = FirstClassPostageStatementBuilder.firstClassPostageStatement().withTotalPieces(1000);
	
	@Test
	public void testGetExtraServices() {
		FirstClassPostageStatement statement = builder.withTotalPieces(1000).build();
		assertThat(mapperUnderTest.getExtraServices(statement).size(), greaterThan(0));
		assertThat(mapperUnderTest.getInsuredMailMinRateWithValueOver200(statement.getFormType()), greaterThan(0.0));
	}
	
	@Test
	public void testThatPiecePricesReturn() {
		Collection<ESRate> rates = mapperUnderTest.getExtraServices(builder.build());
		assertThat(rates.size(), greaterThan(0));
		
		for (ESRate rate : rates) {
			if ("CM".equals(rate.getServiceCode())) {
				assertThat(rate.getRate(), greaterThan(BigDecimal.ZERO));
			}
		}
	}

}
