package com.telnet.api.service;

import com.telnet.api.model.Backend;
import com.telnet.api.repository.BackendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackendService {
    private final BackendRepository backendRepository;

    @Autowired
    public BackendService(BackendRepository backendRepository) {
        this.backendRepository = backendRepository;
    }

    public Backend addBackend(Backend backend) {
        return this.backendRepository.save(backend);
    }

    public List<Backend> listBackend() {
        return this.backendRepository.findAll();
    }
}
