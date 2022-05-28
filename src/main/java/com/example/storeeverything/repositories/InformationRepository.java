package com.example.storeeverything.repositories;

import com.example.storeeverything.models.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InformationRepository extends JpaRepository<Information, Long> {

/*    Optional<Information> findById(Long id);

    Optional<Information> findByCategory(@Param("Category") String category);

    Optional<Information> findInformationByUser(@Param("User") String user);

    Optional<Information> getAllByUserId(@Param("User_id") Long userID);*/

    Optional<Information> findById(Long id);

    Information findByCategory(@Param("Category") String category);

    Information findInformationByUser(@Param("User") String user);

    Information getAllByUserId(@Param("User_id") Long userID);
    /*List<Information> findByOrderByCategoryDesc(@Param("Category") String category);*/

}
