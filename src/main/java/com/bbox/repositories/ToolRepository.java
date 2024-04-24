package com.bbox.repositories;

import com.bbox.domain.Tool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ToolRepository extends JpaRepository<Tool, UUID> {
    @Query(value = "SELECT * FROM tools WHERE ?1 = ANY(tags)", nativeQuery = true)
    List<Tool> findByTag(String tag);
}
