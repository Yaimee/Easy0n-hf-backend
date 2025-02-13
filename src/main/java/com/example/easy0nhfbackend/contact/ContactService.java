package com.example.easy0nhfbackend.contact;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository repository;

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact %d not found".formatted(id)));
    }

    public Contact add(Contact contact){
        return repository.save(contact);
    }

    public Contact update(Long id, Contact object, boolean partial){
        Optional<Contact> temp =  repository.findById(id)
                .map(oldItem -> {
                    return repository.save(oldItem.updateFrom(object, partial));
                });
        return temp.orElseThrow(() -> new RuntimeException("%s %d not found".formatted(id)));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
