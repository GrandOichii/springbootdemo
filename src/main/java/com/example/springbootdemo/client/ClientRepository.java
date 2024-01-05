package com.example.springbootdemo.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT s FROM Client s WHERE s.username = ?1")
    Optional<Client> findClientByUsername(String username);
}
