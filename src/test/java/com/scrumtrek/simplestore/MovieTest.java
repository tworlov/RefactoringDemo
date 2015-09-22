package com.scrumtrek.simplestore;

import static org.junit.Assert.*;

import org.junit.Test;

public class MovieTest {

	@Test
	public void shouldSetTitleCinderellaWhenCreateMovieCinderella() {

		// given

		// when
		Movie cinderella = new Movie("Cinderella", null);

		// then
		assertEquals("Cinderella", cinderella.getTitle());

	}

	@Test
	public void shouldChangePriceCodeWhenSetNewPriceCode() {

		// given
		Movie cinderella = new Movie("Cinderella", PriceCodes.Regular);

		// when
		cinderella.setPriceCode(PriceCodes.Childrens);

		// then
		assertEquals(PriceCodes.Childrens, cinderella.getPriceCode());

	}
	
	

}
