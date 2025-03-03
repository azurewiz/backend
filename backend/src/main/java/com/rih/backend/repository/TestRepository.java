package com.rih.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rih.backend.model.TestEntity;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
