package com.reptithcm.edu.demo_unittest.repository;

import com.reptithcm.edu.demo_unittest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
