package com.rih.backend.service;

import com.rih.backend.model.TestEntity;
import com.rih.backend.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public List<TestEntity> getAllData() {
        return testRepository.findAll();
    }
}

