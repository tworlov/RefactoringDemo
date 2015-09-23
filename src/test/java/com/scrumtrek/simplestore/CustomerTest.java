package com.scrumtrek.simplestore;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.Parameterized;
//import org.junit.runners.Parameterized.Parameters;


//@RunWith(Parameterized.class)



public class CustomerTest {
	
	/*@Parameters
	
	public static Collection<Object[]> data(){
		
		return Arrays.asList(new Object[][]{
			
			{4,PriceCodes.NewRelease,12.0}
			
		});
		
	}*/

	private Customer sut;

	@Before
	public void setUp() {
		sut = new Customer("TestCustomer");

	}

	@Test
	public void shouldGetTotalAmount12WhenRentalNewRelise4Day() {
		sut.addRental(new RentalStubBuilder().withRentalDays(4).withMovie(new MovieStubBuilder().withPriceCodes(PriceCodes.NewRelease).build()).build());
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(12.0);

	}

	@Test
	public void shouldGetTotalAmountWhenRentNewRelise1Day() {
		sut.addRental(new RentalStubBuilder().withRentalDays(1).withMovie(new MovieStubBuilder().withPriceCodes(PriceCodes.NewRelease).build()).build());
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(3.0);

	}

	@Test
	public void shouldGetStatmentWhenRentChildren4Day() {
		sut.addRental(new RentalStubBuilder().withRentalDays(4).withMovie(new MovieStubBuilder().withPriceCodes(PriceCodes.Childrens).build()).build());
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(1.5);

	}

	@Test
	public void shouldGetStatmentWhenRentChildren2Day() {
		sut.addRental(new RentalStubBuilder().withRentalDays(2).withMovie(new MovieStubBuilder().withPriceCodes(PriceCodes.Childrens).build()).build());
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(1.5);
		assertThat(sut.getName()).isEqualTo("TestCustomer");
	}

	@Test
	public void shouldGetStatmentWhenRentRegular4Day() {
		sut.addRental(new RentalStubBuilder().withRentalDays(4).withMovie(new MovieStubBuilder().withPriceCodes(PriceCodes.Regular).build()).build());
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(5.0);

	}

	@Test
	public void shouldGetStatmentWhenRentRegular1Day() {
		sut.addRental(new RentalStubBuilder().withRentalDays(1).withMovie(new MovieStubBuilder().withPriceCodes(PriceCodes.Regular).build()).build());
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(2.0);
	}

	@Test
	public void shouldGetStatmentWhenRentSales1Day() {
		sut.addRental(new RentalStubBuilder().withRentalDays(1).withMovie(new MovieStubBuilder().withPriceCodes(PriceCodes.Sales).build()).build());
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(0.0);
	}

}