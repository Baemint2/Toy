package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Todo;
import com.luv2code.springboot.thymeleafdemo.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService theTodoService) {
        todoService = theTodoService;
    }

    // add mapping for "/list
    @GetMapping("/")
    public String showHome(){

        return "home";
    }

    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }

    // todo 홈
    @GetMapping("/todos")
    public String listTodos(Model theModel) {
        // get the todos form db
        List<Todo> theTodos = todoService.findAll();

        theModel.addAttribute("todos");
        // add to the spring model
        theModel.addAttribute("todos", theTodos);

        return "todos/list-todos";
        }


    // todo 추가
    @GetMapping("/todos/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        //create model attribute to bind form data
        Todo theTodo = new Todo();
        theModel.addAttribute("todo", theTodo);

        return "todos/todo-form";
    }


    // todo 업데이트
    @GetMapping("/todos/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("todoId") int theId, Model theModel) {

        //get the employee from the service
        Todo theTodo = todoService.findById(theId);

        // set employee in the model to prepopulate the form
        theModel.addAttribute("todo", theTodo);

        // send over to our form
        return "todos/todo-form";
    }

    // todo 삭제
    @GetMapping("/todos/delete")
    public String delete(@RequestParam("todoId") int theId) {
        todoService.deleteById(theId);

        return "redirect:/todos";
    }
    @PostMapping("/todos/save")
    public String saveTodo(@ModelAttribute("todo") Todo theTodo) {

        //save the employee
        todoService.save(theTodo);

        // use a redirect to prevent duplicate submissions
        return "redirect:/todos";
    }
}
