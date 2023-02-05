package com.example.spring_week4_day4_exc.service;

import com.example.spring_week4_day4_exc.apiException.ApiException;
import com.example.spring_week4_day4_exc.model.Director;
import com.example.spring_week4_day4_exc.repository.DirectorRepository;
import jakarta.persistence.SqlResultSetMapping;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService
{
    private final DirectorRepository directorRepository;

    public List<Director> getDirector()
    {
        return directorRepository.findAll();
    }
    public void addDirector(Director director)
    {
        directorRepository.save(director);
    }
    public boolean updateDirector(Integer id,Director director)
    {
        Director director1 = directorRepository.getById(id);
        if(director1 == null)
        {
            return false;
        }
        director.setId(id);
        directorRepository.save(director);
        return true;
    }
    public boolean deleteDirector(Integer id)
    {
        Director director = directorRepository.getById(id);
        if(director == null)
        {
            return false;
        }
        directorRepository.delete(director);
        return true;
    }
    public Director findName(String name)
    {
        Director director1 = directorRepository.findAllByName(name);
        if(director1 == null)
        {
            throw new ApiException("Name is not found!");
        }
        return director1;
    }
}
