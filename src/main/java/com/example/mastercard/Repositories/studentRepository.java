package com.example.mastercard.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.mastercard.Models.Students;

@Repository
public interface studentRepository extends CrudRepository<Students, Integer> {
}