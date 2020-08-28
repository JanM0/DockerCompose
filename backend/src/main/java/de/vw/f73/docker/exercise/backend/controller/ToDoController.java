package de.vw.f73.docker.exercise.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.vw.f73.docker.exercise.backend.entity.ToDo;
import de.vw.f73.docker.exercise.backend.repository.ToDoRepository;

@RestController
@RequestMapping("/api/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository repo;

    @GetMapping
    private String getCount() {
        return String.format("Sie haben %d gespeichert!", repo.count());
    }

    @GetMapping("/all")
    private List<ToDo> getAll() {
        return repo.findAll();
    }

    @PostMapping
    private ToDo postNewToDo(){
        ToDo todo = new ToDo();
        todo.setName("Foobar " + repo.count());
        return repo.save(todo);
    }

}