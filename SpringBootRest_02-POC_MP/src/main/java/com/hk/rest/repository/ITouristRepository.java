package com.hk.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hk.rest.model.Tourist;

public interface ITouristRepository extends JpaRepository<Tourist, Integer> {

}
