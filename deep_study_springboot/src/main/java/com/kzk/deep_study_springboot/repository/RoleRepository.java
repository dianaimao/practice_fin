package com.kzk.deep_study_springboot.repository;

import com.kzk.deep_study_springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
