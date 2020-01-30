package com.wildcodeschool.wildcircus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.wildcircus.entity.Representation;

@Repository
public interface RepresentationRepository extends JpaRepository<Representation, Integer> {

	@Query("SELECT r FROM Representation r WHERE r.date < NOW() ORDER BY r.date DESC")
	List<Representation> findPast();
	
	@Query("SELECT r FROM Representation r WHERE r.date >= NOW() ORDER BY r.date ASC")
	List<Representation> findFuture();
	
}
