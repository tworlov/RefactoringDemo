package com.scrumtrek.simplestore;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RentalStubBuilder {

	private Rental rental;
	private Movie movie;
	private int rentalDays;

	public RentalStubBuilder withMovie(Movie movie) {

		this.movie = movie;
		return this;

	}

	public RentalStubBuilder withRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
		return this;

	}

	public Rental build() {
		rental = mock(Rental.class);
		when(rental.getMovie()).thenReturn(this.movie);
		when(rental.getDaysRented()).thenReturn(this.rentalDays);
		return rental;

	}

}
