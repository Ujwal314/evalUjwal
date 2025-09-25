package com.example.repository;

import com.example.entity.UserUjwal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryUjwal extends JpaRepository<UserUjwal,Long> {
}
