package ru.virgusman.springcourse.FirstRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.virgusman.springcourse.FirstRestApp.models.Person;
import ru.virgusman.springcourse.FirstRestApp.services.PersonService;
import ru.virgusman.springcourse.FirstRestApp.util.PersonErrorResponse;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public List<Person> getPeople() {
        return personService.findAll();  //Jackson конвертирует объекты в JSON
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return personService.findOne(id);   //Jackson конвертирует в JSON
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException() {
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this id wasn't found",
                System.currentTimeMillis()
        );

        //в HTTP овтете тело ответа (response) и статус в заголовке
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
