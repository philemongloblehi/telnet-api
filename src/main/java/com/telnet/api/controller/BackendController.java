package com.telnet.api.controller;

import com.telnet.api.model.Backend;
import com.telnet.api.service.BackendService;
import com.telnet.api.service.TelnetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rest/backend")
public class BackendController {
    private final BackendService backendService;
    private final TelnetService telnetService;

    @Autowired
    public BackendController(BackendService backendService, TelnetService telnetService) {
        this.backendService = backendService;
        this.telnetService = telnetService;
    }

    @GetMapping
    public List<Backend> list() {
        return this.backendService.listBackend();
    }

    @PostMapping
    public Backend add(@RequestBody Backend backend) {
        return this.backendService.addBackend(backend);
    }
}
