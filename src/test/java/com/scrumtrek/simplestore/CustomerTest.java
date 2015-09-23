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

	}

	@Test
	public void shouldGetStatmentWhenRentNewRelise4Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.NewRelease);
		when(stubRental.getDaysRented()).thenReturn(4);

		assertThat(sut.Statement()).isEqualTo(
				"Rental record for TestCustomer\n\tnull\t12.0\nAmount owed is 12.0\nYou earned 2 frequent renter points.");
	}

	@Test
	public void shouldGetStatmentWhenRentNewRelise1Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.NewRelease);
		when(stubRental.getDaysRented()).thenReturn(1);

		assertThat(sut.Statement()).isEqualTo(
				"Rental record for TestCustomer\n\tnull\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points.");

	}

	@Test
	public void shouldGetStatmentWhenRentChildren4Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);
		when(stubRental.getDaysRented()).thenReturn(4);

		assertThat(sut.Statement()).isEqualTo(
				"Rental record for TestCustomer\n\tnull\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points.");

	}

	@Test
	public void shouldGetStatmentWhenRentChildren2Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);
		when(stubRental.getDaysRented()).thenReturn(2);

		assertThat(sut.Statement()).isEqualTo(
				"Rental record for TestCustomer\n\tnull\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points.");

	}

	@Test
	public void shouldGetStatmentWhenRentRegular4Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Regular);
		when(stubRental.getDaysRented()).thenReturn(4);

		assertThat(sut.Statement()).isEqualTo(
				"Rental record for TestCustomer\n\tnull\t5.0\nAmount owed is 5.0\nYou earned 1 frequent renter points.");

	}

	@Test
	public void shouldGetStatmentWhenRentRegular1Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Regular);
		when(stubRental.getDaysRented()).thenReturn(1);

		assertThat(sut.Statement()).isEqualTo(
				"Rental record for TestCustomer\n\tnull\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points.");

	}

}