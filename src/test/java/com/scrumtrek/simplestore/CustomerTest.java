package com.scrumtrek.simplestore;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

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

		sut.Statement();

	}

	@Test
	public void shouldGetStatmentWhenRentNewRelise1Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.NewRelease);
		when(stubRental.getDaysRented()).thenReturn(1);

		sut.Statement();

	}

	@Test
	public void shouldGetStatmentWhenRentChildren4Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);
		when(stubRental.getDaysRented()).thenReturn(4);

		sut.Statement();

	}

	@Test
	public void shouldGetStatmentWhenRentChildren2Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Childrens);
		when(stubRental.getDaysRented()).thenReturn(2);

		sut.Statement();

	}

	@Test
	public void shouldGetStatmentWhenRentRegular4Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Regular);
		when(stubRental.getDaysRented()).thenReturn(4);

		sut.Statement();

	}

	@Test
	public void shouldGetStatmentWhenRentRegular1Day() {

		when(stubRental.getMovie()).thenReturn(stubMovie);
		when(stubMovie.getPriceCode()).thenReturn(PriceCodes.Regular);
		when(stubRental.getDaysRented()).thenReturn(1);

		sut.Statement();

	}

}