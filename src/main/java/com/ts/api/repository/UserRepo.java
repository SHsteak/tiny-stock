package com.ts.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ts.api.Entity.UserEntity;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
}
