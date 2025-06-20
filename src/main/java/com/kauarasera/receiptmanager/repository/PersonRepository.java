package com.kauarasera.receiptmanager.repository;

import com.kauarasera.receiptmanager.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByFirstNameContainingIgnoreCase(String firstName);
    List<Person> findByFirstNameContainingIgnoreCaseOrCpfContainingIgnoreCase(String name, String cpf);
}