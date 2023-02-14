package com.example.spring_week6_day2.service;

import com.example.spring_week6_day2.apiException.ApiException;
import com.example.spring_week6_day2.model.Blog;
import com.example.spring_week6_day2.model.MyUser;
import com.example.spring_week6_day2.repository.BlogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BlogService
{
    private final BlogRepository blogRepository;

    public List<Blog> getBlog(MyUser myUser)
    {
        List blogs = blogRepository.getMyBlogs(myUser.getId());
        return blogRepository.findAll();
    }
    public void addBlog(MyUser myUser, Blog blog)
    {
        blog.setMyUser(myUser);
        blogRepository.save(blog);
    }
    public boolean updateBlog(MyUser myUser, Integer id,Blog blog)
    {
        Blog blog1 = blogRepository.findBlogById(id);
        if(blog1==null||blog1.getId()!=myUser.getId())
            return false;
        blog.setMyUser(myUser);
        blog.setId(blog1.getId());
        blogRepository.save(blog);
        return true;
    }
    public boolean deleteBlog(Integer id,MyUser myUser)
    {
        Blog blog = blogRepository.findBlogById(id);
        if(blog==null||blog.getMyUser().getId()!=myUser.getId())
            return false;
        blogRepository.delete(blog);
        return true;
    }

    public Blog getBlog(Integer id){
        Blog blog=blogRepository.findBlogById(id);
        if(blog==null){
            throw new ApiException("the Id is not correct");
        }
        return blog;
    }

    public Blog getBlogByTitle(String title){
        Blog blog=blogRepository.findByTitle(title);
        if(blog==null){
            throw new ApiException("the Id is not correct");
        }
        return blog;
    }

}
