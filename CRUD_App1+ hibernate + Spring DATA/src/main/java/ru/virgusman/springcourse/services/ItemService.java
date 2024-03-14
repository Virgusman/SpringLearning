package ru.virgusman.springcourse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.virgusman.springcourse.models.Person;
import ru.virgusman.springcourse.repositories.ItemsRepository;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public void findByItemName(String itemName){
        itemsRepository.findByItemName(itemName);
    }

    public void findByOwner(Person owner){
        itemsRepository.findByOwner(owner);
    }



}
