package com.booking;

import java.util.List;

public interface MoviesDAO 

{
	String addMovie(Movies movies);
	String updateMovie(Movies movies);
	String viewMovie(int id);
	List<Movies> viewMovieList();
	
}
