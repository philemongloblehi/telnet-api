package com.telnet.api.service;

import com.telnet.api.model.Backend;
import com.telnet.api.repository.BackendRepository;
import org.apache.commons.net.telnet.TelnetClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@EnableAsync
@EnableScheduling()
public class TelnetService {
    private final BackendRepository backendRepository;

    @Autowired
    public TelnetService (BackendRepository backendRepository) {
        this.backendRepository = backendRepository;
    }

    @Async
    @Scheduled(fixedDelay = 30000)
    public void execute() {
        TelnetClient client = null;

        List<Backend> backendList = this.backendRepository.findAll();

        for (Backend backend : backendList) {
            try{
                client = new TelnetClient();
                client.setConnectTimeout(3000);
                client.connect(backend.getHost(), backend.getPort());
                backend.setRunning(true);
            } catch (IOException e){
                backend.setRunning(false);
//                throw new RuntimeException("Unable connect to : " + backend.getHost() + ":" + backend.getPort());
            } finally {
                this.backendRepository.save(backend);
                try {
                    if (client != null){
                        client.disconnect();
                    }
                } catch (IOException ex){
                    throw new RuntimeException("Error disconnect to : " + backend.getHost() + ":" + backend.getPort());
                }
            }
        }

        System.out.println("Finish");


    }
}
