package ru.virgusman.springcourse.FirstRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virgusman.springcourse.FirstRestApp.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
