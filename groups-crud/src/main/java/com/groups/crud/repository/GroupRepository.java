package com.groups.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.groups.crud.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByName(String name);
}