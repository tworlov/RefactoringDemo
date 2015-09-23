package com.scrumtrek.simplestore;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)



public class CustomerTest {
	
	private int i;
	private PriceCodes p;
	private double d;
	
	public CustomerTest(int i, PriceCodes p, double d) {
		 this.i =i;
		 this.p = p;
		 this.d = d;
		
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		
		return Arrays.asList(new Object[][]{
			{4,PriceCodes.NewRelease,12.0},
			{1,PriceCodes.NewRelease,3.0},
			{4,PriceCodes.Childrens,1.5},
			{2,PriceCodes.Childrens,1.5},
			{4,PriceCodes.Regular,5.0},
			{1,PriceCodes.Regular,2.0},
			{1,PriceCodes.Sales,0.0}
			
		});
		
	}

	private Customer sut;

	@Before
	public void setUp() {
		sut = new Customer("TestCustomer");

	}

	@Test
	public void shouldGetTotalAmount12WhenRentalNewRelise4Day() {
		sut.addRental(new RentalStubBuilder().withRentalDays(i).withMovie(new MovieStubBuilder().withPriceCodes(p).build()).build());
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(d);

	}
	
}