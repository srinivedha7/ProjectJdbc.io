package com.cognizant.movie.model;

import java.util.List;

public class Favorites {
	private List<Movies> movieList;
	private int noOfFavorites;
	private Long totalGross;

	public Favorites() {
		super();
	}

	public List<Movies> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movies> movieList) {
		this.movieList = movieList;
	}

	public int getNoOfFavorites() {
		return noOfFavorites;
	}

	public void setNoOfFavorites(int noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}

	public Long getTotalGross() {
		return totalGross;
	}

	public void setTotalGross(Long totalGross) {
		this.totalGross = totalGross;
	}

}
