package com.example.spring_week4_day4_exc.service;

import com.example.spring_week4_day4_exc.apiException.ApiException;
import com.example.spring_week4_day4_exc.controller.MovieController;
import com.example.spring_week4_day4_exc.model.Director;
import com.example.spring_week4_day4_exc.model.Movie;
import com.example.spring_week4_day4_exc.repository.DirectorRepository;
import com.example.spring_week4_day4_exc.repository.MovieRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService
{
    private final MovieRepository movieRepository;
    private final DirectorRepository directorRepository;

    public List<Movie> getMovie()
    {
        return movieRepository.findAll();
    }

    public void addMove(Movie movie)
    {
        movieRepository.save(movie);
    }

    public boolean updateMovie(Integer id,Movie movie)
    {
        Movie movieId = movieRepository.getById(id);

        if(movieId == null)
            return false;

        movieId.setName(movie.getName());
        movieId.setGenre(movie.getGenre());
        movieId.setRating(movie.getRating());
        movieId.setDuration(movie.getDuration());
        movieId.setDirectorId(movie.getDirectorId());
        movieRepository.save(movieId);
        return true;
    }

    public boolean deleteMovie(Integer id)
    {
        Movie movie = movieRepository.getReferenceById(id);

        if(movie == null)
        {
            return false;
        }
        movieRepository.delete(movie);
        return true;
    }
    public Movie findMovieByName(String name)
    {
        Movie movie = movieRepository.findMovieByName(name);
        if (movie == null)
        {
            throw new ApiException("This movie is not found!");
        }
        return movie;
    }
    public Movie findMovieByTitle(String name)
    {
        Movie movie = movieRepository.findMovieByName(name);
        if(movie == null)
        {
            throw new ApiException("This movie is not found!");
        }
        return movie;
    }
    public Director getDirectorName(String name)
    {
        Movie movie = movieRepository.findMovieByName(name);

        if(movie == null)
            throw new ApiException("Name is not found!");

        Integer dir = movie.getDirectorId();
        Director director = directorRepository.findAllByIdEquals(dir);

        if(director == null)
            throw new ApiException("Name is not found!");

        return director;
    }
    public List<Movie> getAllMovesOfDirector(Integer id)
    {
        Director dirId = directorRepository.findAllByIdEquals(id);
        if(dirId == null)
            throw new ApiException("The director id is not found!");

        List<Movie> move = movieRepository.findMovieByDirectorId(id);
        return move;
    }
    public Integer getRateByName(String name)
    {
        Movie movie = movieRepository.findMovieByName(name);
        if(movie == null)
            throw new ApiException("This movie is not found!");

        return movie.getRating();
    }
    public List<Movie> getAllMoviesAboveRating(Integer rate)
    {
        List<Movie> rates = movieRepository.findMovieByRating(rate);
        if(rates == null)
            throw new ApiException("This rate not found!");

        return rates;
    }
    public List<Movie> findMovieByGenre(String genre)
    {
        List<Movie> movie = movieRepository.findMovieByGenre(genre);
        if (movie.isEmpty())
            throw new ApiException("This genre is not found!");
        return movie;
    }
}
