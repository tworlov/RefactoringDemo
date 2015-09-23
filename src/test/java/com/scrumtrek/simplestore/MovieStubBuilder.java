package com.scrumtrek.simplestore;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieStubBuilder {
	private Movie movie;

	private String movieTitle = "defaultTitle";
	private PriceCodes priceCode = PriceCodes.Sales;

	public MovieStubBuilder withMovieTitle(String movieTitle) {

		this.movieTitle = movieTitle;
		return this;

	}

	public MovieStubBuilder withPriceCodes(PriceCodes priceCode) {

		this.priceCode = priceCode;
		return this;

	}

	public Movie build() {
		movie = mock(Movie.class);
		when(movie.getTitle()).thenReturn(this.movieTitle);
		when(movie.getPriceCode()).thenReturn(this.priceCode);
		return movie;

	}

}
