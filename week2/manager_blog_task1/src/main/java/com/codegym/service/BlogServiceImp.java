package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImp implements BlogService{
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog model){
        blogRepository.save(model);
    }

    @Override
    public void remove(int id){
        blogRepository.remove(id);
    }
}
