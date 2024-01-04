package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.TodoRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository theTodoRepository) {
        todoRepository = theTodoRepository;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo findById(int theId) {
        Optional<Todo> result = todoRepository.findById(theId);

        Todo theTodo = null;

        if (result.isPresent()) {
            theTodo = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theTodo;
    }

    @Override
    public Todo save(Todo theTodo) {
        return todoRepository.save(theTodo);
    }

    @Override
    public void deleteById(int theId) {
        todoRepository.deleteById(theId);
    }


}






