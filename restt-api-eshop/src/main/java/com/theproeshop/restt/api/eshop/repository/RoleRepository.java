package com.theproeshop.restt.api.eshop.repository;

import com.theproeshop.restt.api.eshop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
    void deleteByName(String name);
}
