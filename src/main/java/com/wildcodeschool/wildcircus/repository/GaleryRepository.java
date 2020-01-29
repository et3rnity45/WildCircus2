package com.wildcodeschool.wildcircus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.wildcircus.entity.Galery;

@Repository
public interface GaleryRepository extends JpaRepository<Galery, Integer> {

}
