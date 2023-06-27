package com.musicworld.musicworld.repository;

import com.musicworld.musicworld.model.AppUser;
import org.springframework.stereotype.Repository;

@Repository
public class AppUserRepository extends ParentRepository<AppUser> {
    @Override
    public String getEntityName() {
        return AppUser.class.getSimpleName();
    }
}