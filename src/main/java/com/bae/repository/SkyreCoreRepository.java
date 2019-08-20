package com.bae.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.entity.User;

@Repository
public interface SkyreCoreRepository extends JpaRepository<User, Long>{

}
