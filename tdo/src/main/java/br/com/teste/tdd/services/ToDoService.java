package br.com.teste.tdd.services;

import org.springframework.stereotype.Service;
import br.com.teste.tdd.repositories.ToDoRepository;
import br.com.teste.tdd.model.ToDo;
import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo findById(long toDoId) {
        return toDoRepository.findById(toDoId).orElse(new ToDo());
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo); // implementa o upsert
    }

    public List<ToDo> saveAll(List<ToDo> toDoList) {
        return toDoRepository.saveAll(toDoList);
    }

    public void deleteById(long toDoId) {
        toDoRepository.deleteById(toDoId);
    }
}