package com.asif.cc_summer.repository;

import com.asif.cc_summer.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<UserEntity, Long> {
}
