package com.SpringHotel.repository;

import com.SpringHotel.entity.ERole;
import com.SpringHotel.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}