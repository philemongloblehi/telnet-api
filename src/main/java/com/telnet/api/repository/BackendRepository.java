package com.telnet.api.repository;

import com.telnet.api.model.Backend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackendRepository extends JpaRepository<Backend, Long> {
}
