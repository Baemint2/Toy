package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface TodoService {

    List<Todo> findAll();

    Todo findById(int theId);

    Todo save(Todo theTodo);

    void deleteById(int theId);


}
