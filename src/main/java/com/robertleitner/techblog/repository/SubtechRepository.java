package com.robertleitner.techblog.repository;

import com.robertleitner.techblog.model.Subtech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubtechRepository extends JpaRepository<Subtech, Long> {
}
