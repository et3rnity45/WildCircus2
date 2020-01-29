package com.wildcodeschool.wildcircus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.wildcircus.entity.Presentation;

@Repository
public interface PresentationRepository extends JpaRepository<Presentation, Integer> {

}
