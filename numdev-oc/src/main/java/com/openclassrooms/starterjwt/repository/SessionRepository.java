package com.openclassrooms.starterjwt.repository;

import com.openclassrooms.starterjwt.models.Session;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository  extends JpaRepository<Session, Long> {
	
	public List<Session> findAll();
	
	public Optional<Session> findById(Long id);
	
	@SuppressWarnings("unchecked")
	public Session save(Session session);
}
