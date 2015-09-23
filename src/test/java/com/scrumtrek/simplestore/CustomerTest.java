package com.scrumtrek.simplestore;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
//import static org.junit.Assert.*;

public class CustomerTest {

	Customer sut;
	Movie stubMovie;
	Rental stubRental;

	@Before
	public void setUp() {
		stubMovie = mock(Movie.class);
		stubRental = mock(Rental.class);
		sut = new Customer("TestCustomer");
		sut.addRental(stubRental);
		when(stubRental.getMovie()).thenReturn(stubMovie);

	}

	@Test
	public void shouldGetTotalAmount12WhenRentalNewRelise4Day() {

		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.NewRelease);
		when(stubRental.getDaysRented()).thenReturn(4);
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(12.0);

	}

	@Test
	public void shouldGetTotalAmountWhenRentNewRelise1Day() {

		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.NewRelease);
		when(stubRental.getDaysRented()).thenReturn(1);
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(3.0);

	}

	@Test
	public void shouldGetStatmentWhenRentChildren4Day() {

		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);
		when(stubRental.getDaysRented()).thenReturn(4);
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(1.5);

	}

	@Test
	public void shouldGetStatmentWhenRentChildren2Day() {

		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);
		when(stubRental.getDaysRented()).thenReturn(2);
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(1.5);
		assertThat(sut.getName()).isEqualTo("TestCustomer");
	}

	@Test
	public void shouldGetStatmentWhenRentRegular4Day() {
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Regular);
		when(stubRental.getDaysRented()).thenReturn(4);
		sut.Statement();
		assertThat(sut.getTotalAmount()).isEqualTo(5.0);

	}

	@Test
	public void shouldGetStatmentWhenRentRegular1Day() {
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Regular);
		when(stubRental.getDaysRented()).thenReturn(1);
		sut.Statement();
		assertThat(sut.getTotalAmount())
			.isEqualTo(2.0)
			.isNotEqualTo(3.0);
	}
	

	@Test
	public void shouldGetStatmentWhenRentSales1Day() {
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Sales);
		when(stubRental.getDaysRented()).thenReturn(1);
		sut.Statement();
		assertThat(sut.getTotalAmount())
			.isEqualTo(0.0)
			.isNotEqualTo(3.0);
	}
	

}