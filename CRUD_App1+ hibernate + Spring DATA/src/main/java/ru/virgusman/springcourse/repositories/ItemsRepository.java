package ru.virgusman.springcourse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virgusman.springcourse.models.Item;
import ru.virgusman.springcourse.models.Person;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    void findByItemName(String itemName);

    void findByOwner(Person owner);
}
