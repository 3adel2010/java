package com.example.spring_week5_day5_pro.Repository;

import com.example.spring_week5_day5_pro.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>
{
    Book findBookById(Integer id);
    Book findBookByName(String name);
}
