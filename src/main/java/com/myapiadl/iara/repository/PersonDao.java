package com.myapiadl.iara.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.myapiadl.iara.entity.Person;

public interface PersonDao extends JpaRepository<Person, Long>{

 }
