package com.example.spring_week4_day4_exc.controller;

import com.example.spring_week4_day4_exc.model.Director;
import com.example.spring_week4_day4_exc.model.Movie;
import com.example.spring_week4_day4_exc.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController
{
    private final MovieService movieService;

    @GetMapping("/get")
    public ResponseEntity getMovie()
    {
        List<Movie> movieList = movieService.getMovie();
        return ResponseEntity.status(200).body(movieList);
    }
    @PostMapping("/add")
    public ResponseEntity addMovie(@Valid @RequestBody Movie movie)
    {
        movieService.addMove(movie);
        return ResponseEntity.status(200).body("Movie added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id,@Valid @RequestBody Movie movie)
    {
        boolean isTrue = movieService.updateMovie(id, movie);
        if(!isTrue)
        {
            return ResponseEntity.status(400).body("Wrong ID!");
        }
        return ResponseEntity.status(200).body("Movie updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id)
    {
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted!");
    }
    @GetMapping("/findMovieByName/{name}")
    public ResponseEntity findMovieByName(@PathVariable String name)
    {
        Movie movie = movieService.findMovieByName(name);
        return ResponseEntity.status(200).body(movie);
    }
    @GetMapping("/findDurationByName/{name}")
    public ResponseEntity findDurationByName(@PathVariable String name)
    {
        Movie movie = movieService.findMovieByTitle(name);
        return ResponseEntity.status(200).body(movie.getDuration());
    }
    @GetMapping("/getDirectorName/{name}")
    public ResponseEntity getDirectorName(@PathVariable String name)
    {
        Director directorName = movieService.getDirectorName(name);
        return ResponseEntity.status(200).body(directorName);
    }
    @GetMapping("/getAllMovesOfDirector/{id}")
    public ResponseEntity getAllMovesOfDirector(@PathVariable Integer id)
    {
        List<Movie> movie = movieService.getAllMovesOfDirector(id);
        return ResponseEntity.status(200).body(movie);
    }
    @GetMapping("/getRateByName/{name}")
    public ResponseEntity getRateByName(@PathVariable String name)
    {
        Integer movie = movieService.getRateByName(name);
        return ResponseEntity.status(200).body(movie);
    }
    @GetMapping("/getAllMoviesAboveRating/{rate}")
    public ResponseEntity getAllMoviesAboveRating(@PathVariable Integer rate)
    {
        List<Movie> movie = movieService.getAllMoviesAboveRating(rate);
        return ResponseEntity.status(200).body(movie);
    }
    @GetMapping("/findMovieByGenre/{genre}")
    public ResponseEntity findMovieByGenre(@PathVariable String genre)
    {
        List<Movie> movieList = movieService.findMovieByGenre(genre);
        return ResponseEntity.status(200).body(movieList);
    }
}
