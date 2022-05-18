package com.example.storeeverything.repositories;

import com.example.storeeverything.models.Information;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InformationRepository extends CrudRepository<Information, Long> {

    Optional<Information> findById(Long id);

    Optional<Information> findByCategory(@Param("Category") String Category);

}
