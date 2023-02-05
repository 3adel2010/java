package com.example.spring_week4_day4_exc.repository;

import com.example.spring_week4_day4_exc.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>
{
    Movie findMovieByName(String name);
    List<Movie> findMovieByDirectorId(Integer id);
@Query("select a from Movie a where a.rating >= ?1")
    List<Movie> findMovieByRating(Integer rates);
    List<Movie> findMovieByGenre(String genre);
}
