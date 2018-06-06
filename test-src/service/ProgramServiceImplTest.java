package com.usps.postalone.postalwizard.web.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.usps.postalone.postalwizard.web.domain.postagestatement.FirstClassPostageStatement;
import com.usps.postalone.postalwizard.web.domain.postagestatement.PostageStatement;
import com.usps.postalone.postalwizard.web.domain.rates.PostageRates;
import com.usps.postalone.postalwizard.web.domain.rates.RatesBlock;
import com.usps.postalone.postalwizard.web.domain.rates.RatesSection;
import com.usps.postalone.postalwizard.web.domain.rates.items.BasicRatesLineItem;
import com.usps.postalone.postalwizard.web.domain.rates.items.RatesLineItem;
import com.usps.postalone.postalwizard.web.persistence.mapper.LegacyPostageStatementMapper;
import com.usps.postalone.postalwizard.web.service.PostageStatementServiceImpl;

public class PostageStatementServiceImplTest {

	private PostageStatementServiceImpl serviceUnderTest;
	
	private LegacyPostageStatementMapper mockMapper;
	
	private PostageStatement statement;
	private BasicRatesLineItem rateItem;
	private List<BasicRatesLineItem> ratesList = new ArrayList<BasicRatesLineItem>();
	
	@Before
	public void setUp() throws Exception {
		serviceUnderTest = new PostageStatementServiceImpl();
		
		mockMapper = mock(LegacyPostageStatementMapper.class);
		serviceUnderTest.setLegacyPostageStatementMapper(mockMapper);
		
		statement = new FirstClassPostageStatement();
		statement.setEmailPDF(false);
		rateItem = new BasicRatesLineItem();
		rateItem.setTotalPieces(1);
		ratesList.add(rateItem);
		
		PostageRates rates = new PostageRates();
		rates.addSection(new RatesSection());
		rates.getRatesSections().get(0).addBlock(new RatesBlock());
		rates.getRatesSections().get(0).getRatesBlocks().get(0).addItem(rateItem);
		statement.setPostageRates(rates);
	}

	@Test
	public void testCreateLegacyStatement() {
		//GIVEN
		when(mockMapper.getNewMailingGroupSeqNo()).thenReturn(1L);
		when(mockMapper.getNewPostageStatementSeqNo()).thenReturn(2L);
		
		//WHEN
		serviceUnderTest.createLegacyStatement(statement);
		
		//THEN
		assertTrue(Long.valueOf(1L).equals(statement.getMailingGroupSeqNo()));
		assertTrue(Long.valueOf(2L).equals(statement.getPostageStatementSeqNo()));
		
		verify(mockMapper).insertMailingGroup(statement);
		verify(mockMapper).insertPostageStatement(statement);
		
		for (BasicRatesLineItem lineItem : ratesList) {
			verify(mockMapper).insertFirstClassLines(eq(statement), eq(lineItem));
		}
	}
	
	@Test
	public void testCreateLegacyStatementWithCtrCounts() {
		//GIVEN
		when(mockMapper.getNewMailingGroupSeqNo()).thenReturn(1L);
		when(mockMapper.getNewPostageStatementSeqNo()).thenReturn(2L);
		
		//WHEN
		serviceUnderTest.createLegacyStatement(statement);
		
		//THEN
		assertTrue(Long.valueOf(1L).equals(statement.getMailingGroupSeqNo()));
		assertTrue(Long.valueOf(2L).equals(statement.getPostageStatementSeqNo()));
		
		verify(mockMapper).insertMailingGroup(statement);
		verify(mockMapper).insertPostageStatement(statement);
		
		for (RatesLineItem lineItem : ratesList) {
			verify(mockMapper).insertFirstClassLines(eq(statement), eq(lineItem));
		}
	}

}
